package chapter09.example02;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book();
        book1.title = "Java入門";
        book1.price = 3000;

        Author author1 = new Author();
        author1.name = "中山";
        author1.kana = "なかやま";
        book1.author = author1;

        book1.displayInfo();

    }

}
