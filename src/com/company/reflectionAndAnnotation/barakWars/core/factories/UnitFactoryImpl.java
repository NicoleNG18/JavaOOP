package com.company.reflectionAndAnnotation.barakWars.core.factories;

import com.company.reflectionAndAnnotation.barakWars.interfaces.Unit;
import com.company.reflectionAndAnnotation.barakWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    @SuppressWarnings("all")
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException,
            ClassNotFoundException,
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {

        Class<Unit> unitClass = (Class<Unit>) Class.forName(UNITS_PACKAGE_NAME + unitType);

        return createUnit(unitClass);

    }

    private Unit createUnit(Class<Unit> unitClass) throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        Constructor<Unit> unitConstructor= unitClass.getDeclaredConstructor();
        unitConstructor.setAccessible(true);

        return unitConstructor.newInstance();
    }
}

