package thread_invoke;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class My05_ThreadPool_Fixed {
    public static void main(String[] args) {
        // 创建固定大小为 5 的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new RunnableTask());
        }

        // 关闭线程池
        executorService.shutdown();
    }

    private static class RunnableTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}


