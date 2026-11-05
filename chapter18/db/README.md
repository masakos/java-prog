# データベースにアクセスする

## ゴール

Java のプログラムから **データベース（DB）** に接続して、

1. データを **読み込む**（Sample01）
2. データを **書き込む**（Sample02）

ことができるようになる。

---

## データベースに接続するために必要なもの

Java から DB を使うには、次の3つがそろっている必要があります。

| 必要なもの | 今回使うもの | 置き場所 |
| --- | --- | --- |
| ① データベース | SQLite のファイル `todo.db` | `chapter18/data/todo.db` |
| ② ドライバ（jarファイル） | `sqlite-jdbc-3.51.1.1.jar` | `chapter18/lib/` |
| ③ Java のプログラム | `Sample01.java` など | `chapter18/db/` |

### JDBC とドライバ

- Java には、DB を使うためのしくみ **JDBC（ジェイディービーシー）** が最初から入っています。
  `Connection` や `ResultSet` などのクラスがそれです（`import java.sql.〜`）。
- ただし、DB には SQLite、MySQL、PostgreSQL などいろいろな種類があり、
  それぞれとやりとりする方法がちがいます。
- そこで、DB の種類ごとに **ドライバ** という「通訳」の部品を用意します。
  ドライバは **jarファイル**（Java の部品をまとめたファイル）として配られています。

```
Javaのプログラム  ──JDBC──▶  ドライバ（jar）  ──▶  データベース（todo.db）
```

ドライバがないと、Java は DB と話すことができません。

### JDBC・ドライバ・jar のちがい

似た言葉が出てきますが、それぞれ別のものです。

| 言葉 | 何か | どこにあるか |
| --- | --- | --- |
| JDBC | Java から DB を使うための **決まりごと（ルール）** | Java に最初から入っている |
| ドライバ | JDBC の決まりに合わせて、**実際に DB とやりとりする部品** | DB の種類ごとに別々に用意する |
| jar | Java の部品をまとめた **ファイルの形式**（zip のようなもの） | ドライバに限らず、いろいろな部品が jar で配られる |

`sqlite-jdbc-3.51.1.1.jar` は、「**SQLite 用の JDBC ドライバ** が入った **jar ファイル**」です。

コンセントにたとえると、こんな関係です。

| たとえ | 実際 |
| --- | --- |
| コンセントの形の決まり | JDBC |
| その形に合った電源アダプタ | ドライバ |
| アダプタが入っている箱 | jar |

プログラムは JDBC の決まりどおりに書くので、たとえば SQLite から MySQL に変えたいときも、
**ドライバの jar** と **接続先の文字列（`jdbc:sqlite:...` の部分）** を変えるだけで、
ほかのコードはほとんどそのまま使えます。

---

## 準備

### ① ドライバを `lib` フォルダに置く

ドライバ（jar ファイル）は、**Maven Central（メイヴン セントラル）** からダウンロードします。

#### Maven Central とは

- 世界中の Java の部品（jar ファイル）が集められている、**Java 用の公式の倉庫** です。
- スマホのアプリをアプリストアから入れるように、Java の部品はここから入手するのが一般的です。
- 部品は「作った組織 / 部品の名前 / バージョン」ごとに整理されて置かれています。

今回のドライバは、次の場所にあります。

| 項目 | 値 | 意味 |
| --- | --- | --- |
| 作った組織 | `org.xerial` | Xerial というプロジェクト |
| 部品の名前 | `sqlite-jdbc` | SQLite 用の JDBC ドライバ |
| バージョン | `3.51.1.1` | 今回使う版 |

URL もこの順番になっています。

```
https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.51.1.1/sqlite-jdbc-3.51.1.1.jar
                               └─組織─┘ └部品の名前┘ └バージョン┘ └──ファイル名──┘
```

> 実際の開発では、Maven や Gradle というツールを使って、
> 必要な部品をこの倉庫から **自動で** ダウンロードするようになります。
> 今回は、しくみを知るために **手で** ダウンロードします。

#### ダウンロードの手順

1. 次のリンクをクリックします。jar ファイルがダウンロードされます。
   https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.51.1.1/sqlite-jdbc-3.51.1.1.jar
