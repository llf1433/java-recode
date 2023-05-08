package thread;

/**
 * 使用匿名内部类,实现Runnable
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("this is thread!");
                }
            }
        });
        thread.start();
        while (true) {
            System.out.println("this is main!");
        }
    }
}
