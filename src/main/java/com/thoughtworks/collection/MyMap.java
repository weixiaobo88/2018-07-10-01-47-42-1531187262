package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream()
                .map(item -> item * 3)
                .collect(toList());
    }

    public List<String> mapLetter() {
        return array.stream()
                .map(this::mapSingleLetter)
                .collect(toList());
    }

    private String mapSingleLetter(int number) {
        return number > 0 ? letters[number - 1] : "";
    }

    public List<String> mapLetters() {
        return array.stream()
                .map(number -> {
                    if (number > 26) {
                        int first = number / 26;
                        int second = number % 26;
                        if (second == 0) {
                            return letters[0] + letters[25];
                        }
                        return letters[first - 1] + letters[second - 1];
                    }
                    return letters[number - 1];
                })
                .collect(toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream()
                .sorted(Comparator.reverseOrder())
                .collect(toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream()
                .sorted()
                .collect(toList());
    }
}
