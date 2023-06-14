package com.company.Interfaces.CollectionHierarchy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection=new AddCollection();
        AddRemoveCollection addRemoveCollection=new AddRemoveCollection();
        MyListImpl myList=new MyListImpl();

        String [] inputStrings= scanner.nextLine().split("\\s+");
        int removedOp=Integer.parseInt(scanner.nextLine());

        printAdd(inputStrings,addCollection);
        printAdd(inputStrings,addRemoveCollection);
        printAdd(inputStrings,myList);

        printRemove(addRemoveCollection, removedOp);
        printRemove(myList,removedOp);

    }

    private static void printRemove(AddRemovable collection, int removedOp) {
        for (int i = 0; i < removedOp; i++) {
            System.out.print(collection.remove()+" ");
        }
        System.out.println();
    }

    private static void printAdd(String[] inputStrings, Addable collection) {
        Arrays.stream(inputStrings).forEach(e->System.out.print(collection.add(e) + " "));
        System.out.println();
    }
}