2. ダウンロードした `sqlite-jdbc-3.51.1.1.jar` を、`chapter18/lib` フォルダに移動します。
   **ファイル名は変えないでください。**
3. 次のようになっていれば OK です。

```
chapter18
└─ lib
    └─ sqlite-jdbc-3.51.1.1.jar
```

> ブラウザによっては「このファイルは危険な可能性があります」と表示されることがあります。
> Maven Central（`repo1.maven.org`）からのダウンロードであれば、「保存」を選んで大丈夫です。

### ② VS Code にドライバの場所を教える

リポジトリのいちばん上に `.vscode/settings.json` があり、次のように書かれています。

```json
{
    "java.project.referencedLibraries": [
        "chapter18/lib/**/*.jar"
    ]
}
```

これは「`chapter18/lib` の中の jar ファイルを使ってね」と VS Code に伝える設定です。

設定ができているかは、エクスプローラーの下にある
**JAVA PROJECTS → Referenced Libraries** に `sqlite-jdbc-3.51.1.1.jar` が表示されているかで確認できます。

表示されていないときは、コマンドパレット（`Ctrl + Shift + P`）で
**「Java: Clean Java Language Server Workspace」** を実行するか、VS Code を開き直してください。

### ③ 実行する

VS Code の **Run ボタン** で実行できます。

ターミナルで実行するときは、リポジトリのいちばん上のフォルダで次のようにします。
`-cp` で「プログラムの場所」と「ドライバの場所」の両方を指定するのがポイントです。

```
javac chapter18/db/Sample01.java
java -cp ".;chapter18/lib/sqlite-jdbc-3.51.1.1.jar" chapter18.db.Sample01
```

（Mac の場合は `;` ではなく `:` で区切ります）

> 実行すると `WARNING: A restricted method ...` という表示が出ることがありますが、
> 動作には問題ありません。

---

## todo.db のテーブル

`todo.db` には、次の3つのテーブルがあります。

**users（ユーザー）**

| 列名 | 型 | 意味 |
| --- | --- | --- |
| id | INTEGER | ユーザーの番号 |
| name | TEXT | 名前 |

**categories（カテゴリー）**

| 列名 | 型 | 意味 |
| --- | --- | --- |
| id | INTEGER | カテゴリーの番号 |
| name | TEXT | カテゴリー名 |

**tasks（タスク）**

| 列名 | 型 | 意味 |
| --- | --- | --- |
| id | INTEGER | タスクの番号 |
| title | TEXT | タイトル |
| description | TEXT | 説明 |
| deadline | TEXT | 期限（例：`2026-11-20`） |
| is_completed | INTEGER | 完了したら 1、まだなら 0 |
| user_id | INTEGER | だれのタスクか（users の id） |
| category_id | INTEGER | どのカテゴリーか（categories の id） |

今回のサンプルでは、主に **tasks テーブル** を使います。

---

## コードの流れ

ファイルの読み書きと同じで、流れは **開く → 読む/書く → 閉じる** です。

```
① 接続する（Connection）
② SQL を実行する
③ 結果を受け取る
④ 閉じる
```

### Sample01：データを読み込む（SELECT）

```java
// ① データベースに接続する
Connection conn = DriverManager.getConnection("jdbc:sqlite:chapter18/data/todo.db");

// ② SELECT文を実行する
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT id, title, deadline FROM tasks");

// ③ 結果を1行ずつ取り出す（次の行がなくなると false になる）
while (rs.next()) {
    int id = rs.getInt("id");
    String title = rs.getString("title");
    String deadline = rs.getString("deadline");
    System.out.println(id + " : " + title + "（期限 " + deadline + "）");
}

// ④ 閉じる
rs.close();
stmt.close();
conn.close();
```

**① 接続する**

```java
Connection conn = DriverManager.getConnection("jdbc:sqlite:chapter18/data/todo.db");
```

- `"jdbc:sqlite:chapter18/data/todo.db"` は、**どの DB につなぐか** を表す文字列です。

  | 部分 | 意味 |
  | --- | --- |
  | `jdbc:` | JDBC を使います |
  | `sqlite:` | SQLite のドライバを使います |
  | `chapter18/data/todo.db` | DB ファイルの場所 |

- 接続できると、`Connection`（接続）が返ってきます。

**② SQL を実行する**

