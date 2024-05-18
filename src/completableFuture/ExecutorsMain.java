package completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsMain {
	public static void main(String[] args) {
		// 아래는 ExecutorService를 이용하여 스레드를 관리하는 방법.
		/*
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(getRunnable("Hello"));
		executorService.submit(getRunnable("Paul"));
		executorService.submit(getRunnable("KakA"));
		executorService.submit(getRunnable("Java"));
		executorService.submit(getRunnable("PPP"));

		executorService.shutdown();
		*/

	/*
		// 아래처럼 ScheduledExecutorService를 이용하면 다양한 기능 사용 가능.
		// shutdown()을 호출하면 내부 thread들이 interruptException을 받기 때문에 종료.
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);

		// executorService.shutdown();
	*/

	}

	private static Runnable getRunnable(String message) {
		return () -> System.out.println(message + Thread.currentThread().getName());
	}

}
