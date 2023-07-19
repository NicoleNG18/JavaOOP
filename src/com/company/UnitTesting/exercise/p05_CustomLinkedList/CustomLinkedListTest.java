package com.company.UnitTesting.exercise.p05_CustomLinkedList;

public class CustomLinkedListTest {

    private static final Integer ELEMENT_TO_ADD = 5;
    private static final Integer ELEMENT_TO_ADD2 = 3;
    private static final Integer ELEMENT_TO_ADD3 = 4;
    private static final int INVALID_INDEX = -1;
    private static final Integer NON_EXISTING_ELEMENT=7;
    private static final int INDEX=1;


    CustomLinkedList<Integer> customLinkedList;
//add

    @Before
    public void setUp() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(ELEMENT_TO_ADD);
        customLinkedList.add(ELEMENT_TO_ADD2);
        customLinkedList.add(ELEMENT_TO_ADD3);
    }

    @Test
    public void testConstructor() {
        customLinkedList = new CustomLinkedList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGettingWithInvalidIndex() {
        customLinkedList.get(INVALID_INDEX);
    }

    @Test
    public void testGettingWithValidIndex() {
        Integer element = customLinkedList.get(INDEX);
        Assert.assertEquals(ELEMENT_TO_ADD2, element);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSettingWithInvalidIndex() {
        customLinkedList.set(INVALID_INDEX, ELEMENT_TO_ADD);
    }

    @Test
    public void testSettingWithValidIndex() {
        customLinkedList.set(1, ELEMENT_TO_ADD3);
        Assert.assertEquals(ELEMENT_TO_ADD3, customLinkedList.get(INDEX));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removingAtInvalidIndex() {
        customLinkedList.removeAt(INVALID_INDEX);
    }

    @Test
    public void testRemovingAtValidIndex() {
        Integer element = customLinkedList.removeAt(INDEX);
        Assert.assertEquals(ELEMENT_TO_ADD2, element);
    }

    @Test
    public void testRemovingWithExistingElement(){
        int index=customLinkedList.remove(ELEMENT_TO_ADD2);
        Assert.assertEquals(INDEX,index);
    }

    @Test
    public void testWithNonExistingElement(){
        int index=customLinkedList.remove(NON_EXISTING_ELEMENT);
        Assert.assertEquals(INVALID_INDEX,index);
    }

    @Test
    public void testIndexOfExistingElement(){
        int index=customLinkedList.indexOf(ELEMENT_TO_ADD2);
        Assert.assertEquals(INDEX,index);
    }

    @Test
    public void testIndexOfNonExistingElement(){
        int index=customLinkedList.indexOf(NON_EXISTING_ELEMENT);
        Assert.assertEquals(INVALID_INDEX,index);
    }

    @Test
    public void testContainsWithExistingElement(){
        Assert.assertTrue(customLinkedList.contains(ELEMENT_TO_ADD2));
    }

    @Test
    public void testContainsWithNonExistingElement(){
        Assert.assertFalse(customLinkedList.contains(NON_EXISTING_ELEMENT));
    }


}
