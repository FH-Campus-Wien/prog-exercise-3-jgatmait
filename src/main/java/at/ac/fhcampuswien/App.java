package at.ac.fhcampuswien;

import java.util. Arrays;
import java.util.Random;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        System.out.println("Task 1: One Month Calendar");
        oneMonthCalendar(30, 7);

        System.out.println("Task 2: Pseudo Random Number");
        System.out.println(Arrays.toString(lcg(767394028472930L)));
        System.out.println();

        System.out.println("Task 3: Guessing Game");
        guessingGame(randomNumberBetweenOneAndHundred());

        System.out.println("Task 4: Swap Arrays");
        int[] myarray1 ={1,2,3,4,5};
        int[] myarray2={6,7,8,9,0};
        swapArrays(myarray1,myarray2);

        System.out.println("Task 5: Camel Case");
        System.out.println(camelCase("AnY noise annoYs an OYster but a noisy noise annoYs an oYster more."));

        System.out.println("Task 6: Check Digit");
        int[] myarray3={3,4,5,6,7};
        System.out.println(checkDigit(myarray3));


    }
    // Implement all methods as public static
    //Aufgabe 1
    public static void oneMonthCalendar(int numberofdays, int whichdaystart){
        for (int i = 1; i < whichdaystart ; i++){
            System.out.print("   ");
        }
        int counter = whichdaystart;
        for (int i = 1; i <= numberofdays; i++){
            if (counter++ % 7 == 1){
                System.out.println();
            }
            System.out.printf("%2d", i);System.out.print(" ");
        }
        System.out.println();
    }
    // Aufgabe 2
    public static long[] lcg(long seed) {
        long[] randomNumbers;
        randomNumbers = new long[10];
        long a = 1103515245, c = 12345, m = 1L << 31; //links schieben Binär
        long x = seed;
        for (int i = 0; i < 10; i++) {
            x = ((a * x + c) % m);
            randomNumbers[i] = x;
        }

        return randomNumbers;
    }



    // Aufgabe 3

    public static int randomNumberBetweenOneAndHundred(){
        Random random= new Random();
        return random.nextInt(99)+1;
    }

    public static void guessingGame(int numberToGuess) {
        int count = 1;
        Scanner scan = new Scanner(System.in);

        System.out.print("Guess number 1: " );
        int userinput = scan.nextInt();

        while ( numberToGuess != userinput && count < 10) {
            if(userinput < 1 || userinput> 100){
                return;
            }
            if (userinput < numberToGuess)  {
                System.out.println("The number AI picked is higher than your guess.");
            } else {
                System.out.println("The number AI picked is lower than your guess.");
            }

            count++;
            System.out.print("Guess number " + count + ": ");
            userinput = scan.nextInt();
        }

            if (numberToGuess == userinput) {
                System.out.println("You won wisenheimer!");
                return;
            }
            if (count == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
            }


      }


    //Aufgabe 4
    public static boolean swapArrays(int[] Array1, int[] Array2) {
        int temporary ;
        if ( Array1.length != Array2.length)    {
            return false;
        }  else {
            for (int i = 0; i < Array1.length; i++) {
                temporary = Array1[i];
                Array1[i] = Array2[i];
                Array2[i] = temporary;
            }
            return true;
        }
    }


    //Aufgabe 5
    public static String camelCase(String text) {
        char[] charArray = text.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            if ((i == 0 && charArray[i] != ' ') || (charArray[i] != ' ' && charArray[i - 1] == ' ')) {
                if (charArray[i] >= 'a' && charArray[i] <= 'z') {
                    result.append((char) (charArray[i] - 'a' + 'A'));
                } else {
                    result.append(charArray[i]);
                }

            } else if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                result.append((char) (charArray[i] + 'a' - 'A'));
            } else if (charArray[i] >= 'a' && charArray[i] <= 'z') {
                result.append(charArray[i]);
            }
            //other symbols don't care, just append

        }
        return result.toString();
    }


    //AUfgabe 6
    public static int checkDigit(int [] code){
        int summe= 0;
        for(int i = 0; i < code.length; i++) {
            summe = summe + code[i] * (i+2) ;
        }
        int differenz = 11 - summe % 11;
        if(differenz == 11){
            differenz= 5;
        }else if (differenz == 10){
            differenz = 0;
        }
        return differenz;
        
    }



    

}