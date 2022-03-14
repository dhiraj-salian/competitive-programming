package com.dhirajsalian.cp.dsa;

import org.junit.Assert;
import org.junit.Test;

public class DataStructureTest {

    @Test
    public void disjointSetTest() {
        Integer[] elements = {1, 2, 3, 4, 5};
        DisjointSet<Integer> dus = new DisjointSet<>(elements);
        Assert.assertNotEquals(dus.find(1), dus.find(2));
        dus.union(1, 2);
        Assert.assertEquals(dus.find(1), dus.find(2));
    }
}
