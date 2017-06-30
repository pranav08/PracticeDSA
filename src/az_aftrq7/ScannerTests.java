package az_aftrq7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerTests {
static String area[]=new String [10];
static int pincode[]=new int [10];
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 2 areas and their pincodes");
        for (int i = 0; i <= 1; i++) {
            area[i] = s.next();// Use this for String Input
            pincode[i] = s.nextInt();
            s.nextLine();//Use this for going to next line of input
        }
        
         for (int i = 0; i <= 1; i++) {
             System.out.println("Area "+ area[i]+ " has pincode "+ pincode[i]);
        }
        
//////////////// NOW FROM FILE //////////////
         
        System.out.println("Storage from file path "+ System.getProperty("user.dir")+"\\ScannerTest.txt");
        s = new Scanner(new File(".\\ScannerTest.txt"));
         for (int i = 0; i <= 3; i++) {
            area[i] = s.next();// Use this for String Input
            pincode[i] = s.nextInt();
            if (i!=3) s.nextLine();//Use this for going to next line of input
            //i!=3 as we have only 3 carriage return in file. Please note: the file has 4 values (rows)
        }
        
         for (int i = 0; i <= 3; i++) {
             System.out.println("Area "+ area[i]+ " has pincode "+ pincode[i]);
        }
        
    }

}
