package com.company.reflectionAndAnnotation;

public class Report extends Command{

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    protected Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
