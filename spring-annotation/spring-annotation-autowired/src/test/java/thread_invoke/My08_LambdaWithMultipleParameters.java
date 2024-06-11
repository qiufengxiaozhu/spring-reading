package thread_invoke;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@FunctionalInterface
interface MyFunctionalInterface {
    void execute(String message, int number);
}

public class My08_LambdaWithMultipleParameters {
    public static void main(String[] args) {
        // 使用Lambda表达式实现接口
        MyFunctionalInterface myFunc = (message, number) -> System.out.println(Thread.currentThread().getName() + " received message: " + message + " with number: " + number);

        // 创建单线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            String msg = "Task " + i;
            int num = i;
            executorService.submit(() -> myFunc.execute(msg, num));
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
