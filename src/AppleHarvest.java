public class AppleHarvest {
    public static final Object lock = new Object();
    public static boolean isFirstFarmerTurn = true;

    public static void main(String[] args) {
        Thread farmer1 = new Thread(new ApplePicker("果农1", true));
        Thread farmer2 = new Thread(new ApplePicker("果农2", false));

        farmer1.start();
        farmer2.start();
    }
}

class ApplePicker implements Runnable {
    private final String farmerName;
    private final boolean isFirstFarmer;

    public ApplePicker(String farmerName, boolean isFirstFarmer) {
        this.farmerName = farmerName;
        this.isFirstFarmer = isFirstFarmer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            synchronized (AppleHarvest.lock) {
                while (AppleHarvest.isFirstFarmerTurn != isFirstFarmer) {
                    try {
                        AppleHarvest.lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(farmerName + " 被中断: " + e.getMessage());
                    }
                }

                try {
                    Thread.sleep(1000); // 模拟采摘一棵树需要1秒
                } catch (InterruptedException e) {
                    System.out.println(farmerName + " 被中断: " + e.getMessage());
                }
                System.out.println(farmerName + " 采摘了第 " + i + " 棵苹果树。");

                AppleHarvest.isFirstFarmerTurn = !AppleHarvest.isFirstFarmerTurn;
                AppleHarvest.lock.notify();
            }
        }
        System.out.println(farmerName + " 采摘完成！");
    }
}
