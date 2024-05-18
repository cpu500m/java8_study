package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFuture1 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// useFuture();
		useCompletableFuture();

	}

	public static void useFuture() throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Future<String> future = executorService.submit(() -> "hello");

		// callBack을 쓰고싶은데 get호출하기 이전에는 쓸 수가 없음. 이게 문제.

		future.get();

		executorService.shutdown();
	}

	public static void useCompletableFuture() throws ExecutionException, InterruptedException {
		// 1. 이렇게 기본값을 줄 수 있음.
		/*
		CompletableFuture<String> future = CompletableFuture.completedFuture("hello");

		System.out.println(future.get());
		*/

		// 2. 리턴 값이 없는 경우
		/*
		CompletableFuture<Void> asyncFuture = CompletableFuture.runAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
		});
		asyncFuture.get();
		*/

		// 3. 리턴 값이 있는 경우
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "hello";
		}).thenApply((s) -> {
			System.out.println(Thread.currentThread().getName());
			return s.toUpperCase();
		});
		future.get();
	}
}
