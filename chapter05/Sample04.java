package chapter05;

public class Sample04 {
    public static int add(int x, int y) {
        int ans = x + y;
        return ans;   // return 変数名
    }

    public static void main(String[] args) {
        int ans = add(100, 10);  // 戻り値を受け取る
        System.out.println("100 + 10 = " + ans);
    }

}
