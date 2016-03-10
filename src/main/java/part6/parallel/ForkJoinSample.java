package part6.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Stream;


public class ForkJoinSample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		usingCommonForkJoinPool();
		usingCustomForkJoinPool();
		
	}

	public static void usingCommonForkJoinPool() {

		System.out.println("============================================");
		System.out.println("==============Common ForkJoin Pool==========");
		System.out.println("============================================");
		
		System.out.println("Default Pool Parallelism: " + ForkJoinPool.getCommonPoolParallelism());
		
		long count = getNumbers().parallelStream()
				.map(n -> printOperationDetails(1, n))
				.map(n -> printOperationDetails(2, n))
				.count();
		System.out.println("Count: " + count);
	}
	

	public static void usingCustomForkJoinPool() throws InterruptedException, ExecutionException {
		
		System.out.println("============================================");
		System.out.println("==============Custom ForkJoin Pool==========");
		System.out.println("============================================");
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(10);
		System.out.println("Default Pool Parallelism: " + forkJoinPool.getParallelism());
		
		Stream<Integer> stream = getNumbers().parallelStream()
				.map(n -> printOperationDetails(1, n))
				.map(n -> printOperationDetails(2, n));
						
		
		ForkJoinTask<?> future = forkJoinPool.submit(() -> stream.count());

		System.out.println("Main threa does something else");

		System.out.println("Count: " + future.get());
	}
		
	private static List<Integer> getNumbers() {
		return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
	}

	private static int printOperationDetails(int mapping, int n) {
		System.out.println(Thread.currentThread().getName() + " Mapping: "+ mapping + " Element: " + n);
		try {
			Thread.sleep(1000 * n);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		return n;
		
	}
}
