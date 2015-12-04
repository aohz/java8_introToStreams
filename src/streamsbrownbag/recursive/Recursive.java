package streamsbrownbag.recursive;

import java.util.stream.Stream;

public class Recursive {

    public static void main(String args[]) {

        // Stream.iterate
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .map(x -> x+" ")
                .forEach(System.out::print);
        System.out.println();
        
        // fibonnaci with iterate
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)                
                .forEach(t -> System.out.print("(" + t[0] + ", " + t[1] + ") "));
        System.out.println();
        
        
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .map(x -> x+" ")
                .forEach(System.out::print);
        System.out.println();

        // random stream of doubles with Stream.generate
        Stream.generate(Math::random)
                .limit(10)
                .map(x -> x+" ")
                .forEach(System.out::print);
        System.out.println();       
    }

}
