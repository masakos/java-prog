package chapter05.charenge2;

public class Challenge2_3 {
    static void main(String[] args) {
        System.out.println(gcd(24, 36));
    }

    public static int gcd(int a, int b) {
        int min = Math.min(a, b);

        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
