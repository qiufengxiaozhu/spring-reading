package thread_invoke;

public class My02_Runnable implements Runnable {
    @Override
    public void run() {
        // 线程要执行的代码
        System.out.println("Runnable is running");
    }

    public static void main(String[] args) {
        My02_Runnable myRunnable = new My02_Runnable();
        Thread thread = new Thread(myRunnable);
        thread.start(); // 启动线程
    }
}
