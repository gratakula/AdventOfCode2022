package org.example.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


public class MainApp {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        try (Stream<String> lines = Files.lines(Path.of("./src/main/java/org/example/day1/input"))) {
            List<String> linesList = lines.toList();
            List<Integer> sums = new ArrayList<>();
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

            System.out.println(Collections.max(sums));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
