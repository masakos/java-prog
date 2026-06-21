

## VS CodeでJavaプロジェクトを開くときの注意点
VS CodeでJavaを開くときは、Javaファイルそのものではなく、そのファイルが入っているプロジェクト（ルートフォルダ）を開く必要があります。

なぜなら、VS Codeはフォルダの構成を見て、下記のことを自動で判断しているからです。

- ソースコードがどこにあるか
- クラスファイルをどこに作るか
- ライブラリがどこにあるか
- パッケージ構成がどうなっているか

そのため、Javaファイルだけを開くと、VS Codeがプロジェクト全体の構成を正しく認識できず、コンパイルや実行でエラーになることがあります。



## package

* packageが正しく設定されているか？
* packageが正しく設定されている状態とはどんな状態か？
    * → package名とフォルダ構成が一致している状態

例

```java
package chapter01;

public class Sample {
    public static void main(String[] args) {
        // ここにコードを書く
    }
}
```

なら

```text
java-prog
 └ chapter01
     └ Sample.java
```

になっている必要があります。

---

## class

* 一番外側のブロックにclassが宣言されているか？
* class名はファイル名と同じになっているか？

例

```java
public class Sample {
}
```

↓

ファイル名

```text
Sample.java
```

---

## mainメソッド

```java
public static void main(String[] args) {
}
```

* classの中にmainメソッドがあるか？
* 波括弧の位置は正しいか？

---

## コードを書く場所

* 実行したいコードはmainメソッドの中に書く

```java
public static void main(String[] args) {
    System.out.println("Hello");
}
```



## 画面に文字を表示する命令

### 文字列

```java
System.out.println("こんにちは");
```

ダブルクォーテーションで囲む

### 変数

```java
String name = "田中";

System.out.println(name);
```

変数名だけを書く

---

### 連結

```java
System.out.println("名前：" + name);
```

+でつなぐ

---

## 変数　

### 1. データを保存するための箱

変数は、数値や文字などのデータを一時的に保存するためのものです。

```java
int age = 20;
String name = "田中";
```

* age に 20 を保存
* name に "田中" を保存


### 2. 型（データ型）が必要

Javaは**型付き言語**です。

変数を作るときに、どの種類のデータを保存するか決めます。

```java
int score = 80;
double height = 170.5;
char grade = 'A';
boolean passed = true;
```

型が違うデータは基本的に入れられません。

```java
int score = "80"; // エラー
```


### 3. 値を後から変更できる

```java
int score = 80;
score = 90;
```

変数名は同じでも、中身は変更できます。


### 4. 変数名にはルールがある

#### 良い例

```java
int score;
String studentName;
```

#### 悪い例

```java
int 1score;      // 数字で始まる
int class;       // 予約語
```


### 5. 宣言してから使う

```java
int score;
score = 80;
```

または

```java
int score = 80;
```

---

### 6. スコープ（使える範囲）がある

変数を宣言する場所によって使える範囲がきまります。

```java
if (true) {
    int x = 10;
}

System.out.println(x); // エラー
```

- if文の中で定義した変数はx は if 文の中だけで使えます。

---

### 7. 同じ名前の変数は同じ範囲では作れない

```java
int score = 80;
int score = 90; // エラー
```

---

### 8. 初期値が異なる

```java
int score;
System.out.println(score); // エラー
```
#### 配列 

自動で初期値が入ります。

```java
int [] scores = new int[3];
System.out.println(scores[0]); // 初期値は0
System.out.println(scores[1]); // 初期値は0
System.out.println(scores[2]); // 初期値は0
```


---

### 9. 基本型と参照型がある

#### 基本型

値そのものを保持

```java
int a = 10;
```

#### 参照型

データの場所（参照）を保持

```java
int[] scores = {80, 90, 100};
String name = "Tanaka";
```
- Stringは参照型でありながら変更不可（immutable）なオブジェクト


### 10. 型推論（var）が使える

Java 10以降

```java
var score = 80;
var name = "Tanaka";
```

コンパイラが型を自動判断します。



## ブロック
プログラムの中で {} で囲まれた部分を「ブロック」といいます。

ブロックは主に

```
class
メソッド
if文
for文
while文
switch文
```

などで作られます。