package chapter04;

public class Sample03 {
    public static void main(String[] args) {
        // 特殊な値null
        // nullは「0」でも「空文字」でもなく、「何もない」ことを表す特別な値
        int a = 0;
        System.out.println("a = " + a); // 0

        String s = "";
        System.out.println("s = " + s); // 空文字(=何も文字が入っていない文字列)

        // int は「必ず数値が入る型」なので、nullは入らない
        // int b = null;
        String t = null;
        System.out.println("t = " + t); // null

        String u[] = new String[3];
        System.out.println("String の初期値は null になる");
        System.out.println("u[0] = " + u[0]); // null
        System.out.println("u[1] = " + u[1]); // null
        System.out.println("u[2] = " + u[2]); // null

        double[] d = new double[3];
        System.out.println("double の初期値は 0.0 になる");
        System.out.println("d[0] = " + d[0]); // 0.0
        System.out.println("d[1] = " + d[1]); // 0
        System.out.println("d[2] = " + d[2]); // 0.0

        boolean[] bools = new boolean[3];
        System.out.println("boolean の初期値は false になる");
        System.out.println("bools[0] = " + bools[0]); // false
        System.out.println("bools[1] = " + bools[1]); // false
        System.out.println("bools[2] = " + bools[2]); // false

        char[] chars = new char[3];
        System.out.println("char の初期値は '\\u0000' になる");
        // ヌル文字は「値が「0」の具体的な1文字（1バイト）のデータ」、nullは「なにもない」。名前は似ているが全く別物。
        System.out.println("chars[0] = " + chars[0]); // '\u0000'
        System.out.println("chars[1] = " + chars[1]); // '\u0000'
        System.out.println("chars[2] = " + chars[2]); // '\u0000'

        char c = '\u0000';
        System.out.println("c = " + c); // '\u0000'

    }
}
