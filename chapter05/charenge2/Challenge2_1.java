package chapter05.charenge2;

import java.util.Scanner;

public class Challenge2_1 {

    public static void main(String[] args) {

        System.out.println(isPrime(0) ? "0は素数です。" : "0は素数ではありません。");
        System.out.println(isPrime(1) ? "1は素数です。" : "1は素数ではありません。");
        System.out.println(isPrime(17) ? "17は素数です。" : "17は素数ではありません。");
        System.out.println(isPrime(20) ? "20は素数です。" : "20は素数ではありません。");

    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeImproved(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true; // 2, 3 は素数
        }
        // 2で割り切れる場合は素数ではない
        if (number % 2 == 0) {
            return false;
        }

        // √number(ルートnumber)まで判定すればOK
        for (int i = 3; (long) i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
