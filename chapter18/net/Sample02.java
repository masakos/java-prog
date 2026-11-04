package chapter18.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

// インターネット上に置いてあるCSVファイルを読み込んで、Bookの一覧を表示する
public class Sample02 {
    public static void main(String[] args) throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();

        // GitHubに置いてある books.csv（file/Sample03 で読んだものと同じ内容）
        URL url = URI.create("https://raw.githubusercontent.com/masakos/java-prog/main/chapter18/data/books.csv").toURL();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

        String line = reader.readLine();
        while (line != null) {
            String[] items = line.split(",");
            String title = items[0];
            int price = Integer.parseInt(items[1]);

            books.add(new Book(title, price));
            line = reader.readLine();
        }
        reader.close();

        System.out.println("----本の一覧（ネットから取得）----");
        for (Book book : books) {
            System.out.println(book.getTitle() + " : " + book.getPrice() + "円");
        }
    }
}
