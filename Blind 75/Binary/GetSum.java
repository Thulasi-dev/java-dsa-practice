/*Given two integers a and b, return the sum of the two integers without using the operators + and -.

 */

public int getSum(int a, int b) {
    while (b != 0) {
        int carry = (a & b) << 1; // carry
        a = a ^ b;               // sum without carry
        b = carry;               // add carry in next iteration
    }
    return a;
}

/* Input: a = 1, b = 2
Output: 3 */

