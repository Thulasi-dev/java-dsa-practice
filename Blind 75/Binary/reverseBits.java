/* Reverse bits of a given 32 bits signed integer. */

public int reverseBits(int n) {
    int result = 0;
    
    for (int i = 0; i < 32; i++) {
        result <<= 1;          // make space
        result |= (n & 1);     // add last bit of n
        n >>>= 1;              // unsigned right shift
    }
    
    return result;
}

/* Input: n = 43261596

Output: 964176192

Explanation:

Integer  	Binary
43261596	00000010100101000001111010011100
964176192	00111001011110000010100101000000
 */
