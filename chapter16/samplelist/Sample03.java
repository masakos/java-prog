package chapter16.samplelist;

import java.util.ArrayList;

public class Sample03 {
    public static void main(String[] args) {
        ArrayList<Integer> points = new ArrayList<Integer>();

        points.add(10);
        points.add(80);
        points.add(75);

        for(int i: points){
            System.out.println(i);
        }

        int size = points.size();
        System.out.println(size);

        boolean resulut = points.contains(10);
        System.out.println(resulut);
        

    }
    
}
