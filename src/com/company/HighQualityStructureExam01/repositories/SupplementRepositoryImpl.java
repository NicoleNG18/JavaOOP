package com.company.HighQualityStructureExam01.repositories;

import java.util.ArrayList;

public class SupplementRepositoryImpl implements SupplementRepository {
    private Collection<Supplement> supplements;

    public SupplementRepositoryImpl() {
        this.supplements = new ArrayList<>();
    }

    @Override
    public void add(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public boolean remove(Supplement supplement) {
        return supplements.remove(supplement);
    }

    @Override
    public Supplement findByType(String type) {
        return supplements.stream().filter(e->e.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}

