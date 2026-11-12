package chapter17;

// finally：例外が起きても起きなくても、必ず実行される
public class Sample04 {
    public static void main(String[] args) {
        divide(10, 2); // 例外が起きない場合
        System.out.println("-----");
        divide(10, 0); // 例外が起きる場合
    }

    static void divide(int a, int b) {
        try {
            System.out.println("結果：" + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("0で割ることはできません");
        } finally {
            // どちらの場合でも必ず実行される
            // → ファイルやデータベースを閉じるなど「後片付け」に使う
            System.out.println("finally：後片付けをしました");
        }
    }
}
