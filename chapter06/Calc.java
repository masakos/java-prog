package chapter06;

public class Calc {
    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        int total = add(a, b);
        int delta = subtract(a, b);

        System.out.println("total=" + total + " delta=" + delta);
    }

    public static int add(int a, int b) {
        return (a + b);
    }

    public static int subtract(int a, int b) {
        return (a - b);
    }

}
