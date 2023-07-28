package com.company.UnitTestingExam;

import java.util.ArrayList;
import java.util.Collection;

public class FootballTeamTests {
    private FootballTeam footballTeam;
    private Collection<Footballer> footballers;
    private static final Footballer FOOTBALLER_IVAN=new Footballer("Ivan");
    private static final Footballer FOOTBALLER_PESHO=new Footballer("Pesho");
    private static final Footballer FOOTBALLER_KOSIO=new Footballer("Kosio");
    private static final Footballer INVALID_FOOTBALLER=new Footballer("Marin");
    private static final int VACANT_POS=3;
    private static final int INVALID_VACANT=-5;
    private static final String TEAM_NAME="Levski";


    @Before
    public void setUp(){
        footballTeam=new FootballTeam(TEAM_NAME,VACANT_POS);
        footballers=new ArrayList<>();
    }

    @Test
    public void testIsActive(){
        Assert.assertTrue(FOOTBALLER_IVAN.isActive());
    }

    @Test
    public void testGetAndSetNameWithProperValues(){
        Assert.assertEquals(TEAM_NAME,footballTeam.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testFootballTeamWithInvalidName(){
        footballTeam=new FootballTeam(null,VACANT_POS);
    }

    @Test(expected = NullPointerException.class)
    public void testFootballTeamWithWhiteSpaceName(){
        footballTeam=new FootballTeam(" ",VACANT_POS);
    }

    @Test
    public void testGetVacantPositionsWithProperValues(){
        Assert.assertEquals(VACANT_POS,footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballTeamWithInvalidVacant(){
        footballTeam=new FootballTeam(TEAM_NAME,INVALID_VACANT);
    }

    @Test
    public void testCountAndAddMethods(){
        Assert.assertEquals(0,footballTeam.getCount());
        footballTeam.addFootballer(FOOTBALLER_IVAN);
        Assert.assertEquals(1,footballTeam.getCount());
        footballTeam.addFootballer(FOOTBALLER_PESHO);
        Assert.assertEquals(2,footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingMore(){
        footballTeam.addFootballer(FOOTBALLER_IVAN);
        footballTeam.addFootballer(FOOTBALLER_PESHO);
        footballTeam.addFootballer(FOOTBALLER_KOSIO);
        footballTeam.addFootballer(INVALID_FOOTBALLER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWithInvalidF(){
        footballTeam.addFootballer(FOOTBALLER_IVAN);
        footballTeam.addFootballer(FOOTBALLER_PESHO);
        footballTeam.addFootballer(FOOTBALLER_KOSIO);
        footballTeam.removeFootballer("Marin");
    }

    @Test
    public void testRemoveWithValidF(){
        footballers=new ArrayList<>();
        footballTeam.addFootballer(FOOTBALLER_IVAN);
        footballTeam.addFootballer(FOOTBALLER_PESHO);
        footballTeam.addFootballer(FOOTBALLER_KOSIO);
        footballers.add(FOOTBALLER_IVAN);
        footballers.add(FOOTBALLER_KOSIO);
        footballTeam.removeFootballer("Pesho");
        Assert.assertEquals(footballers.size(),footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleWithInvalidF(){
        footballTeam.addFootballer(FOOTBALLER_IVAN);
        footballTeam.addFootballer(FOOTBALLER_PESHO);
        footballTeam.addFootballer(FOOTBALLER_KOSIO);
        footballTeam.footballerForSale("Marin");
    }

    @Test
    public void testForSaleWithValidF(){
        footballTeam.addFootballer(FOOTBALLER_IVAN);
        footballTeam.addFootballer(FOOTBALLER_PESHO);
//        Footballer ex=FOOTBALLER_PESHO;
//        ex.setActive(false);
        Footballer act=footballTeam.footballerForSale("Pesho");
        Assert.assertFalse(act.isActive());
    }

    @Test
    public void testGetStatistics(){
        footballTeam.addFootballer(FOOTBALLER_IVAN);
        footballTeam.addFootballer(FOOTBALLER_PESHO);
        String expected="The footballer Ivan, Pesho is in the team Levski.";
        String actual=footballTeam.getStatistics();
        Assert.assertEquals(expected,actual);
    }

}

