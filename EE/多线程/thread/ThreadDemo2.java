package thread;

/**
 *  使用匿名内部类,继承Thread
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello thread!");
                }
            }
        };
        t.start();
        while (true) {
            System.out.println("hello main!");
        }

    }
}
