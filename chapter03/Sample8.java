package chapter03;

public class Sample8 {
    public static void main(String[] args) {

        while (true) { // 条件が常にtrue → 無限ループ
            System.out.print("名前を入力してください（空のままEnterで終了）: ");
            String name =  new java.util.Scanner(System.in).nextLine();

            if (name.isEmpty()) { // 空文字ならループを終了
                break;
            }
            System.out.println("こんにちは、" + name + "さん！");
        }

        System.out.println("プログラムを終了します");
    }
}
