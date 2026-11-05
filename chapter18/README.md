## ゴール

これまでのプログラムは、データをすべて **プログラムの中に直接書いて** いました。
今日は、プログラムの **外** にあるデータを使えるようにします。

| やること | データがある場所 |
| --- | --- |
| ① ファイルを読み書きする | 自分のPCの中のファイル |
| ② インターネットにアクセスする | インターネット上のサーバー |
| ③ データベースにアクセスする | データベース |

そして、読み込んだデータを **ArrayList に入れて一覧表示** します。

---

## 3つに共通する流れ

場所はちがっても、やることの流れは同じです。

```
① 開く（接続する）
② 読む / 書く
③ 閉じる
```

- 「閉じる」を忘れると、ファイルが保存されなかったり、接続が残ったままになったりします。
  **使い終わったら必ず閉じる** と覚えておきましょう。

---

## 準備：`throws Exception` について（今日はおまじないでOK）

今日のサンプルでは、`main` メソッドに `throws Exception` が付いています。

```java
public static void main(String[] args) throws Exception {
```

- ファイルやインターネット、データベースを使う処理は、うまくいかないことがある 処理です。
  - 例：ファイルが見つからない、ネットにつながっていない、など
- Javaでは、このような「うまくいかなかったときどうするか」を考えておかないと、コンパイルエラー になります。
- `throws Exception` は「うまくいかなかったら、プログラムを止めてエラーを表示していいよ」という意味です。
- このしくみを 例外（れいがい） といいます。詳しくは次回 やります。

今日は「外部とやりとりするときは `throws Exception` を付ける」と覚えておけばOKです。

---

## 準備：実行する場所に注意

サンプルは、これまで通り **リポジトリのいちばん上のフォルダ（`chapter18` フォルダがある場所）** で実行してください。

```
javac chapter18/file/Sample01.java
java chapter18.file.Sample01
```

プログラムの中で `"chapter18/data/books.csv"` のようにファイルの場所を書いていますが、
これは 「今いるフォルダから見た場所」 です（相対パスといいます）。
別のフォルダで実行すると「ファイルが見つからない」エラーになります。

---

## フォルダ構成

```
chapter18
├─ data
│   └─ books.csv        … サンプルで使うデータ
├─ file                 … ① ファイルの読み書き
│   ├─ Book.java
│   ├─ Sample01.java    … ファイルを読んで表示
│   ├─ Sample02.java    … ファイルに書き込む
│   └─ Sample03.java    … CSVを読んで Book の一覧を表示
├─ net                  … ② インターネット
│   ├─ Book.java
│   ├─ Sample01.java    … Webページを読んで表示
│   └─ Sample02.java    … ネット上のCSVを読んで Book の一覧を表示
├─ db                   … ③ データベース
│   ├─ Book.java
│   ├─ Sample01.java    … テーブルを作ってデータを登録
│   └─ Sample02.java    … データを取り出して Book の一覧を表示
└─ lib                  … データベース用のドライバ（jarファイル）を置く
```

`Book` クラスは、タイトルと価格を持つだけのシンプルなクラスです。

```java
public class Book {
    private String title;
    private int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() { return title; }
    public int getPrice() { return price; }
}
```

`data/books.csv` の中身はこうなっています。

```
Java入門,3000
はじめてのSQL,2500
ネットワークの基本,2800
```

CSV（シーエスブイ）は、**値を `,`（カンマ）で区切って並べた** テキストファイルです。
Excelでも開くことができ、データのやりとりによく使われます。

