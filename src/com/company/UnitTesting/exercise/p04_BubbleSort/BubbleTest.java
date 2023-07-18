package com.company.UnitTesting.exercise.p04_BubbleSort;

public class BubbleTest {

    private static final int[] SORTED_ARRAY=new int[]{2,3,4,5};

    @Test
    public void testBubbleSort(){
        int [] numbers=new int[]{4,2,3,5};
        Bubble.sort(numbers);
        Assert.assertArrayEquals(SORTED_ARRAY,numbers);
    }
}
