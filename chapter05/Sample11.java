package chapter05;

// 値渡しのサンプル
public class Sample11 {
    public static void main(String[] args) {
        int a = 10;
        change(a);

        // 変数aのはかわらない
        System.out.println("a=" + a);

    }

    public static void change(int num){
        num = 20;
    }
}
