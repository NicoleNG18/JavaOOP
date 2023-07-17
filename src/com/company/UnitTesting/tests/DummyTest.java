package com.company.UnitTesting.tests;

import com.company.UnitTesting.Dummy;

public class DummyTest {

    private static final int START_HEALTH_DUMMY=100;
    private static final int START_EXPERIENCE_DUMMY=10;
    private static final int DEAD_DUMMY_HEALTH=0;
    private static final int ATTACK_POINTS=20;
    private static final int EXPECTED_HEALTH=80;
    private static final int EXPECTED_EXPERIENCE=10;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setup(){
        dummy=new Dummy(START_HEALTH_DUMMY,START_EXPERIENCE_DUMMY);
        deadDummy=new Dummy(DEAD_DUMMY_HEALTH,START_EXPERIENCE_DUMMY);
    }

    @Test
    public void testDummyLosesHealthIfAttacked() {
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(EXPECTED_HEALTH, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsAnExceptionIfAttacked() {
        deadDummy.takeAttack(20);
    }

    @Test
    public void testDeadDummyCanGiveXP() {
        deadDummy.giveExperience();
        Assert.assertEquals(EXPECTED_EXPERIENCE,deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCantGiveXP() {
        dummy.giveExperience();
    }

}
