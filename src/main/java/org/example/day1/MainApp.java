package org.example.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class MainApp {
    public static void main(String[] args) {
        List<Integer> sums = sumItUp(Path.of("./src/main/java/org/example/day1/input"));
        sums.sort((x, y) -> y - x);

        System.out.println(sums.get(0));
        System.out.println(sums.subList(0, 3).stream().mapToInt(Integer::intValue).sum());
    }

    public static List<Integer> sumItUp(Path path) {
        List<Integer> sums = new ArrayList<>();
        try (Stream<String> lines = Files.lines(path)) {
            List<String> linesList = lines.toList();
            int total = 0;
            for (String line : linesList) {
                if (!line.isEmpty()) {
                    total += Integer.parseInt(line);
                } else {
                    sums.add(total);
                    total = 0;
                }
            }
            sums.add(total);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sums;
    }
}
