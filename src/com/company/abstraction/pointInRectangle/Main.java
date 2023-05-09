package com.company.abstraction.pointInRectangle;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int [] cordinates= getCordinates(scanner);

        Point A=new Point(cordinates[0],cordinates[1]);
        Point C=new Point(cordinates[2],cordinates[3]);

        Rectangle rec=new Rectangle(A,C);

        int n=Integer.parseInt(scanner.nextLine());

        while (n-->0){
            int [] input= getCordinates(scanner);

            Point X=new Point(input[0],input[1]);

            System.out.println(rec.contains(X));
        }

    }

    private static int[] getCordinates(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}

