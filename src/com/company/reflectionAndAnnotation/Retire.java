package com.company.reflectionAndAnnotation;

import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command{

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    protected Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType =getData()[1];
        this.repository.removeUnit(unitType);
        return unitType + " retired!";
    }
}

