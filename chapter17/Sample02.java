package chapter17;

// try-catch で例外をつかまえる
public class Sample02 {
    public static void main(String[] args) {
        System.out.println("計算を始めます");

        int a = 10;
        int b = 0;

        try {
            // ① 例外が起きるかもしれない処理を try の中に書く
            int result = a / b;
            System.out.println("結果：" + result); // 例外が起きると、ここは飛ばされる
        } catch (ArithmeticException e) {
            // ② 例外が起きたら catch の中が実行される
            System.out.println("0で割ることはできません");
            System.out.println("例外の内容：" + e.getMessage());
        }

        // ③ 例外をつかまえたので、プログラムは止まらずに最後まで動く
        System.out.println("計算を終わります");
    }
}
