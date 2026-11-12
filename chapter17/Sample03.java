package chapter17;

// catch を複数書いて、例外の種類ごとに処理を分ける
public class Sample03 {
    public static void main(String[] args) {
        int[] scores = { 80, 90, 70 };

        try {
            // ① 文字列を数値に変換する（"abc" だと NumberFormatException）
            int index = Integer.parseInt("5");

            // ② 配列から取り出す（5番目は無いので ArrayIndexOutOfBoundsException）
            System.out.println("点数：" + scores[index]);

        } catch (NumberFormatException e) {
            // 数値に変換できなかったとき
            System.out.println("数値に変換できません");

        } catch (ArrayIndexOutOfBoundsException e) {
            // 配列の範囲外を指定したとき
            System.out.println("その番号のデータはありません");

        } catch (Exception e) {
            // ③ それ以外のすべての例外（Exception は例外の親クラス）
            //    親クラスの catch は一番最後に書く
            System.out.println("予期しないエラー：" + e.getMessage());
        }

        System.out.println("プログラムを終わります");
    }
}
