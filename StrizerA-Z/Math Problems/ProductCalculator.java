// Implement a program to calculate the product of three positive integer values. However, if one of the integers is 7, 
// consider only the values to the right of 7 for calculation.  If 7 is the last integer, then display -1.

// Note: Only one of the three values can be 7.

import java.util.Scanner;

public class ProductCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Three positive integers
        System.out.print("Enter the first positive integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second positive integer: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter the third positive integer: ");
        int num3 = scanner.nextInt();

        // Validate input (all values must be positive)
        if (num1 <= 0 || num2 <= 0 || num3 <= 0) {
            System.out.println("All values must be positive integers.");
        } else {
            int product = 1; // Initialize the product

            // Check for the presence of 7 and calculate product accordingly
            if (num1 == 7) {
                product = (num2 != 7 && num3 != 7) ? num2 * num3 : -1;
            } else if (num2 == 7) {
                product = (num3 != 7) ? num3 : -1;
            } else if (num3 == 7) {
                product = -1; // 7 is the last number
            } else {
                product = num1 * num2 * num3; // No 7 present
            }

            // Output the result
            if (product == -1) {
                System.out.println("Output: -1");
            } else {
                System.out.println("The product is: " + product);
            }
        }

        scanner.close();
    }
}
