/*Index of an Extra Element
You have given two sorted arrays arr1[] & arr2[] of distinct elements. The first array has one element extra added in between. Return the index of the extra element.

Note: 0-based indexing is followed.
Input: a[] = [2,4,6,8,9,10,12], b[] = [2,4,6,8,10,12]
Output: 4
Explanation: In the first array, 9 is extra added and it's index is 4.*/

class Solution {
    public int findExtra(int a[], int b[]) {
        // add code here.
        int left=0, right=b.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(a[mid]==b[mid]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}