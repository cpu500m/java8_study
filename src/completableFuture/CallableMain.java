package completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		useInvoke();
	}

	public static void useCallableBasic() throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<String> hello = () -> {
			Thread.sleep(2000);
			return "hello";
		};

		Future<String> helloFuture = executorService.submit(hello);
		System.out.println(helloFuture.isDone());
		System.out.println("Started!");

		// 이렇게 취소할 수도 있음. 인자로 주는 boolean은
		// true는 현재 진행중인 작업을 interrupt하면서 종료. false는 interrupt를 보내지는 않고  기다림. 그냥 취소만.
		// helloFuture.cancel(false);

		helloFuture.get(); // 블록킹

		System.out.println(helloFuture.isDone());
		System.out.println("End!!");
		executorService.shutdown();
	}

	public static void useInvoke() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Callable<String> hello = () -> {
			Thread.sleep(2000);
			return "Hello";
		};

		Callable<String> java = () -> {
			Thread.sleep(3000);
			return "java";
		};

		Callable<String> paul = () -> {
			Thread.sleep(1000);
			return "paul";
		};

		// invokeAll의 경우 모든 스레드가 작업을 끝날 때 까지 기다림. 한 스레드가 일찍 끝났어도 기다리는거임.
		/*
		List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, paul));

		for (Future<String> f : futures) {
			System.out.println(f.get());
		}
		*/

		// invokeAny의 경우 하나만 끝나면 바로 리턴.
		String s = executorService.invokeAny(Arrays.asList(hello, java, paul));
		System.out.println(s);

		executorService.shutdown();
	}
}
