
## チャレンジ問題

以下のメソッドを作成して、mainメソッドから呼び出してください。

| メソッド名      | 戻り値     | 引数                        | 処理               |
| ---------- | ------- | ------------------------- | ---------------- |
| getMax     | int     | int[] numbers             | 最大値を返す           |
| getMin     | int     | int[] numbers             | 最小値を返す           |
| getSum     | int     | int[] numbers             | 合計を返す            |
| getAverage | double  | int[] numbers             | 平均を返す            |
| countEven  | int     | int[] numbers             | 偶数の個数を返す         |
| countOdd   | int     | int[] numbers             | 奇数の個数を返す         |
| contains   | boolean | int[] numbers, int target | 値が含まれるか調べる       |
| findIndex  | int     | int[] numbers, int target | 最初に見つかった位置を返す    |
| reverse    | int[]   | int[] numbers             | 配列を逆順にした新しい配列を返す |
| copyArray  | int[]   | int[] numbers             | 配列をコピーする         |

### チャレンジ問題のヒント
- reverse:
    - 元の配列と同じ長さの新しい配列を作ろう。
    - for文で先頭から順番に処理しよう。
    - 新しい配列の i 番目には、元の配列のどの位置の値を入れればよいか考えよう。
    - 配列の最後の要素の添字は numbers.length - 1 で表せる。
- copyArray:
    - 元の配列と同じ長さの新しい配列を作ろう。
    - for文を使って配列の先頭から順番に処理しよう。
    - result の i 番目には、numbers の何番目の値を代入すればよいか考えよう。