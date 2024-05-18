package completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFuture2 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// useFuture();
		// useCompletableFutureCompose();
		// useCompletableFutureCombine();
		// useAllOf();
		// useAnyOf();
		useExceptionHandle();
	}

	// 이전에는 비동기 작업 2개를 이어서 하려면 아래처럼 하는 거 말곤 없었음
	public static void useFuture() throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<String> hello = executorService.submit(() -> "hello");
		Future<String> world = executorService.submit(() -> "world");

		System.out.println((hello.get()));
		System.out.println((world.get()));

		executorService.shutdown();
	}

	public static void useCompletableFutureCompose() throws ExecutionException, InterruptedException {
		CompletableFuture<String> hello = getHello();

		// 이렇게 hello작업 -> world작업 비동기처리가 가능함.
		CompletableFuture<String> future = hello.thenCompose(CompletableFuture2::getWorld);
		System.out.println(future.get());
	}

	public static void useCompletableFutureCombine() throws ExecutionException, InterruptedException {
		CompletableFuture<String> hello = getHello();

		CompletableFuture<String> future = hello.thenCombine(getWorld("temp"), (h, w) -> {
			return h + " " + w;
		});

		System.out.println(future.get());
	}

	/* 3개 이상의 여러 작업을 동시에 처리하고 싶을 때. */
	// 모든 작업이 끝날때 까지 기다리는 allOf
	public static void useAllOf() throws ExecutionException, InterruptedException {

		// 각각의 스레드 리턴 타입이 다를 수 있음. (어떤애는 Future<String> 어떤애는 Futrue<Integer> 등등..)
		// 그레서 리턴 결과값은 null임.
		/*
		CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(getHello(), getWorld("hi"))
			.thenAccept(System.out::println);
		System.out.println(voidCompletableFuture.get());
*/

		//  결과값을 받아야하는 상황이라면 아래처럼 할 수 있음. 좀 복잡함
		List<CompletableFuture<String>> futures = Arrays.asList(getHello(), getWorld("hi"));

		CompletableFuture[] futuresArray = futures.toArray(futures.toArray(new CompletableFuture[futures.size()]));

		CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
			.thenApply(v ->
				futures.stream()
					.map(CompletableFuture::join)
					.toList()
			);
		results.get().forEach(System.out::println);

	}

	public static void useAnyOf() throws ExecutionException, InterruptedException {
		CompletableFuture<Void> future = CompletableFuture.anyOf(getHello(), getWorld("hi"))
			.thenAccept(System.out::println);
		future.get();
	}

	public static void useExceptionHandle() throws ExecutionException, InterruptedException {
		// 예외 던지는 상황 만들기위해 임시로 넣어줌
		boolean throwError = true;

		CompletableFuture<String> hello = CompletableFuture.allOf(getWorld("ya "), getHello()).thenApply(t -> {
			if (throwError) {
				throw new IllegalStateException();
			}
			System.out.println("hi! " + Thread.currentThread().getName());
			return "hello!";
		}).handle((result, ex) -> {
			if (ex != null) {
				System.out.println(ex);
				return "error!";
			}
			return result;
		});

		System.out.println(hello.get());

	}

	private static CompletableFuture<String> getHello() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		});
	}

	private static CompletableFuture<String> getWorld(String message) {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("World " + Thread.currentThread().getName());
			return message + " world";
		});
	}
}
