package thirdTask;

import java.math.BigInteger;

public class thirdTaskRunner {
    public static void main(String[] args) {
        int factorial = 100;
        System.out.println("Sum of digits in number of " + factorial + "! = " +getSumOfDigitsInNumberOfFactorial(factorial));
    }

    private static long getSumOfDigitsInNumberOfFactorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i)); /* find factorial of number "n" */
        }
        long sum = 0;
        while (fact.compareTo(BigInteger.ZERO) > 0) { /* perform actions in a cycle, until the numbers run out */
            sum += fact.mod(BigInteger.TEN).longValue(); /* getting the digit by the remainder of dividing by ten */
            fact = fact.divide(BigInteger.TEN); /* reducing factorial ten times */
        }
        return sum;
    }
}
