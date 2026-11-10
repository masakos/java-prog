package chapter10;

public class PaperBook extends Book {
    int pageCount;

    public PaperBook(String title, String author, int price, int pageCount) {
        super(title, author, price);
        this.pageCount = pageCount;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("ページ数：" + pageCount);
    }
}
