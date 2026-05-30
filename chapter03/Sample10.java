package chapter03;

public class Sample10 {
    public static void main(String[] args) {

        // for の中に for（ネスト）：九九の表
        // 外のループが1回まわるたびに、内のループが最初からすべて実行される

        for (int i = 1; i <= 9; i++) {        // 外のfor：段（1の段〜9の段）
            for (int j = 1; j <= 9; j++) {    // 内のfor：かける数
                System.out.printf("%3d", i * j);
                // System.out.print(i * j + " ");
            }
            System.out.println(); // 1段分を出力したら改行
        }
    }
}
