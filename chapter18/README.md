## 前回の復習

- `ArrayList` は、あとから好きなだけデータを追加できる「伸び縮みする配列」
- `add()` で追加、`get()` で取り出し、`size()` で個数
- 拡張for文で1つずつ取り出せる

```java
ArrayList<String> names = new ArrayList<String>();
names.add("たなか");
names.add("すずき");

for (String name : names) {
    System.out.println(name);
}
```

---

## 今日のゴール

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

- ファイルやインターネット、データベースを使う処理は、**うまくいかないことがある** 処理です。
  - 例：ファイルが見つからない、ネットにつながっていない、など
- Javaでは、このような「うまくいかなかったときどうするか」を考えておかないと、**コンパイルエラー** になります。
- `throws Exception` は「うまくいかなかったら、プログラムを止めてエラーを表示していいよ」という意味です。
- このしくみを **例外（れいがい）** といいます。**詳しくは次回** やります。

今日は「外部とやりとりするときは `throws Exception` を付ける」と覚えておけばOKです。

---

## 準備：実行する場所に注意

サンプルは、これまで通り **リポジトリのいちばん上のフォルダ（`chapter18` フォルダがある場所）** で実行してください。

```
javac chapter18/file/Sample01.java
java chapter18.file.Sample01
```

プログラムの中で `"chapter18/data/books.csv"` のようにファイルの場所を書いていますが、
これは **「今いるフォルダから見た場所」** です（相対パスといいます）。
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

---

# ① ファイルを読み書きする

## ファイルを読む（file/Sample01.java）

```java
ArrayList<String> lines = new ArrayList<String>();

// ① ファイルを開く
BufferedReader reader = new BufferedReader(
        new FileReader("chapter18/data/books.csv", StandardCharsets.UTF_8));

// ② 1行ずつ読む（読む行がなくなると null が返ってくる）
String line = reader.readLine();
while (line != null) {
    lines.add(line);
    line = reader.readLine();
}

// ③ ファイルを閉じる
reader.close();

for (String s : lines) {
    System.out.println(s);
}
```

### ポイント

| 書き方 | 意味 |
| --- | --- |
| `FileReader` | ファイルから文字を読むためのクラス |
| `BufferedReader` | `FileReader` を包んで、**1行ずつ** 読めるようにするクラス |
| `StandardCharsets.UTF_8` | ファイルの文字コード。日本語が文字化けしないように指定する |
| `readLine()` | 1行読む。**もう読む行がないときは `null`** を返す |
| `close()` | ファイルを閉じる |

- `while (line != null)` で「読む行がある間はくり返す」という意味になります。
- 読んだ行を `lines.add(line)` で ArrayList に入れていくので、
  ファイルが何行あっても大丈夫です（ここが配列ではなく ArrayList を使う理由です）。

### 実行結果

```
----ファイルの中身----
Java入門,3000
はじめてのSQL,2500
ネットワークの基本,2800
3行読み込みました
```

---

## ファイルに書く（file/Sample02.java）

```java
ArrayList<String> tasks = new ArrayList<String>();
tasks.add("課題レポートを提出する");
tasks.add("Javaの復習をする");
tasks.add("教科書を読む");

// ① ファイルを開く（ファイルがなければ新しく作られる。あれば上書きされる）
FileWriter writer = new FileWriter("chapter18/data/output.txt", StandardCharsets.UTF_8);

// ② 1行ずつ書き込む（"\n" は改行）
for (String task : tasks) {
    writer.write(task + "\n");
}

// ③ ファイルを閉じる
writer.close();
```

### ポイント

- `FileWriter` はファイルに文字を書き込むためのクラスです。
- `write()` は改行を自動で入れないので、`"\n"` を付けて改行します。
- **`close()` を忘れると、内容がファイルに保存されないことがあります。**

実行したら、`chapter18/data/output.txt` をVS Codeで開いて中身を確認してみましょう。

