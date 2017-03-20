package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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

    @Test
    public void elementNotInSequence() throws Exception {
        seq = new int[] {element - 1};
        searchResult = BinarySearch.search(element, seq);
        assertThat(searchResult.isFound(), is (false));
    }

    @Test
    public void elementIsFirstInSequence() throws Exception {
        seq = new int[] {element, element + 666, element + 1234};
        searchResult = BinarySearch.search(element, seq);
        assertThat(searchResult.isFound(), is (true));
        assertThat(searchResult.getPosition(), is (0));
    }

    @Test
    public void elementIsLastInSequence() throws Exception {
        seq = new int[] {element - 666, element -456 , element};
        searchResult = BinarySearch.search(element, seq);
        assertThat(searchResult.isFound(), is (true));
        assertThat(searchResult.getPosition(), is (seq.length - 1));
    }

    @Test
    public void elementIsInCentreOfSequence() throws Exception {
        seq = new int[] {element - 666, element, element + 1234};
        searchResult = BinarySearch.search(element, seq);
        assertThat(searchResult.isFound(), is (true));
        assertThat(searchResult.getPosition(), is ((seq.length - 1)/2));
    }

    @Test
    public void elementIsNotInSequence() throws Exception {
        seq = new int[] {element + 69, element + 666, element + 1234};
        searchResult = BinarySearch.search(element, seq);
        assertThat(searchResult.isFound(), is (false));
    }

    @Test (expected = IllegalArgumentException.class)
    public void exceptionWhenSequenceIsEmpty() throws Exception {
        BinarySearch.search(5, new int[0]);
    }

    @Test
    public void elementIsInThCentre() throws Exception {
        seq = new int[]{element - 3, element - 2, element - 1, element, element + 1, element + 2, element + 3};
        searchResult = BinarySearch.search(element, seq);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is (3));
    }

    @Test
    public void elementIsInTheCentrePlus() throws Exception {
        seq = new int[]{element - 6, element - 2, element - 1, element, element + 9};
        searchResult = BinarySearch.search(element, seq);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is (3));
    }

    @Test
    public void elementIsInTheCentreMinus() throws Exception {
        seq = new int[]{element - 6, element, element + 1, element +69, element + 1234};
        searchResult = BinarySearch.search(element, seq);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is (1));
    }
}