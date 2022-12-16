package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*Gambling game machine,
You can try to "play the game". Run the program and program will tell you everything you need to know for playing :)
Good Luck! (sadly you cant win anything :D, but it works!)
 */

public class GamblingMachine {

    //Setting variables, imports and lists.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lotteryNumber;
        List<Integer> threeLotteryNumbers = new ArrayList<Integer>();
        List<Integer> listOfRandomGeneratedNumbers = new ArrayList<Integer>();
        int max = 100;

        System.out.print("Hello, please enter three numbers from 1 - 100 range to try win lottery jackpot!");

        //While loop that scans your 3 inputted numbers from 1-100 and adding them to list of threeLotteryNumbers
        do {
            lotteryNumber = scanner.nextInt();
            if (lotteryNumber > 100) {
                System.out.println("You inputted higher number than 100, try again.");

            } else if (lotteryNumber < 1) {
                System.out.println("You inputted lower number than 1, try again.");

            } else {
                threeLotteryNumbers.add(lotteryNumber);
            }
        } while (threeLotteryNumbers.size() < 3);
        //When the Three lottery number's size is 3, there is a message and the program continues
        if (threeLotteryNumbers.size() == 3) {
            System.out.println("Your lucky numbers are :" + threeLotteryNumbers);

            //While loop that generates 50 random numbers and adds them to listOfRandomGeneratedNumbers, every single number is unique (they cant repeat).
            do {
                int randomGeneratedNumber = random.nextInt(max) + 1;
                boolean sameNumberSearch = listOfRandomGeneratedNumbers.contains(randomGeneratedNumber);
                if (sameNumberSearch) {

                } else {
                    listOfRandomGeneratedNumbers.add(randomGeneratedNumber);
                }

            } while (listOfRandomGeneratedNumbers.size() < 50);

            //Special command retainAll is matching the numbers of randoms and user's inputted numbers to one list = listOfRandomGeneratedNumbers
            listOfRandomGeneratedNumbers.retainAll(threeLotteryNumbers);
            System.out.println("Matched numbers in lottery are: " + listOfRandomGeneratedNumbers);
        }

        //Checking by Ifs the size of list to write correct system.out by matched numbers in lists.
        if(listOfRandomGeneratedNumbers.size() == 0)
        {
            System.out.println("Sorry you lost everything, try again!");
        }
        if (listOfRandomGeneratedNumbers.size()==1) {
            System.out.println("Only 1 number was correct, try again!");
        }
        if (listOfRandomGeneratedNumbers.size()==2) {
            System.out.println("2 numbers were correct, almost there, try again!");
        }
        if (listOfRandomGeneratedNumbers.size()==3) {
            System.out.println("CONGRATULATIONS! YOU WON!");
        }
    }
}