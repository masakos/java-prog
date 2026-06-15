package chapter04;

public class Sample13 {
    public static void main(String[] args) {
        // バブルソート
        int[] data = { 5, 3, 1, 4, 2 };
        

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {

                if (data[j] > data[j + 1]) {

                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
