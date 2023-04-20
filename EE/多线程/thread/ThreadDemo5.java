package thread;

/**
 * lambda表达式
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("this is thread");
        });
        thread.start();

    }
}
