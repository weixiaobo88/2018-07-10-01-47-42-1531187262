package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream()
                .mapToInt(number -> number)
                .summaryStatistics()
                .getMax();
    }

    public double getMinimum() {
        return arrayList.stream()
                .mapToInt(number -> number)
                .summaryStatistics()
                .getMin();
    }

    public double getAverage() {
        return arrayList.stream()
                .mapToInt(number -> number)
                .summaryStatistics()
                .getAverage();
    }

    public double getOrderedMedian() {
        List<Integer> list = arrayList.stream()
                .sorted()
                .collect(Collectors.toList());
        int size = list.size();
        if (size % 2 == 1) {
            return list.get(size / 2);
        }
        return (list.get(size / 2 - 1) + list.get(size / 2)) * 0.5;

    }

    public int getFirstEven() {
        Optional<Integer> optionalInteger = arrayList.stream()
                .filter(number -> number % 2 == 0)
                .findFirst();
        if (optionalInteger.isPresent()) {
            return optionalInteger.get();
        }
        throw new NoSuchElementException();
    }

    public int getIndexOfFirstEven() {
        Optional<Integer> optionalInteger = arrayList.stream()
                .filter(number -> number % 2 == 0)
                .findFirst();
        if (optionalInteger.isPresent()) {
            return arrayList.indexOf(optionalInteger.get());
        }
        throw new NoSuchElementException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        return arrayList.equals(this.arrayList);
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        int size = arrayList.size();
        if (size % 2 == 1) {
            return Double.valueOf(arrayList.get(size /2));
        }
        return (arrayList.get(size / 2 - 1) + arrayList.get(size / 2)) * 0.5;
    }

    public int getLastOdd() {
        List<Integer> list = arrayList.stream()
                .filter(number -> number % 2 != 0)
                .collect(Collectors.toList());
        return list.get(list.size() - 1);
    }

    public int getIndexOfLastOdd() {
        List<Integer> list = arrayList.stream()
                .filter(number -> number % 2 != 0)
                .collect(Collectors.toList());
        return arrayList.indexOf(list.get(list.size() - 1));
    }
}
