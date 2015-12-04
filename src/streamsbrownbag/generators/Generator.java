package streamsbrownbag.generators;

import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Generator {

    public static void main(String args[]) throws Exception {
        // stream of 1s with Stream.generate
        IntStream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::print);
        System.out.println();

        IntStream.generate(new IntSupplier() {
            public int getAsInt() {
                return 2;
            }
        }).limit(5)
                .forEach(System.out::println);

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            public int getAsInt() {
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

        long uniqueWords = Files.lines(getFilePath(), Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();

        System.out.println("There are " + uniqueWords + " unique words in data.txt");
    }

    private static Path getFilePath() {
        try {
            return Paths.get(Generator.class.getClassLoader().getResource("data/data.txt").toURI());
        } catch (URISyntaxException ex) {
            return null;
        }
    }

}
