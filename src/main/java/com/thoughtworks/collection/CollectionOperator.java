package com.thoughtworks.collection;

import org.apache.commons.collections.ListUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int leftBorder = left < right ? left : right;
        int rightBorder = left < right ? right : left;
        Stream<Integer> result = IntStream.rangeClosed(leftBorder, rightBorder)
                .boxed();
        return left < right ? result.collect(Collectors.toList()) : result.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {

        int leftBorder = left < right ? left : right;
        int rightBorder = left < right ? right : left;
        Stream<Integer> result = IntStream.rangeClosed(leftBorder, rightBorder)
                .boxed()
                .filter(number -> number % 2 == 0);

        return left < right ? result.collect(Collectors.toList()) : result.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int element : array) {
            if (element % 2 == 0) {
                list.add(element);
            }
        }
        return list;
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> list = new ArrayList<>();
        for (int element : firstArray) {
            for (int elementOfSecond : secondArray) {
                if (element == elementOfSecond) {
                    list.add(element);
                }
            }
        }
        return list;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> list = new ArrayList<>();
        for (int elementOfSecond : secondArray) {
            boolean flag = true;
            for (int element : firstArray) {
                if (element == elementOfSecond) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(elementOfSecond);
            }
        }
        return ListUtils.union(Arrays.asList(firstArray), list);
    }
}
