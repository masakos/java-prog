package chapter10;

public class EBook extends Book {
    int fileSize;

    // 子クラス独自の情報だけでなく、親クラスの情報も引数として受け取っている。
    public EBook(String title, String author, int price, int fileSize) {

        super(title, author, price);  // 親クラスのコンストラクタ呼び出し 
        this.fileSize = fileSize;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("ファイルサイズ：" + fileSize + "MB");
    }
}