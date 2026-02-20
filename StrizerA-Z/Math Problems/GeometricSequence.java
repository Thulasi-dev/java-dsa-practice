// Implement a program to display the geometric sequence as given below for a given value n,  where n is the number of elements in the sequence.

// 1, 2, 4, 8, 16, 32, 64, ......, 1024

import java.util.Scanner;

public class GeometricSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of elements in the sequence
        System.out.print("Enter the number of elements in the geometric sequence: ");
        int n = scanner.nextInt();

        // Check if the input is valid
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            System.out.print("Geometric Sequence: ");

            int term = 1; // First term of the sequence
            for (int i = 0; i < n; i++) {
                System.out.print(term);

                // Print a comma after each term except the last one
                if (i < n - 1) {
                    System.out.print(", ");
                }

                term *= 2; // Multiply the term by 2 to get the next term
            }
        }

        scanner.close();
    }
}
