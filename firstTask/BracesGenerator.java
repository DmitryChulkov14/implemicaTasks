package firstTask;

import firstTask.exceptions.NegativeNumberException;

import java.util.ArrayList;
import java.util.Scanner;

public class BracesGenerator {

    private int countBraces;

    BracesGenerator() {
        readPositiveNumberFromKeyboard();
    }

    int getCountBraces() {
        return countBraces;
    }

    /**
     * Method of generating a list of all possible options for the location of bracers
     */
    ArrayList<String> generateParens(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }

    /**
    * Method of recursively adding bracers to an ArrayList
    */
    private void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
        if (leftRem < 0 || rightRem < leftRem) return; // incorrect state and out of recursion

        if (leftRem == 0 && rightRem == 0) { /* no more left bracers */
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
        /* add left bracket if left any left bracers */
            if (leftRem > 0) {
                str[count] = '(';
                addParen(list, leftRem - 1, rightRem, str, count + 1);
            }

        /* add the right bracer if the expression is true */
            if (rightRem > leftRem) {
                str[count] = ')';
                addParen(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }

    /**
     * Method reading data from keyboard.
     * User must enter only a positive integer number.
     *
     * If line from keyboard isn't integer number. User get a warning massage.
     * If line from keyboard is number, but it is a negative number. User get a warning massage.
     *
     * When user entered the correct data, method save int positive number for further use
     */
    private void readPositiveNumberFromKeyboard(){

        int enteredNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the count of braces: ");
        while (true) {
            try {
                enteredNumber = Integer.parseInt(scanner.nextLine());
                if (enteredNumber < 0) throw new NegativeNumberException();
                break;
            } catch (NumberFormatException ex){
                System.out.print("Entered symbols isn't integer number, please enter number again: ");
            } catch (NegativeNumberException ex) {
                System.out.print("Number must be a positive, please enter number again: ");
            }
        }
        countBraces = enteredNumber;
    }
}
