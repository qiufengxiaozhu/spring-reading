package thread_invoke;

public class My01_Thread extends Thread {
    @Override
    public void run() {
        // 线程要执行的代码
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        My01_Thread thread = new My01_Thread();
        thread.start(); // 启动线程
    }
}
