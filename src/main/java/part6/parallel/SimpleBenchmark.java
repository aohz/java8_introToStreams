package part6.parallel;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.TimeUnit;
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
 * ============================== HOW TO RUN THIS TEST: ====================================
 * 
 *
 * You can run this test:
 *
 * a) Via the command line:
 *    $ mvn clean install
 *    $ java -jar target/benchmarks.jar ".*JMHSample_22.*" -t $CPU
 *
 * b) Via the Java API:
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 20, batchSize = 1)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
public class SimpleBenchmark {
	
	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(".*" + SimpleBenchmark.class.getSimpleName() + ".*").build();

		new Runner(opt).run();
	}

	@State(Scope.Benchmark)
	public static class DetailsBenchmark {

		public Collection<String> names;

		public DetailsBenchmark() {
			Stream<String> stream = Stream.generate(SimpleBenchmark::generateStringsDefault).limit(NUMBER_OF_WORDS);			
			names = stream.collect(Collectors.toList());
		}
	}
	
	@Benchmark
	@Group("ActiveIterator")
	public static long benchmarkActiveIterator(DetailsBenchmark detailsBenchmark) {
		long count = 0;
		for (String name : detailsBenchmark.names) {			
			if (name.contains("A"))
				++count;
		}		
		return count;
	}	
	
	@Benchmark
	@Group("SequentialStream")
	public static long benchmarkSequential(DetailsBenchmark detailsBenchmark) {
		return detailsBenchmark.names.stream().filter(name -> name.contains("A")).count();		
	}

	@Benchmark
	@Group("ParallelStreamStream")
	public static long benchmarkParallel(DetailsBenchmark detailsBenchmark) {
		return detailsBenchmark.names.parallelStream().filter(name -> name.contains("A")).count();		
	}
	
	private static final String ABC = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHARACTERS = "0123456789" + ABC + ABC.toUpperCase() + "{}[]()";
	private static final int MAX_WORD_LENGTH = 1000;
	private static final int NUMBER_OF_WORDS = 2000;
	
	public static String generateStringsDefault() {
		return generateStrings(new Random(), CHARACTERS, new Random().nextInt(MAX_WORD_LENGTH));
	}
	
	public static String generateStrings(Random random, String characters, int length) {
	    StringBuilder sb = new StringBuilder(length);
	    for (int i = 0; i < length; i++) {
	        sb.append(characters.charAt(random.nextInt(characters.length())));
	    }
	    return sb.toString();
	}
}
