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
}