package com.company.UnitTesting.exercise.p02_ExtendedDatabase;

import javax.naming.OperationNotSupportedException;

public class DatabaseExtendedTest {

    private static final Person P1=new Person(12,"Pep");
    private static final Person P2=new Person(11,"Pepi");
    private static final Person P3=new Person(13,"Pepkata");
    private static final Person P4=new Person(14,"Pesho");
    private static final Person[] ELEMENTS={P1,P2,P4};
    private static final Person[] ELEMENTS_AFTER_REMOVING={P1,P2};
    private static final Person[] LONGER_ARRAY=new Person[17];

    Database database;
    Person person;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database=new Database(ELEMENTS);
    }

    @Test
    public void testIfTheConstructorAddsCorrectly(){
        Person[] people= database.getElements();
        Assert.assertArrayEquals(ELEMENTS,people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testWithMoreElements() throws OperationNotSupportedException {
        new Database(LONGER_ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testWithZeroElements() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddingWithNullElementShouldThrowExc() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testIfAddingPersonIsCorrect() throws OperationNotSupportedException {
        database.add(P3);
        Person[] people=database.getElements();
        Assert.assertEquals(P3,people[people.length-1]);
        Assert.assertEquals(ELEMENTS.length+1,people.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemovingFromEmptyDb() throws OperationNotSupportedException {
        for (int i = 0; i < ELEMENTS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemovingAnElementFromDb() throws OperationNotSupportedException {
        database.remove();
        Person[] people=database.getElements();
        Assert.assertArrayEquals(ELEMENTS_AFTER_REMOVING,people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testWithNullUsername() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testWithMissingUsername() throws OperationNotSupportedException {
        database.findByUsername("petur");
    }

    @Test
    public void testWithPresentUsername() throws OperationNotSupportedException {
        person=database.findByUsername("Pepi");
        Assert.assertEquals(P2,person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testWithMissingId() throws OperationNotSupportedException {
        database.findById(9);
    }

    @Test
    public void testWithPresentId() throws OperationNotSupportedException {
        person=database.findById(12);
        Assert.assertEquals(P1,person);
    }

}
