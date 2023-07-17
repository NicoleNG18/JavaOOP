package com.company.UnitTesting.exercise;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Integer NUMBER_BEFORE_REMOVED_NUMBER = 12;
    private static final int ELEMENT_TO_ADD = 10;
    private static final Integer[] NUMBERS = {10, 12, 15};
    private static final int TOO_BIG_NUMBER = 17;

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorShouldCreateValidDatabase() {
        Integer[] dbElements = database.getElements();
        Assert.assertEquals("Count of db elements is incorrect", NUMBERS.length, dbElements.length);
        for (int i = 0; i < dbElements.length; i++) {
            Assert.assertEquals("We have different elements in the db", NUMBERS[i], dbElements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSetLessElements() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testWithAddingMoreElements() throws OperationNotSupportedException {
        Integer[] largerArr = new Integer[TOO_BIG_NUMBER];
        new Database(largerArr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddingNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testCountAfterAddingIntegerElement() throws OperationNotSupportedException {
        database.add(ELEMENT_TO_ADD);
        Integer[] dbElements= database.getElements();
        Assert.assertEquals(NUMBERS.length + 1, dbElements.length);
        Assert.assertEquals(Integer.valueOf(ELEMENT_TO_ADD),dbElements[dbElements.length-1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfThrowsExceptionWhileRemovingInEmptyDb() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testIfItRemovesAtLastIndex() throws OperationNotSupportedException {
        database.remove();
        Integer[] dbElements= database.getElements();
        Assert.assertEquals(NUMBERS.length-1,dbElements.length);
        Assert.assertEquals(NUMBER_BEFORE_REMOVED_NUMBER,dbElements[dbElements.length-1]);
    }

}
