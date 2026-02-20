/* Given an array nums containing n distinct numbers in the range [0, n], 
return the only number in the range that is missing from the array.
*/

public int missingNumber(int[] nums) {
    int xor = nums.length;   // start with n
    
    for (int i = 0; i < nums.length; i++) {
        xor^=i^arr[i];
    }
    
    return xor;
}

/*Input: nums = [3,0,1]
Output: 2
 */
