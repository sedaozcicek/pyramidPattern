package com.example.pyramid.service;

import org.springframework.stereotype.Component;

@Component
public class DefaultPyramidService implements PyramidService{
    @Override
    public String printPyramid(int size) {
        StringBuilder pyramid = new StringBuilder();
        for (int level = 1; level <= size; level++) {
            final int currentLevel = level;
            var row = new StringBuilder();

            row.append(java.util.stream.IntStream.range(currentLevel, 2 * currentLevel)
                    .mapToObj(String::valueOf)
                    .reduce((a, b) -> a + " " + b)
                    .orElse(""));

            row.append(" ");

            row.append(java.util.stream.IntStream.iterate(2 * currentLevel - 2, num -> num >= currentLevel, num -> num - 1)
                    .mapToObj(String::valueOf)
                    .reduce((a, b) -> a + " " + b)
                    .orElse(""));

            pyramid.append(row.toString().trim()).append("\n");
        }
        return pyramid.toString();
    }
}
