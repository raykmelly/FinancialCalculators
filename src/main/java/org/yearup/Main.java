package org.yearup;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Main function, holds other functions and collects user input
        Scanner userInput = new Scanner(System.in);

        //-----------------------------------------------------------
        // Question #1 [Mortgage Calculator]

        double principal;
        double interestRate;
        double loanLength;

        System.out.print("Enter your loan principal: ");
        principal = userInput.nextDouble();
        System.out.print("Enter your interest rate: ");
        interestRate = userInput.nextDouble();
        System.out.print("Enter your loan length (in years): ");
        loanLength = userInput.nextDouble();

        MortgageCalc(principal,interestRate,loanLength);

        //-----------------------------------------------------------
        // Question #2 [Futures Calculator (CD)]

        double deposit;
        double interestRate2;
        double loanLength2;

        System.out.print("Enter your deposit: ");
        deposit = userInput.nextDouble();
        System.out.print("Enter your interest rate: ");
        interestRate2 = userInput.nextDouble();
        System.out.print("Enter length of pay period (in years): ");
        loanLength2 = userInput.nextDouble();

        FutureCalc(deposit,interestRate2,loanLength2);
    }

    public static void MortgageCalc(double principal, double interestRate, double loanLength) {
        // Calculate monthly mortgage

        // Change the interest rate into a percentage
        interestRate = (interestRate / 100) / 12;
        // Change loan length into months
        loanLength = loanLength * 12;

        // Formula is M = P * (i*(1 + i)^n)/((1 + i)^n -1)
        double numerator = interestRate * (Math.pow((1 + interestRate), loanLength));
        double denominator = Math.pow((1 + interestRate),loanLength) - 1;
        double monthlyRate = principal * (numerator / denominator);

        System.out.printf("Your monthly interest rate is: $%f\n",monthlyRate);
    }

    public static void FutureCalc(double deposit, double interestRate, double loanLength) {
        // Calculate future value (CD)
        interestRate = interestRate / 100;

        double futureValue = deposit * (Math.pow((1 + interestRate),loanLength));

        System.out.printf("Your future value is: $%f\n",futureValue);
    }
}