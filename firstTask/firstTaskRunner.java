package firstTask;

import java.util.ArrayList;

public class firstTaskRunner {
    public static void main(String[] args) {
        BracesGenerator bracesGenerator = new BracesGenerator();
        int N = bracesGenerator.getCountBraces();
        ArrayList<String> generatedList = bracesGenerator.generateParens(N);
        writeSolution(generatedList);
    }

    private static void writeSolution(ArrayList<String> generatedList) {
        System.out.println("Array of bracers: " + generatedList);
        System.out.println("Number of bracers options: " + generatedList.size());
    }
}
