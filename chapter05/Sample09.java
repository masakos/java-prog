package chapter05;

public class Sample09 {
    // int型配列を受け取り、すべての要素に０をセットするメソッド
    public static void fillWithZero(int[] array) {
        for(int i = 0; i < array.length; i++){
            array[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };

        for(int value: array){
            System.out.println(value);
        }

        fillWithZero(array); // 配列を渡す

        System.out.println("メソッドを呼び出した後の配列の中身を表示する");
        for(int value: array){
            System.out.println(value);
        }
    }

}
