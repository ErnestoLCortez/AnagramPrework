package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CountryCode a = new CountryCode("D:\\CountryCodes.csv");
        System.out.println("Enter code or country:");
        Scanner userInput = new Scanner(System.in);


        a.countryCheck(userInput.nextLine());
    }
}
