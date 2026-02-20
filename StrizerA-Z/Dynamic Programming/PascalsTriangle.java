// Given an integer numRows, return the first numRows of Pascal's triangle.

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Base case: if numRows is 0, return an empty list
        if (numRows <= 0) {
            return triangle;
        }

        // Generate each row of the Pascal's Triangle
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // Each row starts and ends with 1
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Compute the value from the two numbers directly above
                    int value = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(value);
                }
            }

            // Add the current row to the triangle
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        // Example input
        int numRows = 5;

        // Generate and print Pascal's triangle
        List<List<Integer>> result = generate(numRows);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
