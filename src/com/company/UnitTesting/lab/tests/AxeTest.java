package com.company.UnitTesting.lab.tests;


import com.company.UnitTesting.lab.Axe;
import com.company.UnitTesting.lab.Dummy;

public class AxeTest {

    private static final int START_ATTACK_AXE=15;
    private static final int START_DURABILITY_AXE=25;
    private static final int START_BROKEN_DURABILITY_AXE=0;
    private static final int START_HEALTH_DUMMY=10;
    private static final int START_EXPERIENCE_DUMMY=10;
    private static final int EXPECTED_ATTACK_POINTS =24;

    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void setup() {
        axe=new Axe(START_ATTACK_AXE,START_DURABILITY_AXE);
        brokenAxe=new Axe(START_ATTACK_AXE,START_BROKEN_DURABILITY_AXE);
        dummy=new Dummy(START_HEALTH_DUMMY,START_EXPERIENCE_DUMMY);
    }

    @Test
    public void testIfWeaponLosesDurabilityAfterEachAttack() {
        axe.attack(dummy);
        Assert.assertEquals(EXPECTED_ATTACK_POINTS, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithABrokenWeapon() {
        brokenAxe.attack(dummy);

    }

}
