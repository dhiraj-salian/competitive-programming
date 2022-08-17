//Problem: https://leetcode.com/problems/distant-barcodes/

package com.dhirajsalian.cp.leetcode.problemPatterns.distantBarcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        List<Map.Entry<Integer, Integer>> valueCountList = getValueCountMapSortedByCount(barcodes);
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : valueCountList) {
            int value = entry.getValue();
            for (; index < barcodes.length && value > 0; index++, value--)
                barcodes[index] = entry.getKey();
        }
        int[] newBarcode = new int[barcodes.length];
        int oldIndex = 0;
        for (int i = 0; i < barcodes.length; i += 2, oldIndex++) {
            newBarcode[i] = barcodes[oldIndex];
        }
        for (int i = 1; i < barcodes.length; i += 2, oldIndex++) {
            newBarcode[i] = barcodes[oldIndex];
        }
        return newBarcode;
    }

    private List<Map.Entry<Integer, Integer>> getValueCountMapSortedByCount(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> {
            if (b.getValue().equals(a.getValue()))
                return b.getKey().compareTo(a.getKey());
            else
                return b.getValue().compareTo(a.getValue());
        });
        return entryList;
    }
}
