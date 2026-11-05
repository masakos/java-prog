package chapter18.questions.answer;

public class Task {
    private String title;
    private String deadline;
    private int isCompleted;

    public Task(String title, String deadline, int isCompleted) {
        this.title = title;
        this.deadline = deadline;
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public String getDeadline() {
        return deadline;
    }

    public int getIsCompleted() {
        return isCompleted;
    }
}
