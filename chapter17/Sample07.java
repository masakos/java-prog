package chapter17;

// throw：自分で例外を発生させる
public class Sample07 {
    public static void main(String[] args) {
        try {
            setAge(20);
            setAge(-5); // 正しくない値
        } catch (IllegalArgumentException e) {
            System.out.println("エラー：" + e.getMessage());
        }
    }

    static void setAge(int age) {
        // ① 正しくない値が来たら、throw で例外を投げる
        //    （IllegalArgumentException は「引数の値がおかしい」ことを表す例外）
        if (age < 0) {
            throw new IllegalArgumentException("年齢にマイナスは指定できません：" + age);
        }
        // ② throw した場合、ここから下は実行されない
        System.out.println("年齢を " + age + " に設定しました");
    }
}