---

## CSVを読んで、一覧を表示する（file/Sample03.java）

1行ずつ読んだ文字列を `,` で分けて、`Book` のインスタンスにして ArrayList に入れます。

```java
ArrayList<Book> books = new ArrayList<Book>();

BufferedReader reader = new BufferedReader(
        new FileReader("chapter18/data/books.csv", StandardCharsets.UTF_8));

String line = reader.readLine();
while (line != null) {
    // "Java入門,3000" を "," で分ける → ["Java入門", "3000"]
    String[] items = line.split(",");
    String title = items[0];
    int price = Integer.parseInt(items[1]); // 文字列 "3000" を 数値 3000 に変換

    books.add(new Book(title, price));
    line = reader.readLine();
}
reader.close();

for (Book book : books) {
    System.out.println(book.getTitle() + " : " + book.getPrice() + "円");
}
```

### ポイント

| 書き方 | 意味 |
| --- | --- |
| `line.split(",")` | 文字列を `,` で区切って、**String の配列** にする |
| `Integer.parseInt("3000")` | 文字列の `"3000"` を int の `3000` に変換する |

ファイルから読んだものは **すべて文字列** です。計算に使いたいときは数値に変換します。

### 実行結果

```
----本の一覧----
Java入門 : 3000円
はじめてのSQL : 2500円
ネットワークの基本 : 2800円
```

---

# ② インターネットにアクセスする

## しくみ

ブラウザでWebページを見るとき、裏では次のことが起きています。

```
あなたのPC  ── 「このページちょうだい」(リクエスト) ──▶  サーバー
あなたのPC  ◀── HTMLなどのデータ (レスポンス)    ──  サーバー
```

Javaのプログラムでも同じように、URLを指定してデータを受け取ることができます。

## Webページを読む（net/Sample01.java）

```java
ArrayList<String> lines = new ArrayList<String>();

// ① 読み込みたいページのURL
URL url = URI.create("https://example.com/").toURL();

// ② URLに接続して開く
BufferedReader reader = new BufferedReader(
        new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

// ③ 1行ずつ読む
String line = reader.readLine();
while (line != null) {
    lines.add(line);
    line = reader.readLine();
}

// ④ 閉じる
reader.close();
```

### ポイント

**ファイルを読むプログラムと見比べてみましょう。** ちがうのは「開く」ところだけです。

```java
// ファイルのとき
new FileReader("chapter18/data/books.csv", StandardCharsets.UTF_8)

// インターネットのとき
new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)
```

| 書き方 | 意味 |
| --- | --- |
| `URI.create("...").toURL()` | 文字列からURLを作る |
| `url.openStream()` | URLに接続して、データを受け取る準備をする |
| `InputStreamReader` | 受け取ったデータを文字として読めるようにする |

あとは `BufferedReader` で1行ずつ読むだけなので、ファイルのときと同じ書き方ができます。

実行すると、ブラウザで「ページのソースを表示」したときと同じ **HTML** が表示されます。

## ネット上のCSVを読んで、一覧を表示する（net/Sample02.java）

GitHubに置いてある `books.csv` を、インターネット経由で読み込みます。

```java
URL url = URI.create("https://raw.githubusercontent.com/masakos/java-prog/main/chapter18/data/books.csv").toURL();

BufferedReader reader = new BufferedReader(
        new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

String line = reader.readLine();
while (line != null) {
    String[] items = line.split(",");
    String title = items[0];
    int price = Integer.parseInt(items[1]);

    books.add(new Book(title, price));
    line = reader.readLine();
}
reader.close();
```

- `file/Sample03.java` と **ほとんど同じ** プログラムです。
- データがPCの中にあっても、インターネットの向こうにあっても、
  「開く → 1行ずつ読む → 閉じる」の流れは変わりません。

> ネットにつながっていないと、エラーになって止まります。
> これも次回やる「例外」の一つです。

---

