
## なぜファイルを分けるのか？
- エラーを探す範囲が小さくなる
- 担当を分けて、同時に開発できる（分業）

## 演習：ソースファイルを分割する

### 準備
1. 新しいフォルダを作る。例：`C:\Users\自分のアカウント名\java_0722`
2. VS Code で「フォルダーを開く」→ `java_0722` を開く
3. `Calc.java` という名前でファイルを作成
4. 一度コンパイル・実行して、動くことを確認

### 分割作業
2つのクラスに分ける。

- **Step1**：`CalcLogic.java` を新しく作り、`tasu` と `hiku` の2つのメソッドを移動する
- **Step2**：`Calc.java` は `main` メソッドだけにする


```java
// Calc.java  … mainだけ（プログラムの入口）
public class Calc {
    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        int total = CalcLogic.tasu(a, b);   // ← クラス名.メソッド名 で呼ぶ
        int delta = CalcLogic.hiku(a, b);
        System.out.println("足すと" + total + "、引くと" + delta);
    }
}
```

```java
// CalcLogic.java … 計算のロジック（本体）
public class CalcLogic {
    public static int tasu(int a, int b) {
        return a + b;
    }
    public static int hiku(int a, int b) {
        return a - b;
    }
}
```

# コンパイルと実行

```bash
# コンパイル：ファイルを2つとも指定
javac Calc.java CalcLogic.java

# 実行：「クラス名」を指定（.java は書かない）
java Calc
```

`.class` ファイルが **2つ** できます


# なぜ `java Calc` だけでいいの？

- JVM は、指定されたクラスの **`main` メソッド** から
  プログラムを開始する
- `main` があるのは `Calc` だけ
- `CalcLogic` は、必要なときに JVM が **自動で探す**



```
c: &&
cd c:\Users\ユーザー名\java-prog &&
cmd /C ""C:\Program Files\Java\jdk-25.0.3\bin\java.exe"
-XX:+ShowCodeDetailsInExceptionMessages
-cp C:\Users\ユーザー名\AppData\Roaming\Code\User\workspaceStorage\89bf745b29e99621bec6b9f25828dc0e\redhat.java\jdt_ws\java-prog_f0c24331\bin
Main"
```

- Runボタンを押すと、裏側でコンパイルしてから実行しています
- そのあとに、以下の流れ（ターミナルにでるログで確認できる）
```
- Cドライブへ移動
- プロジェクトフォルダへ移動
- Javaを起動
    - クラスパスを指定
    - Mainクラスを実行
```


# JAR ファイル

- クラスファイルが100個あったら、配るのが大変！
- **JAR（Java Archive）** = 複数の `.class` を
  1つにまとめるファイル形式
- `jar` コマンドで作れる（ZIP の Java 版）
    - jar コマンドは、複数の .class ファイルやリソースを 1 つの JAR（Java ARchive）ファイルにまとめるためのコマンドです。


### ② パッケージとは何か？
- クラスを整理する「フォルダ」のようなもの
- クラスが増えると管理が大変なので、グループごとにまとめる
- 名前の衝突を防ぐ： 違うパッケージなら、同じ「Sample01」という名前のクラスがあっても区別できる
- Javaのパッケージ名は、世界中で重複しないように、会社や学校のドメイン名を逆から付けるのが慣例です
    - 例えば Google は google.com というドメインを持っているので、Javaのパッケージは com.google から始まります。
    `https://github.com/google/gson/tree/main`

### ③ 覚えるキーワード
- FQCN（完全限定クラス名）：
    - 「パッケージ名 + クラス名」のフルネームのことです（例：chapter02.Sample01）
    - あるクラスから別パッケージのクラスを利用する場合は、FQCNを使う必要がある
- import（インポート）：
    - 毎回フルネームを書くのは大変です。import を使うと、短い名前でクラスを使えるようになります
- クラスパス：
    - Javaがクラスファイルを探す場所のことです。指定しない場合は、今いるフォルダを探します



## GitHub（ギットハブ）とは

- プログラムを保存する **インターネット上の場所**
- 「いつ・誰が・どこを変えたか」の **歴史が全部残る**
- チーム開発の世界標準ツール
