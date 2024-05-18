import java.util.concurrent.atomic.AtomicBoolean;

public class Robot {
    static AtomicBoolean leg = new AtomicBoolean(false);

    public static void go(){
        leftLeg();
        rightLeg();
    }

    private static void leftLeg() {
        new Thread(() -> {
            leg("LEFT", true);
        }).start();
    }

    private static void rightLeg() {
        new Thread(() -> {
           leg("RIGHT", false);
        }).start();
    }

    private static void leg(String side, boolean key) {
        while(true) {
            int timeout = (int) ((Math.random() * (3000 - 1000)) + 1000);

            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (Robot.leg.get() == key) {
                System.out.println(side);
                Robot.leg.set(!Robot.leg.get());
            }
        }
    }
}
