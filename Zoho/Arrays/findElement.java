/*Element with left side smaller and right side greater
Given an unsorted array of arr. Find the first element in an array such that all of its left elements
 are smaller and all right elements of its are greater than it.

Note: Return -1 if there is no such element.
Input: arr = [4, 2, 5, 7]
Output: 5
Explanation: Elements on left of 5 are smaller than 5 and on right of it are greater than 5.

*/

public static int findElement(int[] arr) {
    int n = arr.length;

    if (n < 3) 
        return -1;  // no such possible element

    int[] leftMax = new int[n];
    int[] rightMin = new int[n];

    // Build leftMax[]
    leftMax[0] = arr[0];
    for (int i = 1; i < n; i++) {
        leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
    }

    // Build rightMin[]
    rightMin[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
    }

    // Find required element
    for (int i = 1; i < n - 1; i++) {
        if (leftMax[i - 1] < arr[i] && arr[i] < rightMin[i + 1]) {
            return arr[i];
        }
    }

    return -1;
}

/*Time: O(n)
Space: O(n)*/