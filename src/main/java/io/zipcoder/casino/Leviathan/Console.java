package io.zipcoder.casino.Leviathan;

import java.util.Scanner;

public class Console {

    public void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput = scanner.nextLine();
        String userInput2 = userInput.toLowerCase();
        if (userInput2.equals("leave")) {
            System.out.print("You abandon your chips and sprint out of the casino.");
            System.exit(0);
        }
        return userInput2;
    }


    public Integer getIntInput(String prompt) {
        int b = 0;
        boolean good = false;
        println(prompt);
        while (good == false) {
            Scanner scannerB = new Scanner(System.in);
            if (scannerB.hasNextInt()) {
                b = scannerB.nextInt();
                good = true;
            } else {
                System.out.print("Invalid input please start over\n");
            }
        }
        return b;
    }

    public String yesOrNo(String prompt){
        boolean good = false;
        String correct= "";
        while(good == false){
        String answer = getStringInput(prompt);
        if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")){
            good = true;
            correct = answer;
        } else{
            println("what was that? Please say yes or no.");
        }
        }
        return correct;
    }


}
