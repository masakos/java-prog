package chapter10;

public class Book {
    String title;
    String author;
    int price;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("タイトル：" + title);
        System.out.println("著者：" + author);
        System.out.println("価格：" + price + "円");
    }
}
