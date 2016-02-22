package part6.parallel;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * ============================== HOW TO RUN THIS TEST:
 * ====================================
 * 
 *
 * You can run this test:
 *
 * a) Via the command line: $ mvn clean install $ java -jar
 * target/benchmarks.jar ".*JMHSample_22.*" -t $CPU
 *
 * b) Via the Java API:
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, batchSize = 1)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
public class SimpleBenchmarkCompletableFuture {

	private static final int NUMBER_OF_WORDS = 2000;

	public static void main(String[] args) throws RunnerException, InterruptedException, ExecutionException {
		Options opt = new OptionsBuilder().include(".*" + SimpleBenchmarkCompletableFuture.class.getSimpleName() + ".*")
				.build();

		new Runner(opt).run();
	}

	@State(Scope.Benchmark)
	public static class DetailsBenchmark {

		public ExecutorService executorService;
		public Collection<String> names;

		public DetailsBenchmark() {
			Stream<String> stream = Stream.generate(BenchmarkDataProvider::generateStringsDefault)
					.limit(NUMBER_OF_WORDS);
			names = stream.collect(Collectors.toList());

			executorService = Executors.newCachedThreadPool();
		}
	}

	@Benchmark
	@Group("CompletableFuture")
	public static long benchmarkCompletableFuture(DetailsBenchmark detailsBenchmark) {
		LongAdder adder = new LongAdder();
		detailsBenchmark.names.forEach(

		(name) -> CompletableFuture.supplyAsync(() -> name).
		thenApplyAsync(SimpleBenchmarkCompletableFuture::contains)
		.thenAccept(b -> SimpleBenchmarkCompletableFuture.incrementIfTrue(b, adder)));

		//unaccurate value, i need to find a way to verify that all tasks have been completed		
		return adder.longValue();
	}
	
	@Benchmark
	@Group("CompletableFutureWithExecutorService")
	public static long benchmarkCompletableFutureWithES(DetailsBenchmark detailsBenchmark) throws InterruptedException {	
		LongAdder adder = new LongAdder();
		detailsBenchmark.names.forEach(
				
		(name) -> CompletableFuture.supplyAsync(() -> name, detailsBenchmark.executorService)
				.thenApplyAsync(SimpleBenchmarkCompletableFuture::contains, detailsBenchmark.executorService)
				.thenAccept((b) -> SimpleBenchmarkCompletableFuture.incrementIfTrue(b, adder))

		);
		
		detailsBenchmark.executorService.shutdown();
		detailsBenchmark.executorService.awaitTermination(1, TimeUnit.DAYS);
		return adder.longValue();		
	}

	
	
	@Benchmark
	@Group("CompletableFuture")
	public static long benchmarkCompletableFuture2(DetailsBenchmark detailsBenchmark) {
	 
	 List<CompletableFuture<Integer>> values = detailsBenchmark.names.stream()	           
	           .map((String word) -> 
	           	CompletableFuture.
	           	supplyAsync(() -> SimpleBenchmarkCompletableFuture.createTask(word), detailsBenchmark.executorService).
	           	thenApplyAsync(SimpleBenchmarkCompletableFuture::contains, detailsBenchmark.executorService).
	           	thenApply(SimpleBenchmarkCompletableFuture::transform)).collect(Collectors.toList());        			
	           
	 //wait for all task to finish
	 CompletableFuture.allOf(values.toArray(new CompletableFuture[values.size()])).join();
	 return values.size();
	 
	}
	
	@Benchmark
	@Group("CompletableFuture")
	public static long benchmarkCompletableFuture3(DetailsBenchmark detailsBenchmark)
			throws InterruptedException, ExecutionException {

		CompletableFuture<Integer> cf = new CompletableFuture<>();
		
		detailsBenchmark.names.stream().forEach((String word) -> cf.thenCombine(			
				CompletableFuture
						.supplyAsync(() -> SimpleBenchmarkCompletableFuture.createTask(word),
								detailsBenchmark.executorService)
						.thenApplyAsync(SimpleBenchmarkCompletableFuture::contains, detailsBenchmark.executorService)
						.thenApply(SimpleBenchmarkCompletableFuture::transform),
				SimpleBenchmarkCompletableFuture.incrementBiFunction()));

		// This will never work, we need a reference to the previous completedFuture to chain them (similar to recursion) if we want to incremente values without
		// using an externa value (as in the case of the LongAdder)
		cf.complete(0);
		System.out.println("=================" +cf.get());		
		return cf.get();

	}
	
	private static String createTask(String n){
		//System.out.println(Thread.currentThread().getName());
		return n;
	}
	
	private static boolean contains(String n){
		//System.out.println(Thread.currentThread().getName());
		return n.contains("A");
	}
	
	private static Integer transform(Boolean present){
		//System.out.println(Thread.currentThread().getName());
		return present? 1 : 0;
	}
	
	private static BiFunction<Integer, Integer, Integer> incrementBiFunction () {
		return (i1, i2) -> SimpleBenchmarkCompletableFuture.increment(i1, i2);
	}
	
	private static void incrementIfTrue(boolean present, LongAdder adder){		
		//System.out.println(Thread.currentThread().getName());
		if(present)adder.increment();
	}

	private static Integer increment(Integer i1, Integer i2){		
		return i1 + i2;
	}
	
}
