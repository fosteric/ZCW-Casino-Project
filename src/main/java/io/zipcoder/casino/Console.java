package io.zipcoder.casino;
import java.util.Scanner;

public class Console {

    public  void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public  void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public  String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput = scanner.nextLine();
        String userInput2 = userInput.toLowerCase();
        return userInput2;
    }

    /*public static Integer getIntegerInput(String prompt) {
    return null;
    }*/

    public  Integer getIntInput(String prompt) {
        Scanner scannerB = new Scanner(System.in);
        int b = 0;
        println(prompt);
        if(scannerB.hasNextInt()){
            b = scannerB.nextInt();
        }else{
            System.out.print("Invalid input please start over\n");
        }
        return b;
    }



}
