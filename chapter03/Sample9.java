package chapter03;

public class Sample9 {
    public static void main(String[] args) {

        // 0から9のうち偶数だけ表示する（奇数はcontinueでスキップ）
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) { // 奇数なら
                continue;     // この回をスキップして次のループへ
            }
            System.out.println("i = " + i);
        }

        System.out.println("終了");
    }
}
