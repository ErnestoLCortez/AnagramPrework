package com.company;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CountryCode {

    private HashMap<String, String> countryDB;


    //Constructor takes data from CSV and reads it into HashMap
    public CountryCode(String filePath){
        countryDB = new HashMap<>();

        Scanner inFile;
        try {
            inFile = new Scanner(new FileReader(filePath));
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            return;
        }

        StringTokenizer temp;
        String countryCode, countryName;


        while(inFile.hasNextLine()){
            temp = new StringTokenizer(inFile.nextLine(), ",");
            countryName = temp.nextElement().toString();
            countryCode = temp.nextElement().toString().substring(5);

            countryDB.put(countryCode, countryName);
        }

    }
    //If length is 3, assume country code was entered, else it is country name
    public void countryCheck(String input) {
        if(input.length() == 3){
            getCountry(input);
        }
        else{
            getCode(input);
        }
    }

    //Check if code(key) is in the HashMap, if it is, return the name(value)
    public void getCountry(String code){
        if(countryDB.containsKey(code)){
            System.out.println(code + ": " + countryDB.get(code));
        }
        else {
            System.out.println("Country code not found!");
        }
    }


    //Check if country(value) is in the Hashmap, if it is, iterate over HashMap as Map.Entry and return code(key)
    public void getCode(String country) {
        if(countryDB.containsValue(country)) {
            for(Map.Entry<String,String> item : countryDB.entrySet()){
                if(item.getValue().equals(country)){
                    System.out.println(country + ":" + item.getKey());
                }
            }
        }
        else {
            System.out.println("Country name not found!");
        }
    }


}
