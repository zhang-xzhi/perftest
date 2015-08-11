package allen.perftest2.date;

import java.util.Calendar;

public class TestCalendar {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        DateGet[] dateGets = new DateGet[200];
        for (int i = 0; i < dateGets.length; i++) {
            dateGets[i] = new DateGet(i);
        }

        for (int i = 0; i < dateGets.length; i++) {
            dateGets[i].start();
        }

        for (int i = 0; i < dateGets.length; i++) {
            dateGets[i].join();
        }

        long end = System.currentTimeMillis();

        System.out.println((end - start) + "ms");
    }

    public static class DateGet extends Thread {
        private int id;

        public DateGet(int id) {
            super();
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                Calendar c = Calendar.getInstance();
                System.out.println(this.id + " " + c);
            }
        }
    }
}
