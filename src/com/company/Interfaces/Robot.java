package com.company.Interfaces;

public class Robot implements Identifiable{
    private String id;
    private String model;

    protected Robot(String id, String model) {
        setId(id);
        setModel(model);
    }

    @Override
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

