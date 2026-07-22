import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamMaker {

    public static void main(String[] args) {

        int studentCount = 41; // 学生数
        int teamCount = 6;     // チーム数

        // 学生番号を作成（1～41）
        List<Integer> students = new ArrayList<>();
        for (int i = 1; i <= studentCount; i++) {
            students.add(i);
        }

        // ランダムに並び替え
        Collections.shuffle(students);

        // 1チームあたりの基本人数
        int baseSize = studentCount / teamCount;

        // 余る人数
        int remainder = studentCount % teamCount;

        int index = 0;

        for (int team = 1; team <= teamCount; team++) {

            // 余りの人数分だけ1人多くする
            int teamSize = baseSize;
            if (team <= remainder) {
                teamSize++;
            }

            System.out.println("=== チーム " + team + " ===");

            for (int i = 0; i < teamSize; i++) {
                System.out.print(students.get(index++) + " ");
            }

            System.out.println("\n");
        }
    }
}