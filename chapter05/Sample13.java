package chapter05;

/* コマンドライン引数のサンプル
   コマンドライン引数は、プログラム実行時に指定する引数のこと
   コンパイルと実行
    javac chapter05\Sample13.java
    java chapter05.Sample13 hello world
*/

public class Sample13 {
    public static void main(String[] args) {
        for(String arg: args){
            System.out.println(arg);
        }
    }
}
