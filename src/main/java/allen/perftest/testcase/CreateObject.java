package allen.perftest.testcase;

import allen.perftest.AbstractPerfTestCase;

public class CreateObject extends AbstractPerfTestCase {

    static A a;

    @Override
    public void run() {
        a = new A(10, 20);
    }

    @Override
    public String des() {
        return "new A(10, 20).";
    }

    private static class A {
        public int x;
        public int y;

        public A(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "A [x=" + x + ", y=" + y + "]";
        }
    }
}
