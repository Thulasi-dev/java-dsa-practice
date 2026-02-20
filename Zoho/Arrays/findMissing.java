/*Find missing in second array

Given two integer arrays a and b, the task is to find the numbers which are present in the first array a, but not present in the second array b.

Note: Numbers to be returned should in order as they appear in array a.
Input: a[] = [1, 2, 3, 4, 5, 10], b[] = [2, 3, 1, 0, 5]
Output: [4, 10]
Explanation: 4 and 10 are present in first array, but not in second array.

Efficient Approach (Using HashSet)
Idea:

Put all elements of b into a HashSet
Traverse a
If element of a is not in the set, add to result list

Time: O(n + m)
Space: O(m)

*/

public static ArrayList<Integer> findMissing(int[] a, int[] b) {
    HashSet<Integer> setB = new HashSet<>();
    for (int num : b) {
        setB.add(num);
    }

    ArrayList<Integer> result = new ArrayList<>();
    for (int num : a) {
        if (!setB.contains(num)) {
            result.add(num);
        }
    }

    return result;
}
