package com.company.reflectionAndAnnotation.barakWars.core.commands;

import com.company.reflectionAndAnnotation.barakWars.core.annotations.Inject;
import com.company.reflectionAndAnnotation.barakWars.interfaces.Repository;
import com.company.reflectionAndAnnotation.barakWars.interfaces.Unit;
import com.company.reflectionAndAnnotation.barakWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command{

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    protected Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}

