package com.company.reflectionAndAnnotation;

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

