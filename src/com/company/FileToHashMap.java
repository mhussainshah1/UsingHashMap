package com.company;
//This is the example from StackOverFlow.com

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;

public class FileToHashMap {
    public static void main(String[] args) throws IOException {
        String delimiter = " ";
        Map<String, String> map = new HashMap<>();

        try (Stream<String> lines = Files.lines(Paths.get("out\\production\\UsingHashMap\\com\\company\\test.txt"))) {
            lines.filter(line -> line.contains(delimiter)).forEach(
                    line -> map.putIfAbsent(line.split(delimiter)[0], line.split(delimiter)[1])
            );
        }

        System.out.println(map);
    }
}