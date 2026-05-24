package chapter03;

public class Kadai05 {
    public static void main(String[] args) {
        /*
         * 年齢を入力し、
         * 
         * 18歳以上 かつ 65歳未満 → 「一般料金」
         * 18歳未満 または 65歳以上 → 「割引料金」
         * 
         * と表示するプログラムを作成してください。
         */
        System.out.println("年齢を入力してください");
        int age = new java.util.Scanner(System.in).nextInt();
        if (age >= 18 && age < 65) {
            System.out.println("一般料金");
        } else {
        //  }else if(age < 18 || age >= 65){
            System.out.println("割引料金");
        }
    }
}

/*
(1) age >= 18 && age < 65 であれば、それ以外は自動的にage < 18 || age >= 65 になるため、elseで十分。
(2) もし最初の条件を変更したとき、else if(age <= 18 || age >= 65) も修正する必要があるため、漏れが発生する可能性があります。
(3) elseだけなら「最初の条件以外なんだな」とすぐわかります。
 */
