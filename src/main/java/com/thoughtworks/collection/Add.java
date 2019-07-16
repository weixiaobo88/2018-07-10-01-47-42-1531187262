package com.thoughtworks.collection;

import org.apache.commons.collections.ListUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Add {
    public static List<Integer> getLeftAndRight(int leftBorder, int rightBorder) {
        int left = leftBorder < rightBorder ? leftBorder : rightBorder;
        int right = leftBorder < rightBorder ? rightBorder : leftBorder;
        return asList(left, right);
    }

    public int getSumOfEvens(int leftBorder, int rightBorder) {
        List<Integer> list = getLeftAndRight(leftBorder, rightBorder);
        int left = list.get(0);
        int right = list.get(1);

        return IntStream.rangeClosed(left, right)
                .filter(number -> number % 2 == 0)
                .sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        List<Integer> list = getLeftAndRight(leftBorder, rightBorder);
        int left = list.get(0);
        int right = list.get(1);

        return IntStream.rangeClosed(left, right)
                .filter(number -> number % 2 != 0)
                .sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .mapToInt(number -> number * 3 + 2)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(number -> {
                    if (number % 2 != 0) {
                        return number * 3 + 2;
                    }
                    return number;
                })
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 != 0)
                .mapToInt(number -> number * 3 + 5)
                .sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream()
                .filter(number -> number % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        int size = evenList.size();
        if (size % 2 == 1) {
            return evenList.get((1 + size) / 2 - 1);
        }
        return (evenList.get(size / 2 - 1) + evenList.get((size + 2) / 2 - 1)) / 2;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .summaryStatistics()
                .getAverage();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .anyMatch(element -> element.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evens = arrayList.stream()
                .filter(number -> number % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        List<Integer> odds = arrayList.stream()
                .filter(number -> number % 2 != 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return Stream.of(evens, odds)
                .flatMap(Collection::parallelStream)
                .collect(Collectors.toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return arrayList.stream()
                .map(number -> {
                    int index = arrayList.indexOf(number);
                    if (index < (arrayList.size() - 1)) {
                        return (number + arrayList.get(index + 1)) * 3;
                    }
                    return 0;
                })
                .filter(number -> number != 0)
                .collect(Collectors.toList());
    }
}
