package thread_invoke;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class My06_ThreadPool_Cached {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.submit(new RunnableTask());
        }

        executorService.shutdown();
    }

    private static class RunnableTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}


