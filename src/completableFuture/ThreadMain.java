package completableFuture;

// 스레드를 생성하는 법
public class ThreadMain {
	public static void main(String[] args) throws InterruptedException {

		// 1번 방법
		/*
		MyThread myThread = new MyThread();
		myThread.start();

		System.out.println("Hello");
		*/

		// 2번 방법. Runnable 구현하기. Runnable은 함수형 인터페이스라 아래처럼 람다식으로 가능
/*
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread: " + Thread.currentThread().getName());
			}
		});
		thread.start();

		Thread thread2 = new Thread(() -> System.out.println("Thread: " + Thread.currentThread().getName()));
		thread2.start();
*/

		// 아채처럼 스레드들을 sleep, join , interrupt를 이용해 관리할 수 있지만
		// 스레드가 많아지면 직접 관리하기가 매우 골치아프다. 그래서 executors가 필요.
		Thread thread = new Thread(() -> {
			System.out.println("Thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		});
		thread.start();

		System.out.println("Hello: " + Thread.currentThread().getName());
		thread.join();
		System.out.println(thread + " is finished");

	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("Thread: " + Thread.currentThread().getName());
		}
	}
}
