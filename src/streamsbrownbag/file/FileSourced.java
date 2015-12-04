package streamsbrownbag.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import streamsbrownbag.model.Person;

public class FileSourced {

    public static void main(String args[]) throws IOException, URISyntaxException {
        URI inputURI = FileSourced.class.getClassLoader().getResource("data/namesNoAge.csv").toURI();
        System.out.println(inputURI);
        Path inPath = Paths.get(inputURI);

        Path outPath = inPath.getParent().resolve("namesWithAge.csv");
        System.out.println(outPath);

        try (BufferedReader reader = Files.newBufferedReader(inPath);
                BufferedWriter writer = Files.newBufferedWriter(outPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING)) {
            reader.lines()
//                    .parallel()
                    .map((String record) -> record + "\t" + ThreadLocalRandom.current().nextInt(19, 83))
//                    .map(Person::fromCsv) //This maps Strings to person using method reference
                    .map((String record) -> {
                        String[] split = record.split("\t");
                        return new Person(split[0], split[1], Integer.valueOf(split[2]));
                    })
//                    .sequential()
                    .sorted((Person p1, Person p2) -> Integer.valueOf(p1.getAge()).compareTo(p2.getAge()))
                    .forEach((Person p) -> {
                        String line = String.join("\t", p.getName(), p.getSurname(), Integer.toString(p.getAge()));
                        try {
                            writer.write(line);
                            writer.write(System.lineSeparator());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
