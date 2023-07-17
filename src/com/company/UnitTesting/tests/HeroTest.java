package com.company.UnitTesting.tests;

import com.company.UnitTesting.Hero;
import com.company.UnitTesting.Target;
import com.company.UnitTesting.Weapon;

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
