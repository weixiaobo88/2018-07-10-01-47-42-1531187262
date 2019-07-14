package com.thoughtworks.collection;

import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> list = new ArrayList<>();
        int start = left < right ? left : right;
        int end = left < right ? right : left;
        for (int element = start; element < end + 1; element++) {
            list.add(element);
        }
        if (left > right) {
            Collections.reverse(list);
        }
        return list;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> list = new ArrayList<>();
        int start = left < right ? left : right;
        int end = left < right ? right : left;
        for (int element = start; element < end + 1; element++) {
            if (element % 2 == 0) {
                list.add(element);
            }
        }
        if (left > right) {
            Collections.reverse(list);
        }
        return list;
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
