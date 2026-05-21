public class Main {
    public static void main(String[] args) {
        int hp = 15; // hit point
        
        if (hp >= 80) {
            System.out.println("元気");
        } else if (hp >= 30) {
            System.out.println("弱っている");
        } else {
            System.out.println("危険");
        }

    }
}