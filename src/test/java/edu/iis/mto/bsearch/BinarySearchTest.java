package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Agata on 2017-03-14.
 */
public class BinarySearchTest {
    int element = 1000;
    int seq[];
    SearchResult searchResult;

    @Test
    public void elementInSequence() throws Exception {
        seq = new int[] {element};
        searchResult = BinarySearch.search(element, seq);
        assertThat(searchResult.isFound(), is (true));
    }
}