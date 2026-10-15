package todoapp;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task(
                "Javaの課題",
                LocalDate.of(2026, 10, 15)));

        tasks.add(new Task(
                "DBの復習",
                LocalDate.of(2026, 10, 16)));

        for (Task task : tasks) {
            task.show();
        }
    }
}
