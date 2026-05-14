package chapter3;

public class Lesson3 {
    public static void main(String[] args) {
        String signal = "yellow";

        if (signal.equals("blue")) {
            System.out.println("進む");
        } else if (signal.equals("yellow")) {
            System.out.println("注意する");
        } else if (signal.equals("red")) {
            System.out.println("止まる");
        } else {
            System.out.println("不明な信号です");
        }

        switch (signal){ 
            case "blue" -> System.out.println("進む");
            case "yellow" -> System.out.println("注意する");
            case "red" -> System.out.println("止まる");
            default -> System.out.println("不明");
        }

        switch (signal) {
            case "blue" -> {
                System.out.println("進む");
            }
            case "yellow" -> {
                System.out.println("注意する");
            }
            case "red" -> {
                System.out.println("止まる");
            }
            default -> {
                System.out.println("不明");
            }
        }

        // 伝統的な書き方 
        switch (signal) {
            case "blue":
                System.out.println("進む");
                break;

            case "yellow":
                System.out.println("注意する");
                break;

            case "red":
                System.out.println("止まる");
                break;

            default:
                System.out.println("不明");
        }
    }
}
