package com.company.UnitTesting.exercise.p03_ListIterator;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private static final String FIRST_ELEMENT = "pepi";
    private static final String SECOND_ELEMENT = "pesho";
    private static final String THIRD_ELEMENT = "pepkata";
    private static final String FOURTH_ELEMENT = "petran";
    private static final String[] NULL = null;
    private static final String[] ELEMENTS = new String[]{FIRST_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT, FOURTH_ELEMENT};
    private static final String[] ONE_ELEMENT_ARRAY = new String[]{FIRST_ELEMENT};
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testWithNullNameShouldThrowExc() throws OperationNotSupportedException {
        new ListIterator(NULL);
    }

    @Test
    public void testConstructorShouldCreateListIterator() throws OperationNotSupportedException {
        new ListIterator(ELEMENTS);
    }

    @Test
    public void testIfHasNextWorksCorrectly() {
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNextShouldReturnFalseWithOneElement() throws OperationNotSupportedException {
        listIterator = new ListIterator(ONE_ELEMENT_ARRAY);
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMovingWithEnoughElements() {
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void testMoveShouldReturnFalseWithOneElement() throws OperationNotSupportedException {
        listIterator = new ListIterator(ONE_ELEMENT_ARRAY);
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintWithZeroElements() throws OperationNotSupportedException {
        listIterator=new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrint(){
        String result= listIterator.print();
        Assert.assertEquals(FIRST_ELEMENT,result);
    }

}
