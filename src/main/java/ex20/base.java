/*
 *  UCF COP3330 Summer 2021 Assignment 20 Solution
 *  Copyright 2021 Julian Espinoza
 *
 *  Exercise 20 - Multistate Sales Tax Calculator
 *  Create a tax calculator that handles multiple states and multiple counties within each state.
 *  The program prompts the user for the order amount and the state where the order will be shipped.
 *
 *  Constraint:
 *  Ensure that all money is rounded up to the nearest cent.
 *  Use a single output statement at the end of the program to display the program results.
*
 */

package ex20;
import java.util.Scanner;

public class base {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args)
    {
        // Initialization of variables
        base myBase = new base();
        String state, county;
        double order;

        order = myBase.order();
        state = myBase.state();

        // If statement determines if county function is run
        if(state.equals("Wisconsin"))
        {
            county = myBase.county();
        }
        else
        {
            county = "No";
        }

        myBase.taxCheck(order, state, county);
    }

    // Function returns order amount
    public double order()
    {
        double order;
        System.out.printf("What is the order amount? ");
        order = userInput.nextDouble();
        return order;
    }

    // Function returns state
    public String state()
    {
        String state;
        System.out.printf("What is the state? ");
        state = userInput.next();
        return state;
    }

    // Function returns county
    public String county()
    {
        String state;
        System.out.printf("What county do you live in? ");
        state = userInput.next();
        return state;
    }

    // Function calculates and outputs the total
    public void taxCheck(double order, String state, String county)
    {
        double tax, addedTax, total;

        // Determines tax based on state
        if(state.equals("Wisconsin")) {
            tax = 0.05;
            // Adds county specific tax
            if(county.equals("Eau Claire"))
            {
                tax += 0.005;
            }
            else if(county.equals("Dunn"))
            {
                tax += 0.004;
            }
            addedTax = tax * order;
        }
        else if(state.equals("Illinois"))
        {
            tax = 0.08;
            addedTax = tax * order;
        }
        else {
            addedTax = 0;
        }

        // Final calculations
        total = order + addedTax;

        // Single statement output
        System.out.printf("The subtotal is $%.2f.%nThe tax is $%.2f.%nThe total is $%.2f.", order, addedTax, total);
    }
}
