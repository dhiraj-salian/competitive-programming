package com.dhirajsalian.cp.dsa;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet<T> {
    private final int[] rank;
    private final int[] parent;
    private final T[] elements;
    private final Map<T, Integer> elementsIndexMap;

    public DisjointSet(T[] elements) {
        this.elements = elements;
        elementsIndexMap = new HashMap<>();
        parent = new int[elements.length];
        rank = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            if (elementsIndexMap.containsKey(elements[i]))
                throw new IllegalArgumentException("No duplicate elements allowed");
            elementsIndexMap.put(elements[i], i);
            parent[i] = i;
            rank[i] = 0;
        }

    }

    public void union(T element1, T element2) {
        T element1Representative = find(element1), element2Representative = find(element2);
        if (element1Representative.equals(element2Representative)) return;
        int element1RepIndex = elementsIndexMap.get(element1Representative);
        int element2RepIndex = elementsIndexMap.get(element2Representative);
        if (rank[element1RepIndex] < rank[element2RepIndex]) parent[element1RepIndex] = element2RepIndex;
        else if (rank[element2RepIndex] < rank[element1RepIndex]) parent[element2RepIndex] = element1RepIndex;
        else {
            parent[element2RepIndex] = element1RepIndex;
            rank[element1RepIndex]++;
        }
    }

    public T find(T element) {
        Integer index = elementsIndexMap.get(element);
        if (null == index)
            throw new IllegalArgumentException("Element not found");
        if (index == parent[index]) return element;
        T representative = find(elements[parent[index]]);
        parent[index] = elementsIndexMap.get(representative);
        return representative;
    }
}
