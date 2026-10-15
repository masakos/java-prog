package todoapp;

import java.time.LocalDate;

public class Task {
    private String title;
    private boolean completed;
    private LocalDate dueDate;

    public Task(String title, LocalDate dueDate) {
        this.title = title;
        this.completed = false;
    }

    public void complete() {
        completed = true;
    }

    public void show() {
        System.out.println(
                title + "：" + (completed ? "完了" : "未完了"));
    }

    public boolean isOverdue() {

        // 今日が期限日を過ぎているか確認する
        boolean overdue = LocalDate.now().isAfter(dueDate);

        // 完了していないか確認する
        boolean notCompleted = !completed;

        // 未完了で、期限を過ぎている場合は true
        return notCompleted && overdue;
    }
}