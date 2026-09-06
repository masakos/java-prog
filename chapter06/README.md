
## 目標

1. 複数のクラスで１つのプログラムを構成できる
2. 複数ファイルのコンパイルの方法と、プログラムの実行方法がわかる
3. package文を用いて、クラスをパッケージに所属できる
4. import文を使うと、コード中のFQCN指定を省略できる

## なぜクラス・ファイルを分けるのか？

- 読みやすくなる
- 修正しやすくなる
- 複数人で開発しやすい


## 演習：ソースファイルを分割する

### 準備
1. 新しいフォルダを作る。例：`C:\Users\自分のアカウント名\java_0722`
2. VS Code で「フォルダーを開く」→ `java_0722` を開く
3. `Calc.java` という名前でファイルを作成
4. 一度コンパイル・実行して、動くことを確認

### 分割作業
2つのクラスに分ける。

- **Step1**：`CalcLogic.java` を新しく作り、`add` と `subtract` の2つのメソッドを移動する
- **Step2**：`Calc.java` は `main` メソッドだけにする


```java
// Calc.java  … mainだけ（プログラムの入口）
public class Calc {
    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        int total = CalcLogic.add(a, b);   // ← クラス名.メソッド名 で呼ぶ
        int delta = CalcLogic.subtract(a, b);
        System.out.println("add=" + total + " delta=" + delta);
    }
}
```

```java
// CalcLogic.java … 計算のロジック（本体）
public class CalcLogic {
    public static int add(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }
}
```

- 別のクラスのメソッドは `クラス名.メソッド名()` で呼ぶ**（`CalcLogic.tasu(a, b)`）

### コンパイルと実行

```bash
# コンパイル：ファイルを2つとも指定
javac Calc.java CalcLogic.java

# 実行：「クラス名」を指定（起動したいクラスの完全限定クラス名（FQCN)）
java Calc
```

`.class` ファイルが **2つ** できます


### なぜ `java Calc` だけでいいのか？

- JVM は、指定されたクラスの **`main` メソッド** から プログラムを開始する
- `CalcLogic` は、必要なときに JVM が **自動で探す**



## JAR ファイル
- **JAR（Java Archive）** = 複数の `.class` を 1つにまとめるファイル形式
- `jar` コマンドで作れる
    - jar コマンドは、複数の .class ファイルやリソースを 1 つの JAR（Java ARchive）ファイルにまとめるためのコマンド


## パッケージとは何か？
- このクラスがどのグループに所属するかを `package` キーワードを使って、ファイル先頭で宣言する
- クラスを整理する「フォルダ」のようなもの
    - クラスが増えると管理が大変なので、グループごとにまとめる
- 名前の衝突を防ぐ
    - 違うパッケージなら、同じ「Sample01」という名前のクラスがあっても区別できる
- Javaのパッケージ名は、世界中で重複しないように、会社や学校のドメイン名を逆から付けるのが慣例になっている
    - 例えば Google は google.com というドメインを持っているので、Javaのパッケージは com.google から始まる
    `https://github.com/google/gson/tree/main`

## import(インポート)
- 別のパッケージにあるクラスを、クラス名だけで使えるようにするための宣言
    - 毎回フルネームを書くのは大変。import を使うと、短い名前でクラスを使えるようになる

##  FQCN（Fully Qualified Class Name）：
- 「パッケージ名 + クラス名」のフルネームのこと（例：chapter02.Sample01）
- あるクラスから別パッケージのクラスを利用する場合は、FQCNを使う必要がある

## クラスパス：
* Javaが**クラスファイル（`.class`）を探す場所**のこと。
* Javaがクラスファイルを見つけられるように、正しい場所をクラスパスに指定する。

### クラスパスの指定方法

#### 1. `java` コマンドで指定する

`-cp`（`-classpath`）を使って指定する。

```bash
java -cp C:\work Calc
```

この場合、`C:\work` の中から `Calc.class` を探す。

#### 2. `-cp` を指定しない

`-cp` を指定しない場合、デフォルトではカレントディレクトリ（現在いるフォルダ）がクラスパスとして使用される。

例えば、`C:\work` に `Calc.class` がある場合、

```powershell
cd C:\work
java Calc
```

とすると、`C:\work` から `Calc.class` が見つかる。

#### 3. OSの環境変数 `CLASSPATH` に設定する

環境変数 `CLASSPATH` にクラスファイルを探す場所を設定することもできる。

```text
CLASSPATH=C:\work
```

ただし、環境変数 `CLASSPATH` は他のJavaプログラムにも影響するため、通常は**`-cp` で明示的に指定する方法がおすすめ**。






