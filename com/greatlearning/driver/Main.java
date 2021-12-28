package com.greatlearning.driver;

import java.util.Scanner;

import com.greatlearning.model.StockOperations;
import com.greatlearning.service.MergeSortImplementation;

/**
 * Stockers application for storing records of N companies Share price , and
 * raise or fall of price today are the details stored. Based on the details
 * entered the StockOperations will be performed.
 * 
 * @author manju
 *
 */
public class Main {

    public static void main(String[] args) {
        // objects for classes
        Scanner sc = new Scanner(System.in);
        MergeSortImplementation mergeSortImplementation = new MergeSortImplementation();
        StockOperations so = new StockOperations();

        // Ask user to Enter number of companies
        System.out.println("Enter the number of companies : ");
        int size = sc.nextInt();

        boolean roseOrNot[] = new boolean[size];
        double companyStockPrice[] = new double[size];
        double keyStockPrice = 0;

        // ask user to enter the details of the companies
        for (int k = 0; k < size; k++) {
            System.out.println("Enter the current stock price of the company " + (k + 1) + ": ");
            companyStockPrice[k] = sc.nextDouble();

            System.out.println("Whether the company's stock price rose today compare to yesterday ? ");
            roseOrNot[k] = sc.nextBoolean();
        }

        // Sort the price array
        mergeSortImplementation.sort(companyStockPrice, 0, companyStockPrice.length - 1);

        // perform operations
        System.out.println(so.StockOperations(companyStockPrice, roseOrNot));
    }

}
