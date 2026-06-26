package chapter05;

public class Sample10 {

    // 引数sizeで指定した数の配列を作成する
    public static int[] makeArray(int size) {
        int[] newArray = new int[size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = i;
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] array = makeArray(3);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
