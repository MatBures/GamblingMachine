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

    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 1;
    private static final int NUMBER_OF_TIPS = 3;
    private static final int TOTAL_AMOUNT_OF_NUMBERS_IN_GAME = 50;

    public static void main(String[] args) {

        // Let user input his 3 numbers
        List<Integer> threeLotteryNumbers = getPlayerTips();
        System.out.println("Your lucky numbers are :" + threeLotteryNumbers);

        // Generate random numbers for the game
        List<Integer> listOfRandomGeneratedNumbers = generateRandomNumbersForGame();

        // Find out how many player tips were correct.
        listOfRandomGeneratedNumbers.retainAll(threeLotteryNumbers);
        System.out.println("Matched numbers in lottery are: " + listOfRandomGeneratedNumbers);

        //Print result for the player.
        printGameResult(listOfRandomGeneratedNumbers.size());
    }

    private static List<Integer> getPlayerTips() {
        List<Integer> threeLotteryNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, please enter three numbers from 1 - 100 range to try win lottery jackpot!");

        //While loop that scans your 3 inputted numbers from 1-100 and adding them to list of threeLotteryNumbers
        do {
            int lotteryNumber = scanner.nextInt();
            if (lotteryNumber > MAX_VALUE) {
                System.out.println("You inputted higher number than 100, try again.");

            } else if (lotteryNumber < MIN_VALUE) {
                System.out.println("You inputted lower number than 1, try again.");

            } else {
                threeLotteryNumbers.add(lotteryNumber);
            }
        } while (threeLotteryNumbers.size() < NUMBER_OF_TIPS);

        return threeLotteryNumbers;
    }

    private static List<Integer> generateRandomNumbersForGame() {
        Random random = new Random();
        List<Integer> listOfRandomGeneratedNumbers = new ArrayList<>();

        //While loop that generates 50 random numbers and adds them to listOfRandomGeneratedNumbers, every single number is unique (they cant repeat).
        do {
            int randomGeneratedNumber = random.nextInt(MAX_VALUE) + MIN_VALUE;
            boolean numberIsAlreadyInList = listOfRandomGeneratedNumbers.contains(randomGeneratedNumber);
            if (!numberIsAlreadyInList) {
                listOfRandomGeneratedNumbers.add(randomGeneratedNumber);
            }

        } while (listOfRandomGeneratedNumbers.size() < TOTAL_AMOUNT_OF_NUMBERS_IN_GAME);

        return listOfRandomGeneratedNumbers;
    }

    private static void printGameResult(int numberOfCorrectGuesses) {
        //Checking by Ifs the size of list to write correct system.out by matched numbers in lists.
        if (numberOfCorrectGuesses == 0) {
            System.out.println("Sorry you lost everything, try again!");
        }
        if (numberOfCorrectGuesses == 1) {
            System.out.println("Only 1 number was correct, try again!");
        }
        if (numberOfCorrectGuesses == 2) {
            System.out.println("2 numbers were correct, almost there, try again!");
        }
        if (numberOfCorrectGuesses == 3) {
            System.out.println("CONGRATULATIONS! YOU WON!");
        }
    }
}