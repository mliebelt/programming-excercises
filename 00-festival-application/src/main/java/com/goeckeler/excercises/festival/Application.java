package com.goeckeler.excercises.festival;

import com.goeckeler.excercises.festival.reader.ExcelReader;

import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) {
        System.out.println("Revival Festival");

        ExcelReader reader = new ExcelReader();
        try {
            System.out.println("-----------------------------------------------------------");
            System.out.println("BANDS");
            System.out.println("-----------------------------------------------------------");

            reader.read("Festival.xlsx", "bands");

            System.out.println("-----------------------------------------------------------");
            System.out.println("PLAYLIST");
            System.out.println("-----------------------------------------------------------");
            reader.read("Festival.xlsx", "playlist");

        } catch (FileNotFoundException ex) {
            System.err.println("Cannot find festival file.");
        }
    }
}
