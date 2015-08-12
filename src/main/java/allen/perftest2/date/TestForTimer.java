package allen.perftest2.date;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestForTimer {

    static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();

    public static void main(String[] args) throws Exception {
        LineNumberReader lnr = new LineNumberReader(new FileReader(
                "data\\TestForTimer.config"));
        String line = null;
        System.out.println("thread\tloop\ttimeout(ns)\trealtimeout(ns)");
        while ((line = lnr.readLine()) != null) {

            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            if (line.startsWith("#")) {
                continue;
            }

            String[] parts = line.split(",");
            int threadNum = Integer.parseInt(parts[0]);
            int loop = Integer.parseInt(parts[1]);
            long timeout = Long.parseLong(parts[2]);
            runTest(threadNum, loop, timeout);
        }
        lnr.close();
        System.out.println("exit");
    }

    private static void runTest(int threadNum, int loop, long timeout)
            throws Exception {
        System.out.print(threadNum + "\t");
        System.out.print(loop + "\t");
        System.out.print(timeout + "\t");

        long start = System.nanoTime();
        Thread[] ts = new Thread[threadNum];

        for (int i = 0; i < ts.length; i++) {
            ts[i] = new TemThread(loop, timeout);
            ts[i].start();
        }

        for (int i = 0; i < ts.length; i++) {
            ts[i].join();
        }

        long end = System.nanoTime();
        System.out.print(((end - start) * 1D / loop) + "\t");
        System.out.println();
    }

    private static class TemThread extends Thread {
        int  loop;
        long timeout;

        public TemThread(int loop, long timeout) {
            this.loop = loop;
            this.timeout = timeout;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < loop; i++) {
                    queue.poll(timeout, TimeUnit.NANOSECONDS);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
