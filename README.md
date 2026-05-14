# Java Lesson


# Java環境構築

## 1. 環境構築のゴール
- 自分のPCで、Java のプログラムを実行する


## 2. 必要なもの
- JDK(Java Development Kit): Javaを動かすためのセット
- Visual Studio Code（VS Code): Javaのソースコードを書くためのエディタ


## 3. インストールの前に確認

### ① 自分のアカウントが管理者権限になっているか？
- 管理者になっていない人は、以下手順でアカウントを管理者にしてください
  ```
  (1) サインアウトしてadminでログイン
  (2) 設定 > アカウント > その他のユーザー > アカウントの種類の変更
  ```

### ② ファイルの拡張子が表示される状態になっているか？
- なっていない人は、以下の手順で表示するようにしてください。
  - (1) エクスプローラーを開く
  - (2) 上のメニューの 「表示」 をクリック
  - (3) 「表示」→「ファイル名拡張子」 にチェックを入れる

### ③ Visual Studio Code（VS Code）はインストールされているか？
- まだインストールしていない人はDLしてインストールしてください
  - https://code.visualstudio.com/download


## 4. JDKのインストール
- https://www.oracle.com/jp/java/technologies/downloads/
  - JDK 25 → windows → x64 Installer

| バージョン | 種類 | 特徴 |
|------------|------|------|
| JDK 26 | 非LTS（短期サポート） | 最新機能をいち早く試せる／サポート期間が短い／実験的要素を含む |
| JDK 25 | LTS（長期サポート） | 安定性が高い／長期間サポート／実務・本番環境での利用に最適 |
| JDK 21 | LTS（長期サポート） | 1つ前の安定版／現場でまだ広く使われている／教材や既存システムで多い |
| それ以前 | 旧バージョン | サポート終了または縮小／セキュリティリスクあり／特別な理由がない限り非推奨 |

(2026/4/24現在のバージョン）

- **特別な理由がなければ、latest Long-Term Support (LTS) を選択するのがよい**
- 以下脆弱性があるので、最新に更新する
  - https://www.ipa.go.jp/security/security-alert/2026/0422-jre.html

### インストール確認
PowerShellを開いて、javaがインストールされ使える状態か確認する

```bash
java --version
java 25.0.3 2026-04-21 LTS
Java(TM) SE Runtime Environment (build 25.0.3+9-LTS-195)
Java HotSpot(TM) 64-Bit Server VM (build 25.0.3+9-LTS-195, mixed mode, sharing)
```


## 5. PowerShell
- パソコンに命令を出すためのツール(画面)
- マウスではなく「文字で操作」するため、コマンドを覚える必要がある

| 分類  | 例          | 操作方法         |
| --- | ---------- | ------------ |
| CLI(Command Line Interface) | PowerShell | キーボードでコマンド入力 |
| GUI(Graphical User Interface) | エクスプローラー   | 視覚的な操作画面  |

### PowerShell 基本操作

```bash
# 現在のディレクトリ（作業場所）を表示する
pwd

# ユーザーディレクトリに移動する
cd ~

# ディレクトリを作成
mkdir java-prog

# 作成したディレクトリへ移動
cd java-prog

# ファイルを作成
ni Main.java

# ファイルを削除
rm Main.java

# メモ帳を起動して、ファイルを新規に作成する
notepad sample.txt

# コマンド履歴の利用
↑キー：過去のコマンドを表示
↓キー：次のコマンドへ移動
```

---

## 6. Javaファイルの作成・コンパイル・実行

```bash
# java-prog ディレクトリにいることを確認
pwd

# 今いるフォルダを Visual Studio Code で開く
code .  
```

**①ファイルの作成**

`Main.java`　という名前のファイルを作成してコードを書く
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

**②ターミナルを開く**
VSCodeのメニュー > view > Terminal

**③コンパイル**
```
# javac →コンパイル
javac Main.java

ls
```
- .java → 人が書いたコード =人間向けのソースコード
- .class → コンピュータが読むファイル = バイトコード

④実行
```
# java →実行
java Main
```


### VSCode のJava拡張をインストールしてファイル作成してみる
- 拡張：Extension Pack for Java