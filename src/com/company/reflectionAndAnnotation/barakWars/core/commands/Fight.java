package com.company.reflectionAndAnnotation.barakWars.core.commands;

import com.company.reflectionAndAnnotation.barakWars.core.annotations.Inject;
import com.company.reflectionAndAnnotation.barakWars.interfaces.Repository;
import com.company.reflectionAndAnnotation.barakWars.interfaces.UnitFactory;

public class Fight extends Command{

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    protected Fight(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}

