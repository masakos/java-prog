package chapter2;

public class Lesson2 {
    public static void main(String[] args) {
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

        //  異なる型同士の演算
        double d = 8.5 / 2;
        long l = 5 + 2L;
        System.out.println(d);
        System.out.println(l);

        String msg = "私の年齢は" + 23;
        System.out.println(msg);
    }
    
}
