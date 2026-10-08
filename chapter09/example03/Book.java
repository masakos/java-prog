package chapter09.example03;

public class Book {
    String title;
    int price;
    String author;

    public Book(String title, int price, String author){
        System.err.println("コンストラクタ");
        this.title = title;
        this.price = price;
        this.author = author;
    }
    public void displayInfo() {
        System.out.println("タイトル：" + this.title);
        System.out.println("著者：" + this.author);
        System.out.println("価格：" + this.price + "円");
    }

}
