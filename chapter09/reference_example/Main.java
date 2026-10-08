package chapter09.reference_example;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book();
        Book book2 = book1;

        book1.title = "Java入門";

        System.out.print(book2.title);
    }

}
