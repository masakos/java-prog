// APIで Thread.sleep() の仕様を調べると throws InterruptedException と書かれている。
// このため、sleep() を使うときは InterruptedException を try-catch などで処理する必要がある。

class Answer03 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            Thread.sleep(2000);
        }
    }
}