# ③ データベースにアクセスする

## データベースとは

- たくさんのデータを **表（テーブル）の形** で保存・管理するしくみです。
- データの追加・検索・更新・削除がかんたんにできます。
- 今日は **SQLite（エスキューライト）** という、1つのファイルで動く手軽なデータベースを使います。

`books` テーブルのイメージ

| title | price |
| --- | --- |
| Java入門 | 3000 |
| はじめてのSQL | 2500 |
| ネットワークの基本 | 2800 |

## SQL

データベースへの命令は **SQL（エスキューエル）** という言葉で書きます。今日使うのはこの4つです。

```sql
-- テーブルを作る
CREATE TABLE books (title TEXT, price INTEGER)

-- データを追加する
INSERT INTO books (title, price) VALUES ('Java入門', 3000)

-- データを取り出す
SELECT title, price FROM books

-- テーブルを消す（あれば）
DROP TABLE IF EXISTS books
```

## JDBC とドライバ

- Javaからデータベースを使うしくみを **JDBC（ジェーディービーシー）** といいます。
- JDBC を使うには、データベースごとの **ドライバ（jarファイル）** が必要です。
  - ドライバは、Javaとデータベースの間に入る「通訳」のようなものです。

### ドライバの準備

1. 次のURLから `sqlite-jdbc-3.54.1.0.jar` をダウンロードする
   - https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.54.1.0/sqlite-jdbc-3.54.1.0.jar
2. `chapter18/lib` フォルダに置く

### 実行のしかた

コンパイルはいつも通りですが、**実行するときに `-cp` でドライバの場所を教える** 必要があります。

Windows（区切りは `;`）

```
javac chapter18/db/Sample01.java
java -cp ".;chapter18/lib/sqlite-jdbc-3.54.1.0.jar" chapter18.db.Sample01
```

Mac（区切りは `:`）

```
javac chapter18/db/Sample01.java
java -cp ".:chapter18/lib/sqlite-jdbc-3.54.1.0.jar" chapter18.db.Sample01
```

- `-cp` は「プログラムの部品をどこから探すか」を指定するオプションです。
- `.` は「今いるフォルダ」、その後ろがドライバのjarファイルです。
- `-cp` を付け忘れると `No suitable driver found` というエラーになります。

### VS Code の Run ボタンで実行する場合

Run ボタンでは `-cp` を書けないので、代わりに VS Code の設定でドライバの場所を教えます。
このリポジトリには、すでに `.vscode/settings.json` に次の設定が入っています。

```json
{
    "java.project.referencedLibraries": [
        "lib/**/*.jar",
        "chapter18/lib/**/*.jar"
    ]
}
```

- jarファイルを `chapter18/lib` に置けば、Run ボタンでもそのまま動きます。
- それでも `No suitable driver found` になるときは、コマンドパレット（`Ctrl + Shift + P`、Macは `Cmd + Shift + P`）で
  **`Java: Clean Java Language Server Workspace`** を実行して、VS Code を再起動してください。

---

## データを登録する（db/Sample01.java）

```java
ArrayList<Book> books = new ArrayList<Book>();
books.add(new Book("Java入門", 3000));
books.add(new Book("はじめてのSQL", 2500));
books.add(new Book("ネットワークの基本", 2800));

// ① データベースに接続する（ファイルがなければ新しく作られる）
Connection conn = DriverManager.getConnection("jdbc:sqlite:chapter18/data/books.db");

// ② テーブルを作り直す
Statement stmt = conn.createStatement();
stmt.executeUpdate("DROP TABLE IF EXISTS books");
stmt.executeUpdate("CREATE TABLE books (title TEXT, price INTEGER)");
stmt.close();

// ③ 1冊ずつ INSERT する（? のところに値が入る）
PreparedStatement ps = conn.prepareStatement("INSERT INTO books (title, price) VALUES (?, ?)");
for (Book book : books) {
    ps.setString(1, book.getTitle()); // 1つ目の ? に タイトル
    ps.setInt(2, book.getPrice());    // 2つ目の ? に 価格
    ps.executeUpdate();
}
ps.close();

// ④ 接続を閉じる
conn.close();
```

