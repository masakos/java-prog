package chapter05.charenge2;

public class Challenge2_6 {
    static void main(String[] args) {
        System.out.println(gcdEuclid(24, 36));
        System.out.println(gcdEuclid(56, 42));
    }


    public static int gcdEuclid(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return Math.abs(a);
    }

}
