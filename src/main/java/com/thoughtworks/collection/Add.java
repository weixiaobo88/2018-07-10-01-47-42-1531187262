package com.thoughtworks.collection;

import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int left = leftBorder < rightBorder ? leftBorder : rightBorder;
        int right = leftBorder > rightBorder ? leftBorder : rightBorder;
        int sum = 0;
        for (int i = left; i < right + 1; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int left = leftBorder < rightBorder ? leftBorder : rightBorder;
        int right = leftBorder > rightBorder ? leftBorder : rightBorder;
        int sum = 0;
        for (int i = left; i < right + 1; i++) {
            if (i % 2 == 1) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = 0;
        for (int item : arrayList) {
            sum += (item * 3 + 2);
        }
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();

        for (int element : arrayList) {
            if (element % 2 == 0) {
                result.add(element);
            } else {
                result.add(element * 3 + 2);
            }
        }
        return result;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int sum = 0;
        for (int element : arrayList) {
            if (element % 2 == 1) {
                sum += (element * 3 + 5);
            }
        }
        return sum;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = new ArrayList<>();
        for(int element: arrayList) {
            if(element % 2 == 0) {
                evenList.add(element);
            }
        }
        Collections.sort(evenList);
        int size = evenList.size();
        if (size % 2 == 1) {
            return evenList.get((1 + size) / 2 - 1);
        }
        return (evenList.get(size/2 - 1) + evenList.get((size+2)/2 - 1))/2;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        int sum = 0;
        int count = 0;
        for(int element: arrayList) {
            if(element % 2 == 0) {
                sum += element;
                count++;
            }
        }
        return sum / count;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> evenList = new ArrayList<>();
        for(int element: arrayList) {
            if(element % 2 == 0) {
                evenList.add(element);
            }
        }
        return evenList.indexOf(specialElment) > -1;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> evenList = new ArrayList<>();
        for(int element: arrayList) {
            if(element % 2 == 0 && evenList.indexOf(element) == -1) {
                evenList.add(element);
            }
        }
        return evenList;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        for(int element: arrayList) {
            if(element % 2 == 0) {
                evenList.add(element);
            } else {
                oddList.add(element);
            }
        }
        Collections.sort(evenList);
        Collections.sort(oddList, Collections.reverseOrder());

        return ListUtils.union(evenList, oddList);
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int element : arrayList) {
            int index = arrayList.indexOf(element);
            if (index == arrayList.size() - 1) {
                break;
            }
            result.add((element + arrayList.get(index + 1)) * 3);
        }
        return result;
    }
}
