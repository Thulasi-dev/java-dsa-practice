/*Check if a number is Armstrong Number or not

Problem Statement:Given an integer N, return true it is an Armstrong number otherwise return false.

An Armstrong number is a number that equals the sum of its digits, 
each raised to the power of the total number of digits.

Armstrong Number 153, 370, 371, 407 */

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int original = n;
        int sum = 0;
        
        while (n > 0) {
            int digit = n % 10;      // Extract digit
            sum += digit * digit * digit;  // Cube and add
            n = n / 10;              // Remove digit
        }
        
        if (sum == original) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
    }
}

/*153
=(1)^3+(5)^3 +(3)^3
=1+125+27
=153

Input:N = 371                
Output: True
Explanation: 3^3+7^3+1^3 = 27 + 343 + 1 = 371

Time Complexity: O(log₁₀N+1)
 Space Complexity: O(1)*/