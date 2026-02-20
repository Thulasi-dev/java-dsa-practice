import java.util.Scanner;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Coefficients a, b, and c
        System.out.print("Enter the coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter the coefficient c: ");
        double c = scanner.nextDouble();

        // Check if it's a valid quadratic equation
        if (a == 0) {
            System.out.println("The value of 'a' must be non-zero for a quadratic equation.");
        } else {
            // Calculate the discriminant
            double discriminant = Math.pow(b, 2) - 4 * a * c;

            // Case 1: Discriminant is 0 (equal roots)
            if (discriminant == 0) {
                double root = -b / (2 * a);
                System.out.println("The roots are real and equal.");
                System.out.println("Root: " + root);
            }
            // Case 2: Discriminant is greater than 0 (unequal real roots)
            else if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("The roots are real and unequal.");
                System.out.println("Root 1: " + root1);
                System.out.println("Root 2: " + root2);
            }
            // Case 3: Discriminant is less than 0 (no real roots)
            else {
                System.out.println("The equation has no real roots.");
            }
        }

        scanner.close();
    }
}
