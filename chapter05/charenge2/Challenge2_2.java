package chapter05.charenge2;

public class Challenge2_2 {
    public static void main(String[] args) {
        String str = "racecar";
        if (isPalindrome(str)) {
            System.out.println(str + "は回文です。");
        } else {
            System.out.println(str + "は回文ではありません。");
        }

    }


    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
            System.out.println("left: " + left + ", right: " + right);
        }
        return true;
    }

    

}
