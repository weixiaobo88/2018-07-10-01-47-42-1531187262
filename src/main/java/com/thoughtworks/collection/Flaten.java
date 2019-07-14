package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> list = new ArrayList<>();
        for (Integer[] innerArray : array) {
            for (int element : innerArray) {
                list.add(element);
            }
        }
        return list;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> list = new ArrayList<>();
        for (Integer[] innerArray : array) {
            for (int element : innerArray) {
                if (list.indexOf(element) == -1) {
                    list.add(element);
                }
            }
        }
        return list;
    }
}
