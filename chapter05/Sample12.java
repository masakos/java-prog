package chapter05;

public class Sample12 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        display(a);

        System.out.println("----配列の中身がかわってるか確認---");
        for(int i=0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static void display(int[] x){
        for(int i=0; i < x.length; i++){
            System.out.println(x[i]);
            x[i] = 100;
        }
    }

}
