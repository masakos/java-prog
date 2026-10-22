package chapter16.samplelist;

import java.util.ArrayList;

public class Sample04 {
    public static void main(String[] args) {
        ArrayList<Double> points = new ArrayList<Double>();

        points.add(1.22);
        points.add(1.33);
        points.add(0.76);

        for(double i: points){
            System.out.println(i);
        }

    }
    
}
