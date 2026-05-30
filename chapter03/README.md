
##  アルゴリズムとは
-  問題を解決する手順のこと
  - （例）カップラメーンを作るには？
    - 順次プログラム
  - ただし、現実は一本道ではなく、晴れたら洗濯するなど、条件によって行動が変わる
    - 条件によって処理が変わることを「分岐」という


## フローチャート
- 分岐のある手順は、図で表すと分かりやすい
- フローチャートとは、いくつかの記号を用いてアルゴリズムを表すもの

![朝の始まり](../img/flow-chart.png)

- よく使う共通記号

| 記号   | 意味       |
| ------ | ---------- |
| 楕円   | 開始・終了 |
| 長方形 | 処理       |
| ひし形 | 条件分岐   |
| 矢印   | 流れ       |

### フローチャートを書くツール
  - draw.io（diagrams.net）[https://app.diagrams.net/](https://app.diagrams.net/)
  - https://www.mermaidonline.live/

####  mermaid: 文字だけで図やフローチャートを書ける記法
```
flowchart TD

A[開始] --> B[天気を確認する]
B --> C{晴れですか？}

C -->|はい| D[散歩をする]
C -->|いいえ| E[映画を見る]

D --> F[終了]
E --> F
```


=> **プログラムの作成は、アルゴリズムをコンピュータが実行できる形で記述すること**


## 分岐 - if文
```
if (条件式){
  条件成立のときに実行する処理
} else {
  条件不成立のときに実行する処理
}
```

```java
public class Main {
    public static void main(String[] args) {
        boolean tenki = true;
        if (tenki == true) {
            System.out.println("散歩をする");
        } else {
            System.out.println("映画をみる");
        }
    }
}
```

### 条件式とは
- if文で利用する式の１つ
- 処理を分岐する条件を表現するもの


| 演算子 | 意味 | 例 | 結果 |
|---|---|---|---|
| `==` | 等しい | `a == b` | aとbが同じならtrue |
| `!=` | 等しくない | `a != b` | aとbが違えばtrue |
| `>` | より大きい | `a > b` | aがbより大きければtrue |
| `<` | より小さい | `a < b` | aがbより小さければtrue |
| `>=` | 以上 | `a >= b` | aがb以上ならtrue |
| `<=` | 以下 | `a <= b` | aがb以下ならtrue |

### 例題
- 変数：scoreを宣言し、socreが８０以上なら合格と表示し、８０未満なら不合格と表示するプログラムを作成してください。


### 文字列の比較
```
文字列型の変数.equals(比較する文字列);
```

```
public class Main {
    public static void main(String[] args) {
        String answer = "はい";

        if (answer.equals("はい")) {
            System.out.println("OKが選ばれました");
        } else {
            System.out.println("OK以外が選ばれました");
        }
    }
}
```



### if文
もし雨なら傘を持っていく

```
if (条件式){
  条件成立のときに実行する処理
}
```

```java
public class Main {
    public static void main(String[] args) {
        boolean rain = true;
        if (rain == true) {
            System.out.println("傘をもっていく");
        }
    }
}
```

### if -else if - else文
```java
if (条件式){
  条件成立のときに実行する処理
} else if(条件式) {
  条件成立のときに実行する処理
} else {
  条件不成立のときに実行する処理
}
```

```java
public class Main {
    public static void main(String[] args) {
        int hp = 15; // hit point

        if (hp >= 80) {
            System.out.println("元気");
        } else if (hp >= 30) {
            System.out.println("弱っている");
        } else {
            System.out.println("危険");
        }
    }
}
```


## 条件式 `&&` と `||`

| 演算子 | 意味 | 例 | 結果 |
|---|---|---|---|
| `&&` | かつ（AND） | `a > 0 && a < 10` | 両方の条件がtrueならtrue |
| `\|\|` | または（OR） | `a == 0 \|\| a == 1` | どちらかがtrueならtrue |


```java
int age = 20;

if (age >= 18 && age <= 64) {
    System.out.println("大人料金です");
}
```



## swich文

#### switchの基本構文
```java
switch (条件値){
    case 値1 -> {
        処理1
    }
    case 値2 -> {
        処理2
    }
     ..省略..
    default -> {
        処理X
    }
}
```


```java
public class Main {
    public static void main(String[] args) {
        //switch文を使うとすっきりします!
        System.out.println("あなたの運勢を占います");
        fortune = new java.util.Random().nextInt(4) + 1;
        switch (fortune) {
            case 1-> {
                System.out.println("大吉");
            }
            case 2-> {
                System.out.println("中吉");
            }
            case 3-> {
                System.out.println("吉");
            }
            default -> {
                System.out.println("凶");
            }
        }
    }
}
```

**switch文に書き換えられる条件**
- 条件①：等価比較（==）であること
    - 〇（書き換え可）： `if (x == 1)` や `if (x.equals("A"))` のような「同じかどうか」の比較。
    - ×（書き換え不可）： `if (x > 10)` や `if (x <= 0)` などの大小比較（不等号）、および `if (x != 5)` などの否定文。

- 条件②：比較対象が「1つの同じ変数」であること
  - ×（書き換え不可）
    ```java
    if (score >= 80 && age < 20) { ... } // 複数の変数が登場するのでNG
    ```

- 条件③：変数のデータ型が switch 対応していること
    - **使える型（〇）：**
        *   整数型（`int`, `byte`, `short`, `char`） ※`long` は使えません
        *   文字列型（`String`） ※Java 7以降
    - **使えない型（×）：** 小数点（`double`, `float`）、真偽値（`boolean`）


## 伝統的なswitch文の例
- `break` があることに注意!

```java
public class Sample3 {
    public static void main(String[] args) {
        System.out.println("あなたの運勢を占います");
        int fortune = new java.util.Random().nextInt(4) + 1;
        System.out.println("fortune = " + fortune);

        switch (fortune) {
            case 1:
                System.out.println("大吉");
                break;
            case 2:
                System.out.println("中吉");
                break;
            case 3:
                System.out.println("吉");
                break;
            default:
                System.out.println("凶");
                break;
        }
    }
}
```

## 繰り返し
## while文

### 基本構文

```java
while(条件式){
    処理
}
```

```java
int count = 0;
while(count < 3) {
    System.out.println("hello");
    count++;
}
```

### do-while文

```java
do {
    処理
} while (条件);
```

- 先に処理を実行
- 後で条件判定
- 条件が false でも最低1回は実行される。


## for文

繰り返す回数が決まっているときに使う。

### 基本構文

```java
for (初期化; 条件式; 更新) {
    処理
}
```

| 部分 | 役割 | 例 |
|------|------|-----|
| 初期化 | 最初に1回だけ実行 | `int i = 0` |
| 条件式 | trueの間ループを続ける | `i < 5` |
| 更新 | 1回の処理の後に実行 | `i++` |

> プログラムでは0から数えることが多い。`i = 0; i < 5` で0〜4の5回ループになる。

```java
for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}
```

→ サンプル：[Sample6.java](Sample6.java)


## 変数のスコープ

「スコープ」とは、変数が使える範囲のこと。
`{}` のブロック内で宣言した変数は、そのブロック内でしか使えない。

```java
int total = 0; // mainメソッド全体で使える

for (int i = 0; i < 5; i++) {
    // i はこのブロック内だけで使える
    total += i;
}

// System.out.println(i); // ← エラー！iはブロックの外では使えない
System.out.println("合計 = " + total); // total はここでも使える
```

→ サンプル：[Sample7.java](Sample7.java)


## while文とfor文の使い分け

| | while文 | for文 |
|---|---|---|
| 向いている場面 | 繰り返す回数が決まっていないとき | 繰り返す回数が決まっているとき |
| 例 | ユーザーが「終了」を入力するまで繰り返す | 1〜10まで順番に処理する |

```java
// while文
int i = 0;
while (i < 3) {
    System.out.println("hello");
    i++;
}

// for文
for (int i = 0; i < 3; i++) {
    System.out.println("hello");
}
```


## 無限ループ

`while(true)` と書くと、条件が常に `true` なので永遠に繰り返す。

```java
while (true) {
    System.out.println("ずっと繰り返す");
}
```

> 無限ループのままだとプログラムが終わらないので、`break` で抜け出す必要がある。


## break

ループを途中で抜け出す命令。

```java
while (true) {
    System.out.println("処理中");
    break; // ここでループを終了する
}
System.out.println("ループを抜けた");
```


## 無限ループ + if + break パターン

**whileで無限ループを作り、if文でタイミングを判断し、breakで終了させる**というパターン。
入力の終了をチェックするときによく使われる。


→ サンプル：[Sample8.java](Sample8.java)


## continue

ループの残りの処理をスキップして、次の繰り返しに進む命令。
`break` はループを終了するが、`continue` はループを続けたまま現在の回だけスキップする。

```java
for (int i = 0; i < 5; i++) {
    if (i == 2) {
        continue; // i が 2 のときだけスキップ
    }
    System.out.println("i = " + i);
}
// 出力：0, 1, 3, 4（2だけ飛ばされる）
```

### breakとcontinueの違い

| 命令 | 動作 |
|------|------|
| `break` | ループを完全に終了する |
| `continue` | その回だけスキップして次の繰り返しへ進む |

```java
// 偶数だけ表示する（奇数はスキップ）
for (int i = 0; i < 10; i++) {
    if (i % 2 != 0) { // 奇数なら
        continue;     // スキップして次へ
    }
    System.out.println("i = " + i);
}
```

→ サンプル：[Sample9.java](Sample9.java)


## 制御構造のネスト（入れ子）

`{}` の中にさらに制御構造（if文・for文・while文）を書くことができる。
これを**ネスト（入れ子）** という。

### パターン1：for の中に if（Sample9.java）

```java
for (int i = 0; i < 10; i++) {   // 外のfor
    if (i % 2 != 0) {             // 中のif
        continue;
    }
    System.out.println("i = " + i);
}
```

### パターン2：for の中に for

内側のforは、外側のforが1回まわるたびに**最初からすべて実行される**。

```java
for (int i = 0; i < 3; i++) {        // 外のfor（行）
    for (int j = 0; j < 3; j++) {    // 内のfor（列）
        System.out.print("(" + i + "," + j + ") ");
    }
    System.out.println(); // 1行終わったら改行
}
```

出力：
```
(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)
(2,0) (2,1) (2,2)
```

### 実用例：九九の表

```java
for (int i = 1; i <= 9; i++) {        // 外のfor：段（1の段〜9の段）
    for (int j = 1; j <= 9; j++) {    // 内のfor：かける数
        System.out.printf("%3d", i * j);
    }
    System.out.println();
}
```

出力：
```
  1  2  3  4  5  6  7  8  9
  2  4  6  8 10 12 14 16 18
  3  6  9 12 15 18 21 24 27
  ...
```

| 外のループ (i) | 内のループ (j) | 出力（1行分） |
|:-:|---|---|
| 1 | j=1〜9 | `  1  2  3  4  5  6  7  8  9` |
| 2 | j=1〜9 | `  2  4  6  8 10 12 14 16 18` |
| 3 | j=1〜9 | `  3  6  9 12 15 18 21 24 27` |
| ... | ... | ... |

→ サンプル：[Sample10.java](Sample10.java)

