package chapter10;

public class Main {
    public static void main(String[] args) {

        PaperBook paper = new PaperBook("Java入門", "山田太郎", 2800, 300);

        EBook ebook = new EBook("SQL入門", "佐藤花子", 1800, 15);

        paper.display();

        System.out.println("");

        ebook.display();
    }
}
