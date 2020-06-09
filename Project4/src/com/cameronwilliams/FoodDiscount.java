package com.cameronwilliams;

public class FoodDiscount extends FoodTrack{
    //Defining class variables
    static float total;
    static float discountAmount;
    static float discountedSubtotal;
    static float tax;
    //Discount functions.
    public static void setDiscount(float subTotal) {
        float discount;
        if (subTotal >= 50) {
            discount = .1F;
        }
        else discount = 0;
        //Rest of discount cost calculations
        discountAmount = subTotal * discount;
        discountedSubtotal = subTotal - discountAmount;
        tax = discountedSubtotal * SALESTAX;
        total = discountedSubtotal + tax;
    }
}
