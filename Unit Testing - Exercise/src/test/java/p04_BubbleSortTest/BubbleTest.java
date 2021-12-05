package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleTest {
    private static final int[] NUMS = {5, 47, 69, 58, 69, 71, 56,-1};
    private static final int[] SORTED_NUMS = {-1,5, 47, 56, 58, 69, 69, 71};

    @Test
    public void testSortedCorrectlyNumsOfAlgorithm() {
        Bubble.sort(NUMS);
        Assert.assertArrayEquals(NUMS, SORTED_NUMS);
    }
    @Test
    public void testUntouchedSortedCollectionAfterSortAlgorithm(){
        int[] beforeSort = Arrays.copyOf(SORTED_NUMS,8);
        Bubble.sort(beforeSort);
        Assert.assertArrayEquals(SORTED_NUMS,beforeSort);
    }
}