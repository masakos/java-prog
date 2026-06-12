package chapter04;

public class Sample08 {
    public static void main(String[] args) {
        // int[] arrayA = { 1, 2, 3 };
        // int[] arrayB;
        // arrayB = arrayA;
        // arrayB[0] = 100;
        // System.out.println(arrayA[0]);

        int[] arrayA = new int[3];
        System.out.println("arrayA = " + arrayA);
        //System.out.println(arrayA.toString()); 内部的にはtoString()が呼ばれている。
    }
}



/* arrayB を変更したのに、なぜ arrayA まで変わるの？
配列の変数には配列そのものではなく、配列の場所（アドレス）が入っている
配列の中身をコピーしているのではなく、 配列の場所 をコピーしている。

(int は「値」が入る。)


コンピュータのメモリには

1000番地
1001番地
1002番地
...

のように住所(アドレス）があります。

new をしたときに初めて配列の実体が作られ、その参照（アドレス）が変数 a に入ります。
（ただし、javaでは直接アドレスの値をみることはできない）
*/