package chapter05.kadai;

public class Kadai01 {
    public static int getLength(String text){
        int text_num = text.length();
        return text_num;
    }

    public static void main(String[] args) {
        int test_num = getLength("hello");
        System.out.println(test_num);
    }
    
}
