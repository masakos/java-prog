package chapter17;

// 例外が起きるとどうなるかを見てみる
public class Sample01 {
    public static void main(String[] args) {
        System.out.println("計算を始めます");

        int a = 10;
        int b = 0;

        // ① 0で割ると「ArithmeticException（計算の例外）」が起きる
        int result = a / b;

        // ② 例外が起きると、プログラムはそこで止まってしまう
        //    → この下の行は実行されない
        System.out.println("結果：" + result);
        System.out.println("計算を終わります");
    }
}
