package chapter09.example04;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Java入門", 3000);
        book1.displayInfo();

        Book book2 = new Book("python入門", 2800, "山田");
        book2.displayInfo();

    }

}
