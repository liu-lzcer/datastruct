public class AppleHarvest {
    public static void main(String[] args) {
        Thread farmer1 = new Thread(new ApplePicker("果农1"));
        Thread farmer2 = new Thread(new ApplePicker("果农2"));

        farmer1.start();
        farmer2.start();
    }
}

class ApplePicker implements Runnable {
    private final String farmerName;

    public ApplePicker(String farmerName) {
        this.farmerName = farmerName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000); // 模拟采摘一棵树需要1秒
            } catch (InterruptedException e) {
                System.out.println(farmerName + " 被中断: " + e.getMessage());
            }
            System.out.println(farmerName + " 采摘了第 " + i + " 棵苹果树。");
        }
        System.out.println(farmerName + " 采摘完成！");
    }
}
