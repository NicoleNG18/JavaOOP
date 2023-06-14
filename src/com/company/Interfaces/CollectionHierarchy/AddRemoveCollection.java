package com.company.Interfaces.CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable{

    @Override
    public String remove() {
        String element=items.remove(items.size()-1);
        return element;
    }

    @Override
    public int add(String element) {
        items.add(0,element);
        return 0;
    }

}

