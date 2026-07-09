package chapter05.kadai;

public class Kadai02 {

    // 18歳以上かどうかを判定するメソッド
    public static boolean isAdult(int age) {
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // 引数に20を渡してメソッドを呼び出す
        boolean result = isAdult(20);

        // 戻り値を表示
        System.out.println(result);
    }
}
