package chapter04;

public class Sample09 {
    public static void main(String[] args) {
        //2次元配列の宣言と初期化
        int[][] scores = new int[2][3];
        
        //値の代入
        scores[0][0] = 40;
        scores[0][1] = 50;
        scores[0][2] = 60;
        scores[1][0] = 80;
        scores[1][1] = 60;
        scores[1][2] = 70;

        System.out.println(scores[0][0]);
        System.out.println(scores[0][1]);
        System.out.println(scores[0][2]);
        System.out.println(scores[1][0]);
        System.out.println(scores[1][1]);
        System.out.println(scores[1][2]);

        //2次元配列の宣言と初期化
        int[][] scores2 = { { 40, 50, 60 }, { 80, 60, 70 } };
        System.out.println(scores2.length);
        System.out.println(scores2[0].length);
    
    } 
}
