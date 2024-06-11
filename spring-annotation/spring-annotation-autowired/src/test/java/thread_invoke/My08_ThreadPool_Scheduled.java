package thread_invoke;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class My08_ThreadPool_Scheduled {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        long start = System.currentTimeMillis();
        System.out.println("start");
		// 延迟 2 秒后执行任务
		scheduledExecutorService.schedule(new RunnableTask(), 2, TimeUnit.SECONDS);

        System.out.println("start2" + (System.currentTimeMillis() - start));
		// 延迟 1 秒后开始执行任务，每 3 秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(new RunnableTask(), 1, 3, TimeUnit.SECONDS);

		// 等待一段时间，让所有任务有机会执行
		try {
			// 等待10秒，让定时任务执行几次
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 关闭线程池
		scheduledExecutorService.shutdown();

		try {
			// 等待所有任务完成
			if (!scheduledExecutorService.awaitTermination(1, TimeUnit.MINUTES)) {
				System.out.println("Still waiting...");
				scheduledExecutorService.shutdownNow();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			scheduledExecutorService.shutdownNow();
		}
	}

	private static class RunnableTask implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running");
		}
	}
}
