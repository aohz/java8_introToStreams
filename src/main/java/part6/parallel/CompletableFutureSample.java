package part6.parallel;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 
 * @author aohz
 *
 */
public class CompletableFutureSample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		basicUsage();
		syncExecution();
		asyncExecution();
		combine();
	}

	public static void basicUsage() throws InterruptedException, ExecutionException {

		System.out.println("============================================");
		System.out.println("==============Basic Usage===================");
		System.out.println("============================================");

		final CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

		new Thread(Thread.currentThread().getName() + " " + completableFuture.complete(100)).start();

		System.out.println("Thread waits for completion");
		System.out.println(Thread.currentThread().getName() + " " + completableFuture.get());
	}

	public static void syncExecution() throws InterruptedException, ExecutionException {

		System.out.println("============================================");
		System.out.println("==============Sync Execution=================");
		System.out.println("=============================================");

		CompletableFuture<Integer> syncCF = CompletableFuture.supplyAsync(increment("Sync CF", 0))
				.thenApply(increment("Sync CF"));

		System.out.println("Thread waits for completion");
		System.out.println(syncCF.get());
	}
	
	public static void asyncExecution() throws InterruptedException, ExecutionException {

		System.out.println("============================================");
		System.out.println("==============Async Execution==========");
		System.out.println("============================================");

		CompletableFuture<Integer> asyncCF = CompletableFuture.supplyAsync(increment("Async CF", 0))
				.thenApplyAsync(increment("Async CF"));

		System.out.println("Thread waits for completion");
		System.out.println(asyncCF.get());
	}

	public static void combine() throws InterruptedException, ExecutionException {
		
		System.out.println("============================================");
		System.out.println("==============Combine Execution==========");
		System.out.println("============================================");
		
		CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(increment("CF1", 0))
				.thenApply(increment("CF1")).thenApply(increment("CF1"));

		CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(increment("CF2", 0))
				.thenApplyAsync(increment("CF2"));
		
		CompletableFuture<Integer> combinedCF = cf1.thenCombine(cf2, (Integer i1, Integer i2) -> i1 + i2);

		System.out.println(Thread.currentThread().getName() + " " + combinedCF.get());

	}
	
	private static Supplier<Integer> increment(String message, int baseNumber) {
		return () -> increment(message).apply(baseNumber);
	}
	
	private static Function<Integer, Integer> increment(String message) {
		return (n) -> {
			n++;
			System.out.println(Thread.currentThread().getName() + " " + message + " Element: " + n);
			try {
				Thread.sleep(1000 * n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return n;
		};
	}
}