### ポイント

| 書き方 | 意味 |
| --- | --- |
| `DriverManager.getConnection("jdbc:sqlite:ファイル名")` | データベースに接続する |
| `Statement` | SQLをそのまま実行するためのもの |
| `executeUpdate()` | データを **変更する** SQL（CREATE / INSERT / DROP など）を実行する |
| `PreparedStatement` | `?` の部分に、あとから値を入れられるSQL |
| `setString(1, ...)` / `setInt(2, ...)` | 何番目の `?` に、何を入れるか |

- ArrayList の本を拡張for文で1冊ずつ取り出して、INSERT しています。
- 何回実行しても同じ結果になるように、最初にテーブルを消してから作り直しています。

---

## データを取り出して、一覧を表示する（db/Sample02.java）

```java
ArrayList<Book> books = new ArrayList<Book>();

// ① データベースに接続する
Connection conn = DriverManager.getConnection("jdbc:sqlite:chapter18/data/books.db");

// ② SELECT文を実行する
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT title, price FROM books");

// ③ 結果を1行ずつ取り出す（次の行がなくなると false になる）
while (rs.next()) {
    String title = rs.getString("title");
    int price = rs.getInt("price");
    books.add(new Book(title, price));
}

// ④ 閉じる
rs.close();
stmt.close();
conn.close();

for (Book book : books) {
    System.out.println(book.getTitle() + " : " + book.getPrice() + "円");
}
```

### ポイント

| 書き方 | 意味 |
| --- | --- |
| `executeQuery()` | データを **取り出す** SQL（SELECT）を実行する |
| `ResultSet` | SELECT の結果（表）が入っているもの |
| `rs.next()` | 次の行に進む。**もう行がないときは `false`** |
| `rs.getString("title")` | 今の行の `title` 列を文字列で取り出す |
| `rs.getInt("price")` | 今の行の `price` 列を int で取り出す |

- `while (rs.next())` は、ファイルの `while (line != null)` と同じ考え方です。
- 先に `Sample01` を実行してデータを登録してから、`Sample02` を実行してください。

### 実行結果

```
----本の一覧（データベースから取得）----
Java入門 : 3000円
はじめてのSQL : 2500円
ネットワークの基本 : 2800円
```

---

# まとめ

3つとも、読み込んだデータを **ArrayList に入れて、拡張for文で一覧表示** しています。

| | 開く | 1件ずつ読む | 読み終わり | 閉じる |
| --- | --- | --- | --- | --- |
| ファイル | `new FileReader(...)` | `readLine()` | `null` が返る | `close()` |
| インターネット | `url.openStream()` | `readLine()` | `null` が返る | `close()` |
| データベース | `DriverManager.getConnection(...)` | `rs.next()` | `false` が返る | `close()` |

- **開く → 読む/書く → 閉じる** の流れはどれも同じ
- 外部とのやりとりは「うまくいかないこと」があるので `throws Exception` を付けた
  - → 次回、**例外処理** でうまくいかなかったときの対処のしかたを学びます

---

# 演習問題

## 問題1
`chapter18/data/books.csv` に好きな本を1行追加して、`file/Sample03.java` を実行してみましょう。
プログラムを変えなくても、一覧に追加した本が表示されることを確認してください。

## 問題2
`file/Sample02.java` を参考にして、`ArrayList<Book>` の本を
`タイトル,価格` の形で `chapter18/data/mybooks.csv` に書き込むプログラムを作りましょう。

## 問題3
`db/Sample02.java` のSQLを次のように変えて実行してみましょう。何が変わるでしょうか？

```sql
SELECT title, price FROM books WHERE price >= 2800
```
