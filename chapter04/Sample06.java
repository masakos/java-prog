package chapter04;

public class Sample06 {
    public static void main(String[] args) {
        int[] attendance = {0, 1, 2, 1, 0};

        // 0 → 欠席, 1 → 出席, 2 → 遅刻 で管理して、データに対応する出席の状態を表示する場合
        for (int i = 0; i < attendance.length; i++) {
            switch (attendance[i]) {
                case 0 -> {
                    System.out.println("欠席");
                }
                case 1 -> {
                    System.out.println("出席");
                }
                case 2 -> {
                    System.out.println("遅刻");
                }
            }
        }

        System.out.println("------配列を使った書き方------");
        String[] status = {"欠席", "出席", "遅刻"};
        for(int i=0; i < attendance.length; i++) {
            System.out.println(status[attendance[i]]);
        }
    }
}
