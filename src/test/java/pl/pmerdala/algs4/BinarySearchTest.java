package pl.pmerdala.algs4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    BinarySearch binarySearch;

    @Before
    public void setUp() throws Exception {
        binarySearch = new BinarySearch();
    }

    @Test
    public void simplePositiveIndexOf(){
        int[] a = {1,2,3,4,5,6,7,8,9};
        assertEquals(5,binarySearch.indexOf(a,6));
        assertEquals(0,binarySearch.indexOf(a,1));
        assertEquals(8,binarySearch.indexOf(a,9));
        assertEquals(4,binarySearch.indexOf(a,5));
    }

    @Test
    public void simpleNegativeIndexOf(){
        int[] a = {1,2,3,4,6,7,8,9};
        assertEquals(-1,binarySearch.indexOf(a,5));
        assertEquals(-1,binarySearch.indexOf(a,0));
        assertEquals(-1,binarySearch.indexOf(a,10));
    }
}