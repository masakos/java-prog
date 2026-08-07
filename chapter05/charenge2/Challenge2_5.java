package chapter05.charenge2;

public class Challenge2_5 {
    public static void main(String[] args) {
        System.out.println(compress("AAAABBBCCAAA"));
    }

    public static String compress(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        char currentChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChar) {
                count++;
            } else {
                compressed.append(currentChar);
                compressed.append(count);
                currentChar = str.charAt(i);
                count = 1;
            }
        }
        // 最後の文字とカウントを追加
        compressed.append(currentChar);
        compressed.append(count);

        return compressed.toString();
    }
}
