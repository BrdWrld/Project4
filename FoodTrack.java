/*
Cameron Williams
6/9/2020
INT-2200
Project 4
This program takes a customer's order at a food truck and prints their receipt.
Changes in this version:
Added discount for orders over $50
Created 2 new classes FoodTrack and FoodDiscount
*/
package com.cameronwilliams;

import java.util.Scanner;

public class FoodTrack {
    //Defining constants
    final static float[] PRICES = { 4.99F, 14.99F, .99F, 3.99F, 2.99F};
    final static float SALESTAX = .06F;
    //Defining variables
    static byte[] numItems = new byte[5];
    static float[] costItems = new float[5];
    //Main function
    public static void main(String[] args) {
        //Inputs from the user
        numItems[0] = getOrder("hamburgers", PRICES[0]);
        numItems[1] = getOrder("pizzas", PRICES[1]);
        numItems[2] = getOrder("french fries", PRICES[2]);
        numItems[3] = getOrder("slices of apple pie", PRICES[3]);
        numItems[4] = getOrder("deep fried twinkies", PRICES[4]);
        //Cost for Items
        costItems[0] = calculateCost(PRICES[0], FoodTrack.numItems[0]);
        costItems[1] = calculateCost(PRICES[1], FoodTrack.numItems[1]);
        costItems[2] = calculateCost(PRICES[2], FoodTrack.numItems[2]);
        costItems[3] = calculateCost(PRICES[3], FoodTrack.numItems[3]);
        costItems[4] = calculateCost(PRICES[4], FoodTrack.numItems[4]);
        //Subtotal math
        float subTotal = costItems[0] + costItems[1] + costItems[2] + costItems[3] + costItems[4];
        //Calling method for discount
        FoodDiscount.setDiscount(subTotal);
        //Outputs the total and gets tender input
        float tender = getTender(FoodDiscount.total);
        //Change calculation
        float change = tender - FoodDiscount.total;
        //Calling the print function
        printReceipt(FoodDiscount.discountedSubtotal, FoodDiscount.discountAmount, FoodDiscount.tax, FoodDiscount.total, tender, change);
    }
    //Function to ask customer for the number of each item they want.
    public static byte getOrder(String name, float pricesY) {
        //Preparing for input
        Scanner sc = new Scanner(System.in);
        System.out.println("How many " + name + " would you like? (each at: $" + pricesY + ")");
        return sc.nextByte();
    }
    //Multiplication function for number of items ordered and price per item
    public static float calculateCost(float pricesX, byte numY) {
        return pricesX * numY;
    }
    //Function to get customer's money and check if it is enough
    public static float getTender(float total) {
        //Preparing for input
        Scanner sc = new Scanner(System.in);
        System.out.println("How much will you be paying? The total is : $" + total);
        float tender = sc.nextFloat();
        //Loop to ensure enough money is paid
        while(total > tender) {
            System.out.println("Sorry, the total is: $" + total + ". How much will you be paying?");
            tender = sc.nextFloat();
        }
        //Returning tender to main method after enough has been paid
        return tender;
    }
    //Function to print the receipt
    public static void printReceipt(float discountedSubtotal, float discountAmount, float tax, float total, float tender, float change) {
        System.out.println("\t\t\t\t    KKona");
        System.out.println("\t\t\t\t  123 Fake St");
        System.out.println("\t\t\t\tYork, PA 17402");
        System.out.println("\t\t\t\t 555-555-5555\n");
        System.out.println(numItems[0] + " Hamburger each \t\t\t$" + PRICES[0] + " \t$" + costItems[0]);
        System.out.println(numItems[1] + " Pizza each \t\t\t\t$" + PRICES[1] + " \t$" + costItems[1]);
        System.out.println(numItems[2] + " French Fries each \t\t$" + PRICES[2] + " \t$" + costItems[2]);
        System.out.println(numItems[3] + " Slice of apple pie each \t$" + PRICES[3] + " \t$" + costItems[3]);
        System.out.println(numItems[4] + " Deep fried twinkie each \t$" + PRICES[4] + " \t$" + costItems[4]);
        System.out.println("\nSubtotal\t\t\t\t\t\t\t$" + discountedSubtotal);
        System.out.println("KKona offers a 10% discount on orders over $50");
        System.out.println("Discount\t\t\t\t\t\t\t$" +discountAmount);
        System.out.println("MD Sales Tax\t\t\t\t\t\t$" + tax);
        System.out.println("Total\t\t\t\t\t\t\t\t$" + total);
        System.out.println("Tender\t\t\t\t\t\t\t\t$" + tender);
        System.out.println("Change\t\t\t\t\t\t\t\t$" + change);
        System.out.println("\t\t\tThanks! Come again!");
    }
}

