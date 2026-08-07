package chapter05.charenge2;

public class Challenge2_4 {
    public static void main(String[] args) {
        System.out.println(toBinary(10));
    }

    public static String toBinary(int number) {
        if (number == 0) {
            return "0";
        }

        String binary = "";
        while (number > 0) {
            binary = (number % 2) + binary; // 先頭に連結
            number = number / 2;
        }
        return binary;
    }

    public static String toBinaryImproved(int number) {
        if (number == 0) {
            return "0";
        }

        // 文字列の += はループ内で非効率なので、StringBuilderを使う
        // += のたびに新しい文字列オブジェクトが生成sされるため、パフォーマンスが低下する
        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            int r = number % 2;
            binary.insert(0, r); // 先頭に挿入
            number = number / 2;
        }
        return binary.toString();
    }
}
