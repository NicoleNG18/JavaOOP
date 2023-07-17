package com.company.UnitTesting.exercise.p02_ExtendedDatabase;

public class PersonTest {

    private static final String NAME = "Gosho";
    private static final int ID=12356;

    Person person;

    @Test
    public void testIfTheConstructorCreatesPersonCorrectly() {
        person = new Person(ID,NAME);
        Assert.assertEquals(NAME,person.getUsername());
        Assert.assertEquals(ID,person.getId());
    }

}
