package chapter09.example02;

public class Book {
    String title;
    int price;
    Author author;

    public void displayInfo() {
        System.out.println("タイトル：" + this.title);
        System.out.println("著者：" + this.author.name);
        System.out.println("著者(かな）：" + this.author.kana);
        System.out.println("価格：" + this.price + "円");
    }

}
