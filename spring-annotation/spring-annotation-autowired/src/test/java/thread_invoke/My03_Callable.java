package thread_invoke;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class My03_Callable implements Callable<String> {
    @Override
    public String call() {
        // 线程要执行的代码
        return "Callable result";
    }

    public static void main(String[] args) {
        My03_Callable myCallable = new My03_Callable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start(); // 启动线程

        try {
            // 获取线程执行结果
            String result = futureTask.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
