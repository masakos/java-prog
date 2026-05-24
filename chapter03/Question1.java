package chapter03;

public class Question1 {
    public static void main(String[] args) {
        int rank = 2;

        switch (rank) {
            case 1:
                System.out.println("金メダル");
                break;
            case 2:
                System.out.println("銀メダル");
                break;
            case 3:
                System.out.println("銅メダル");
                break;
            default:
                System.out.println("参加賞");
                break;
        }
    }
}
