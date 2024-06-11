package thread_invoke;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class My07_ThreadPool_Single {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " is running"));
        }

        executorService.shutdown();
    }

}

