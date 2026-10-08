package chapter08;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.title = "Java入門";
        book1.author = "山田太郎";
        book1.price = 2000;

        Book book2 = new Book();
        book2.title = "Python入門";
        book2.author = "佐藤花子";
        book2.price = 2500;

        System.out.println("=== 書籍情報 ===");
        book1.displayInfo();
        System.out.println("税込価格：" + book1.getTaxIncludedPrice() + "円");
        System.out.println();

        book2.displayInfo();
        System.out.println("税込価格：" + book2.getTaxIncludedPrice() + "円");
    }

}
