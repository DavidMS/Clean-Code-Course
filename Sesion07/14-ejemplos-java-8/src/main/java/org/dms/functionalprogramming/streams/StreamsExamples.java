package org.dms.functionalprogramming.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsExamples {

    public StreamsExamples() throws IOException {
    }

    public List<Material> getOrganics(Collection<Material> materials) {
        List<Material> result = new ArrayList<>();
        for(Material material : materials) {
            if(Type.ORGANIC == material.getType()) {
                result.add(material);
            }
        }
        return result;
    }

    public List<Material> getOrganicsStreams(Collection<Material> materials) {
        return materials.stream()
                .filter(m -> Type.ORGANIC == m.getType())
                .collect(Collectors.toList());
    }

    // COLLECTING
    public static String joinByComma(Collection<String> strings) {
        return strings.stream()
                .collect(Collectors.joining(", "));
    }

    // GROUPING
    public Map<Type, List<Material>> groupByType(Collection<Material> materials) {
        return materials.stream()
                .collect(Collectors.groupingBy(Material::getType));
    }

    // PARTITIONING
    public Map<Boolean, List<Material>> groupWithColor(Collection<Material> materials) {
        return materials.stream()
                .collect(Collectors.partitioningBy(this::hasColor));
    }

    // MAPPING
    public List<Type> getTypes(Collection<Material> materials) {
        return materials.stream()
                .map(Material::getType)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Object> merge(Collection<Collection<Object>> collection) {
        return collection.stream()
                .flatMap(c -> c.stream())
                .collect(Collectors.toList());
    }

    // FILTERING
    public List<Material> filterColored(Collection<Material> materials) {
        return materials.stream()
                .filter(this::hasColor)
                .collect(Collectors.toList());
    }

    // FILTERING UNIQUE ITEMS
    public static <T> List<T> unique(Collection<T> collection) {
        return collection.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // TRUNCATING A STREAM
    public static List<Integer> lowestTen(Collection<Integer> collection) {
        return collection.stream()
                .sorted()
                .limit(10)
                .collect(Collectors.toList());
    }

    // SKIPPING ELEMENTS
    public static List<Object> allButFirst(Collection<Object> collection) {
        return collection.stream()
                .skip(1)
                .collect(Collectors.toList());
    }

    // FINDING AND MATCHING
    // CHECKING ANY MATCH
    public boolean isThereAnyOrganic(Collection<Material> materials) {
        return materials.stream()
                .anyMatch(m -> m.getType() == Type.ORGANIC);
    }

    // CHECKING ALL MATCHES
    public static boolean allAreEven(Collection<Integer> integers) {
        return integers.stream()
                .allMatch(i -> i % 2 == 0);
    }

    // FINDING ANY MATCH
    public Material getAnyPlastic(Collection<Material> materials) {
        return materials.stream()
                .filter(m -> m.getType() == Type.PLASTIC)
                .findAny()
                .orElseThrow(() -> new RuntimeException());
    }

    // REDUCING
    public static String join(Collection<String> strings) {
        return strings.stream()
                .reduce("", (a, b) -> a + b);
    }

    public static int getLongest(Collection<String> strings) {
        return strings.stream()
                .map(String::length)
                .reduce(0, Math::max);
    }

    // NUMERIC STREAMS
    public static int sumLengths(Collection<String> strings) {
        return strings.stream()
                .mapToInt(String::length)
                .sum();
    }

    // RANGES
    public static long factorial(long number) {
        return LongStream.range(1, number + 1)
                .reduce(1, (a, b) -> a * b);
    }

    // BUILDING STREAMS
    // Streams from values
    Stream<String> stream = Stream.of("A", "stream", "of", "strings");

    // Streams from arrays
    int[] integers = {2, 3, 5, 7, 11};
    IntStream intStream = Arrays.stream(integers);

    // Streams from files
    long linesNumber = Files.lines(Paths.get("myFile.txt")).count();

    // Streams from functions
    public void streamIterate() {
        Stream.iterate(1, n -> n * 2)
                .limit(10)
                .forEach(System.out::println);
    }








    private boolean hasColor(Material material) {
        return material.hasColor();
    }


}
