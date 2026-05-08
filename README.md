## 
Ctr + , で設定画面を開く
検索窓に、　Editor: Font Family

VSコードで使用するフォントが指定してあって、先に書いてあるものが優先されるので、最初に入力する

MS Gothic,

Consolas, 'Courier New', monospace

## 
コンピューターでは文字を「文字コード」で管理している。

「\（バックスラッシュ）」には
U+005C というコードがある。

日本のWindowsでは昔から、
この U+005C を「¥（円マーク）」っぽく表示することが多かった。

だから、

見た目は ¥ でも、
コンピューター内部では \ として扱われていることがある。


パソコンは文字を主にUnicode番号で扱う。

保存するときに、
UTF-8などの形式でバイト列に変換する。

表示するときは、
Unicode番号をフォントへ渡して、
フォントが見た目を描画する。


byte, short, int, long, float, double

Chapter2_Expression
Chapter2_TypeConversion
Chapter2_Statement

ExpressionExample
TypeConversionExample
StatementExample
