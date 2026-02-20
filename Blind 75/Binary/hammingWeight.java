/*Given a positive integer n, write a function that returns the number of set bits in its 
binary representation (also known as the Hamming weight).*/



public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
        n = n & (n - 1); // remove rightmost set bit
        count++;
    }
    return count;
}

/* Input: n = 11
Output: 3
Explanation:
The input binary string 1011 has a total of three set bits.

*/
