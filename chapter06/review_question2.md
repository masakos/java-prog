

- フォルダ名は、review-question2-2600xx(最後の６桁の数字は学籍番号)にしてください。
- ソースコードをコンパイルして、動作を確認した後、2つのJavaファイルと2つのクラスファイルが入ったフォルダをZIP形式にしてください。


## 問題

1週間の気温を調べました。

次の配列には、**1日目から7日目までの気温**が順番に保存されています。

```java
int[] temperatures = {28, 30, 27, 31, 29, 32, 33};
```

つまり、次のような気温を表しています。

| 日   |  気温 |
| --- | --: |
| 1日目 | 28℃ |
| 2日目 | 30℃ |
| 3日目 | 27℃ |
| 4日目 | 31℃ |
| 5日目 | 29℃ |
| 6日目 | 32℃ |
| 7日目 | 33℃ |

この配列を使って、**1週間の気温、平均気温、そして1週間で最も高かった気温**を表示するプログラムを作成しなさい。

## 条件

### 1．ファイルをディレクトリに分ける

プログラムを次のような構成にすること。

```text
review-question2-2600xx
├── Main.java
└── weather
    └── WeatherUtility.java
```

`WeatherUtility.java` は `weather` ディレクトリに作成すること。


### 2．Main.java

`Main.java` に次の配列を作成すること。

```java
int[] temperatures = {28, 30, 27, 31, 29, 32, 33};
```

この配列を `WeatherUtility` の各メソッドに渡して処理すること。



### 3．WeatherUtility.java


`WeatherUtility.java` に次の3つのメソッドを作成すること。

```java
// 1日ごとの気温を表示するメソッド
public static void printTemperatures(int[] temperatures)

// 1週間の平均気温を計算し、double型で返すメソッド
public static double average(int[] temperatures)

// 1週間で最も高かった気温を調べ、その気温をint型で返すメソッド
public static int getMaxTemperature(int[] temperatures)
```



プログラムを実行すると、以下のように表示されること。

```text
=== 1週間の気温 ===

1日目：28度
2日目：30度
3日目：27度
4日目：31度
5日目：29度
6日目：32度
7日目：33度


平均気温：30.0度
最高気温：33度
```