```java
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT id, title, deadline FROM tasks");
```

- `Statement` は、SQL を DB に送るための道具です。
- データを **取り出す（SELECT）** ときは `executeQuery` を使います。
- 結果は `ResultSet`（結果の表）として返ってきます。

**③ 結果を1行ずつ取り出す**

`ResultSet` は、SELECT の結果の表です。

| id | title | deadline |
| --- | --- | --- |
| 1 | DBの課題 | 2026-10-30 |
| 3 | 会議資料の作成 | 2026-10-29 |
| … | … | … |

- `rs.next()` を呼ぶと、**次の行に進みます**。
  次の行があれば `true`、もう行がなければ `false` を返すので、`while` で最後まで読めます。
- 今いる行の値は、**列名を指定して** 取り出します。

  | 列の型 | 取り出すメソッド |
  | --- | --- |
  | INTEGER | `rs.getInt("列名")` |
  | TEXT | `rs.getString("列名")` |

**④ 閉じる**

- 使い終わったら、**開いたのと逆の順番** で閉じます（`rs` → `stmt` → `conn`）。

---

### Sample02：データを書き込む（INSERT）

```java
// ① データベースに接続する
Connection conn = DriverManager.getConnection("jdbc:sqlite:chapter18/data/todo.db");

// ② INSERT文を準備する（? のところにあとから値が入る）
PreparedStatement ps = conn.prepareStatement(
        "INSERT INTO tasks (title, description, deadline, user_id, category_id) VALUES (?, ?, ?, ?, ?)");
ps.setString(1, "Javaの復習");      // 1つ目の ? に タイトル
ps.setString(2, "18章を読み直す");   // 2つ目の ? に 説明
ps.setString(3, "2026-11-20");      // 3つ目の ? に 期限
ps.setInt(4, 1);                    // 4つ目の ? に ユーザーのid
ps.setInt(5, 1);                    // 5つ目の ? に カテゴリーのid

// ③ 実行する
ps.executeUpdate();

// ④ 閉じる
ps.close();
conn.close();
```

**② INSERT文を準備する**

- `PreparedStatement` は、**あとから値を入れられる SQL** です。
- SQL の中の `?` が「あとで値を入れる場所」です。
- `setString(番号, 値)` や `setInt(番号, 値)` で、何番目の `?` に何を入れるかを指定します。
  **番号は 1 から数えます**（0 からではありません）。

```
INSERT INTO tasks (title, description, deadline, user_id, category_id)
VALUES (     ?,           ?,           ?,        ?,           ?     )
            ↑1           ↑2           ↑3        ↑4           ↑5
       "Javaの復習"  "18章を読み直す" "2026-11-20"   1            1
```

- `id` と `is_completed` は書いていません。
  - `id` は自動で次の番号が付きます。
  - `is_completed` は書かなければ `0`（未完了）になります。

**③ 実行する**

- データを **変更する（INSERT / UPDATE / DELETE）** ときは `executeUpdate` を使います。

書き込めたかどうかは、もう一度 **Sample01** を実行すると確認できます。
最後に「Javaの復習」が増えていれば成功です。

> Sample02 は実行するたびに、同じタスクが1件ずつ増えていきます。

---

## executeQuery と executeUpdate のちがい

| | executeQuery | executeUpdate |
| --- | --- | --- |
| 使う SQL | SELECT | INSERT / UPDATE / DELETE |
| すること | データを取り出す | データを変更する |
| 返ってくるもの | `ResultSet`（結果の表） | 変更した行の数（int） |

---

## よくあるエラー

| エラーメッセージ | 原因 | 対処 |
| --- | --- | --- |
| `No suitable driver found for jdbc:sqlite:...` | ドライバ（jar）が見つからない | `lib` に jar があるか、VS Code の設定（準備②）を確認 |
| `no such table: tasks` | DB ファイルが見つからず、空の DB が新しく作られた | 実行しているフォルダがリポジトリのいちばん上か確認 |
| `no such column: ...` | 列名のまちがい | SQL や `getString("...")` の列名を確認 |

> SQLite は、指定した場所に DB ファイルがないと **エラーにならずに空の DB を新しく作ります**。
> そのため「ファイルが見つからない」ではなく「テーブルがない」というエラーになります。
