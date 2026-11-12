## 例外処理とは

例外（Exception）とは、プログラムの実行中に起きる「想定外のできごと」のことです。

- 0で割った
- 配列の範囲外を指定した
- 読み込もうとしたファイルが無かった

例外が起きると、プログラムはその場で止まってしまいます。
**例外処理**とは、例外が起きたときにどうするかを決めておき、プログラムが止まらないようにする仕組みです。

## サンプル一覧

順番に1つずつ実行して、動きを確かめましょう。

| サンプル | 学ぶこと |
| --- | --- |
| Sample01 | 例外が起きるとプログラムが止まる |
| Sample02 | `try-catch` で例外をつかまえる |
| Sample03 | `catch` を複数書いて、例外の種類ごとに処理を分ける |
| Sample04 | `finally` で必ず実行する処理を書く |
| Sample05 | `try-with-resources` で自動的に close() する |
| Sample06 | `throws` で例外の処理を呼び出し元に任せる |
| Sample07 | `throw` で自分で例外を発生させる |
| Sample08 | 自分で例外クラスを作る |


## 1. 例外が起きるとどうなる？（Sample01）

```java
int result = a / b;   // b が 0 なので ArithmeticException が起きる
System.out.println("結果：" + result);   // ← 実行されない
```

実行すると、次のようなメッセージが出てプログラムが止まります。

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

## 2. try-catch（Sample02）

```java
try {
    // 例外が起きるかもしれない処理
} catch (例外の種類 e) {
    // 例外が起きたときの処理
}
```

- try の中で例外が起きると、残りの処理は飛ばされて catch に移ります。
- 例外をつかまえたので、プログラムは止まらずに最後まで動きます。
- `e.getMessage()` で例外の内容を取り出せます。

## 3. 複数の catch（Sample03）

```java
try {
    ...
} catch (NumberFormatException e) {
    ...
} catch (ArrayIndexOutOfBoundsException e) {
    ...
} catch (Exception e) {
    // それ以外すべて
}
```

- 上から順番に、当てはまる catch が1つだけ実行されます。
- `Exception` はすべての例外の親クラスなので、**一番最後**に書きます。

### よく出てくる例外

| 例外 | 起きるとき |
| --- | --- |
| ArithmeticException | 0で割った |
| ArrayIndexOutOfBoundsException | 配列の範囲外を指定した |
| NumberFormatException | 数値に変換できない文字列を変換した |
| NullPointerException | null のものを使おうとした |
| IOException | ファイルの読み書きに失敗した |

## 4. finally（Sample04）

```java
try {
    ...
} catch (...) {
    ...
} finally {
    // 例外が起きても起きなくても、必ず実行される
}
```

ファイルやデータベースを閉じるなど、「後片付け」に使います。

## 5. try-with-resources（Sample05）

```java
try (BufferedReader reader = new BufferedReader(new FileReader("ファイル名"))) {
    ...
} catch (IOException e) {
    ...
}
```

try の後ろの `( )` で開いたものは、最後に**自動で close()** されます。
close() の書き忘れを防げるので、ファイルやデータベースを扱うときはこの書き方がおすすめです。

## 6. throws（Sample06）

```java
static String readFirstLine(String fileName) throws IOException {
    ...
}
```

「このメソッドでは例外を処理しないので、呼び出した側で処理してください」という意味です。
呼び出し元で try-catch を書きます。

## 7. throw（Sample07）

```java
if (age < 0) {
    throw new IllegalArgumentException("年齢にマイナスは指定できません");
}
```

おかしな値が来たときなどに、**自分で例外を発生させる**ことができます。

> `throw`（例外を投げる）と `throws`（例外が起きるかもしれないと宣言する）は別物です。

## 8. 独自の例外クラス（Sample08）

```java
class ScoreException extends Exception {
    public ScoreException(String message) {
        super(message);
    }
}
```

`Exception` を継承すると、自分で例外クラスを作れます。
例外の名前でエラーの意味がわかるようになります。

## チェック例外と非チェック例外

| 種類 | 例 | try-catch や throws |
| --- | --- | --- |
| チェック例外（Exception を継承） | IOException、ScoreException | **必ず書く**（書かないとコンパイルエラー） |
| 非チェック例外（RuntimeException を継承） | ArithmeticException、IllegalArgumentException | 書かなくてもよい |

## 例外処理を書かないといけないのはどんなとき？

**チェック例外が起きるかもしれない処理を使うとき**は、例外処理を必ず書きます。
書かないとコンパイルエラーになるので、「書き忘れ」はコンパイラが教えてくれます。

| よく使う処理 | 起きるかもしれない例外 |
| --- | --- |
| ファイルを読む・書く（FileReader、FileWriter など） | IOException |
| データベースを使う（DriverManager.getConnection など） | SQLException |
| 少し待つ（Thread.sleep） | InterruptedException |
| 自分で作った例外（Exception を継承したもの） | ScoreException など |

たとえば、次のコードはコンパイルエラーになります。

```java
public static void main(String[] args) {
    FileReader reader = new FileReader("data.txt");   // ← エラー：IOException を処理していない
}
```

このエラーを直す方法は、次の **2つ** のどちらかです。

### 方法1：throws を書く（自分では処理しない）

```java
public static void main(String[] args) throws Exception {
    FileReader reader = new FileReader("data.txt");
    ...
}
```

- 「このメソッドでは例外を処理しません」という宣言です。
- main に書くと、例外は Java（JVM）に渡されます。例外が起きると、**プログラムはその場で止まり**、エラーメッセージが表示されます。

### 方法2：try-catch を書く（自分で処理する）

```java
public static void main(String[] args) {
    try {
        FileReader reader = new FileReader("data.txt");
        ...
    } catch (IOException e) {
        System.out.println("ファイルが見つかりませんでした");
    }
}
```

- 例外が起きたときに**何をするかを自分で決められます**。
- わかりやすいメッセージを出す、別の処理に切り替える、などができます。
- プログラムを止めずに続けられます。

