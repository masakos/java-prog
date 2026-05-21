package chapter02;

public class Sample1 {
    public static void main(String[] args) {

        // エスケープシーケンスを用いた例
        System.out.println("Hello, \"world\""); // ダブルクォーテーションを表示

        // 改行を含む文字列の例
        System.out.println("Hello, \nworld!"); // 改行を含む文字列
        // テキストブロックを用いた例
        String textBlock = """
                Hello, "world"
                masako
                sugita
                """;
        System.out.println(textBlock); // テキストブロックの内容を表示

        // インクリメント演算子
        int a = 5;
        System.out.println(a++); // 後置インクリメント: 5が表示
        System.out.println(a); // 6が表示
        int b = 5;
        System.out.println(++b); // 前置インクリメント: 6が表示
        System.out.println(b); // 6が表示
        // デクリメント演算子
        int c = 5;
        System.out.println(c--); // 後置デクリメント: 5が表示
        System.out.println(c); // 4が表示
        int d = 5;
    }
}
