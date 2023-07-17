package com.company.UnitTesting.lab.tests;

import com.company.UnitTesting.lab.Hero;
import com.company.UnitTesting.lab.Target;
import com.company.UnitTesting.lab.Weapon;

public class HeroTest {

    private static final int EXPERIENCE=10;

    @Test
    public void attackGainsXpIfTargetIsDead(){
        Weapon weapon= Mockito.mock(Weapon.class);
        Target target=Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(EXPERIENCE);

        Hero hero=new Hero("Pesho",weapon);
        hero.attack(target);
        Assert.assertEquals(hero.getExperience(),EXPERIENCE);

    }

}
