package chapter05;

public class Sample11 {
    public static void main(String[] args) {
        int a = 10;
        change(a);

        System.out.println("a=" + a);

    }

    public static void change(int num){
        num = 20;
    }
}
