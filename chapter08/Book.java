package chapter08;

public class Book {
    String title;
    String author;
    int price;
    final double TAX_RATE = 1.1;

    public void displayInfo() {
        System.out.println("タイトル：" + this.title);
        System.out.println("著者：" + this.author);
        System.out.println("価格：" + this.price + "円");
    }

    public int getTaxIncludedPrice() {
        return (int) (this.price * TAX_RATE);
    }
}

