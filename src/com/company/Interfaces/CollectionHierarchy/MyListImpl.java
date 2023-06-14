package com.company.Interfaces.CollectionHierarchy;

public class MyListImpl extends Collection implements MyList{

    @Override
    public String remove() {
        String elementToRemove= items.remove(0);
        return elementToRemove;
    }

    @Override
    public int add(String element) {
        items.add(0,element);
        return 0;
    }

    @Override
    public int getUsed() {
        return items.size();
    }

}

