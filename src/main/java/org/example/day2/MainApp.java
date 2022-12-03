package org.example.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {
        try (Stream<String> moves = Files.lines(Path.of("./src/main/java/org/example/day2/input"))) {

            Map<String, Integer> outcomesMap = Map.of("A X", 4, "A Y", 8, "A Z", 3,
                    "B X", 1, "B Y", 5, "B Z", 9,
                    "C X", 7, "C Y", 2, "C Z", 6);

            int sum = moves.map(outcomesMap::get).reduce(0, Integer::sum);
            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
