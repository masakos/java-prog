package chapter16.samplelist;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;

public class Sample02 {
   public static void main(String[] args) {

      // ArrayList<String> names = new ArrayList<String>();
      // LinkedList<String> names = new LinkedList<String>();
      List<String> names = new LinkedList<String>();

      names.add("たなか");
      names.add("すずき");
      names.add("さいとう");

      System.out.println(names.get(0));
      System.out.println(names.get(1));
      System.out.println(names.get(2));
   }
}
