package com.greatlearning.model;

/**
 * The stock operations performed by user
 *
 * @author manju
 *
 */
import java.util.Scanner;

import com.greatlearning.service.binarySearch;

public class StockOperations {
    private static Scanner sc = new Scanner(System.in);

    public static void display_menu() {
        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("Enter the operation that you want to perform: ");
        System.out.println("1. Display the companies stock prices in ascending order");
        System.out.println("2. Display the companies stock prices in descending order");
        System.out.println("3. Display the total no of companies for which stock prices rose today");
        System.out.println("4. Display the total no of comapnies for which stock prices declined today ");
        System.out.println("5. Search a specific stock price");
        System.out.println("6. Press 0 to exit");
        System.out.println("------------------------------------------------------------------------------");
    }

    public String StockOperations(double[] StockPrice, boolean[] RoseDec) {
        int StopLoop = 0;
        double keyStockPrice = 0;

        while (StopLoop == 0) {
            display_menu();
            Scanner choice = new Scanner(System.in);
            int Selection = choice.nextInt();
            switch (Selection) {
            case 0:
                System.out.println("Exited successfully !!!");
                StopLoop = 1;
                break;
            case 1:
                // 1. Display the companies stock prices in ascending order
                System.out.println("Companies stock prices in ascending order are : ");
                for (int i = StockPrice.length - 1; i >= 0; i--) {
                    System.out.print(" " + StockPrice[i]);
                }
                break;
            case 2:
                // 2. Display the companies stock prices in descending order
                System.out.println("Companies stock prices in descending order are : ");
                for (int i = 0; i < StockPrice.length; i++) {
                    System.out.print(" " + StockPrice[i]);
                }
                break;
            case 3:
                // 3. Display the total no of companies for which stock prices
                // rose today
                int countFlag = 0;
                for (int i = 0; i < RoseDec.length; i++) {
                    if (RoseDec[i] == true) {
                        countFlag++;
                    }
                }
                System.out.print(" --->  " + countFlag + " companies stock prices rose today");
                break;
            case 4:
                // 4. Display the total no of companies for which stock prices
                // declined today
                int countFlagFall = 0;
                for (int i = 0; i < RoseDec.length; i++) {
                    if (RoseDec[i] == false) {
                        countFlagFall++;
                    }
                }
                System.out.print(" --->  " + countFlagFall + " companies stock prices declined today");
                break;
            case 5:
                // 5. Search a specific stock price
                System.out.println("Enter the key value for search :  ");
                keyStockPrice = sc.nextDouble();

                // Since array is sorted we can loop till the end and check for
                // the given key price.
                boolean valueFound = false;
                for (int i = 0; i < StockPrice.length; i++) {
                    if (keyStockPrice == StockPrice[i]) {
                        System.out.println("--->  Stock value of " + keyStockPrice + " is present");
                        valueFound = true;
                    }
                }
                if (valueFound == false)
                    System.out.println("Value not present");

                // OR we can use binary search to find the key value

                System.out.println("\n<--- Binary Search --- >");
                binarySearch bs = new binarySearch();
                int n = StockPrice.length;

                int result = bs.binarySearch(StockPrice, 0, n - 1, keyStockPrice);
                if (result == -1)
                    System.out.println("Element not present");
                else
                    System.out.println("Element found at index " + result);

                break;
            default:
                System.err.println("Unrecognized option");
                break;
            }
        }
        return "=======================";
    }
}
