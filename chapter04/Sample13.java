package chapter04;

public class Sample13 {
    public static void main(String[] args) {
        /* バブルソート
           隣同士の数字を比較し、順番が逆だったら交換する処理を繰り返して並べ替える方法です。
           1周すると一番大きい数字が右端に移動します。
           そのため、何周も繰り返すことで、小さい順（または大きい順）に並べ替えることができます。
           実装が簡単ですが、要素の個数をnとすると、必ず n(n - 1)/2 回のスキャンが必要になります。
        */

        int[] data = { 5, 3, 1, 4, 2 };

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {

                if (data[j] > data[j + 1]) {
                    int temp = data[j];  // 交換するときの一時保存場所
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
