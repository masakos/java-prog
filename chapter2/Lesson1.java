package chapter2;

public class Lesson1 {
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
            System.out.println(a);   // 6が表示
            int b = 5;
            System.out.println(++b); // 前置インクリメント: 6が表示
            System.out.println(b);   // 6が表示
                // デクリメント演算子
            int c = 5;
            System.out.println(c--); // 後置デクリメント: 5が表示
            System.out.println(c);   // 4が表示
            int d = 5;
            System.out.println(--d); // 前置デクリメント: 4が表示
            System.out.println(d);   // 4が表示
    
            // 値いより大きな型に代入
            int e = 100;
            long f = e; // intからlongへの自動型変換    
            System.out.println(f); // 100が表示
    
            //  値より小さな型に代入（エラー）
            // int i = 3.2; // コンパイルエラー: doubleからintへの代入はできない
    
            // 値より小さな型に代入（キャスト）
            long g = 100L;
            int h = (int) g; // longからintへのキャスト
            System.out.println(h); // 100が表示
    
            int age = (int)3.2;
            System.out.println(age);
    
   } 
}
