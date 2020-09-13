package pl.k.kamil.java;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextInt(50));

        }

        System.out.println(numbers);
        System.out.println(getUniqueValues(numbers));
        System.out.println(getDuplicatedValues(numbers));


    }

    private static Set<Integer> getUniqueValues(List<Integer> numbers) {
        Set<Integer> uniqueValues = new HashSet<>(numbers);

        return uniqueValues;
    }

    private static Set<Integer> getDuplicatedValues(List<Integer> numbers) {
        Map<Integer, Integer> valuesCountsMap = new HashMap<>();
        for (Integer number : numbers) {
            if (!valuesCountsMap.containsKey(number)) {
                valuesCountsMap.put(number, 1);
            } else {

                valuesCountsMap.put(number, valuesCountsMap.get(number) + 1);
            }


        }


        return valuesCountsMap.entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }


}
