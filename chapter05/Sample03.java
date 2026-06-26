package chapter05;

public class Sample03 {

    public static void main(String[] args) {
        // 引数を使わないと値をわたせない
        int x = 100;
        int y = 10;
        add();
    }

    public static void add() {
        int ans = x + y;
        System.out.println(x + "+" + y + "=" + ans);
    }
}
