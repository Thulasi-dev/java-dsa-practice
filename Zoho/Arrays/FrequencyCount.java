/*Frequencies in a Limited Array
You are given an array arr[] containing positive integers. The elements in the array arr[] range from  
1 to n (where n is the size of the array), and some numbers may be repeated or absent. 
Your have to count the frequency of all numbers in the range 1 to n and return an array of size n
 such that result[i] represents the frequency of the number i (1-based indexing).

Input: arr[] = [2, 3, 2, 3, 5]
Output: [0, 2, 2, 0, 1]
Explanation: We have: 1 occurring 0 times, 2 occurring 2 times, 3 occurring 2 times, 4 occurring 0 times, 
and 5 occurring 1 time.*/

public List<Integer> frequencyCount(int[] arr) {

    int n = arr.length;

    // Step 1: decrease all values by 1 so they become 0..n-1
    for (int i = 0; i < n; i++) {
        arr[i] = arr[i] - 1;
    }

    // Step 2: use each value as index and increase by n
    for (int i = 0; i < n; i++) {
        int index = arr[i] % n;   // original value
        arr[index] += n;          // add n to count
    }

    // Step 3: convert counts back (divide by n)
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        int freq = arr[i] / n;
        result.add(freq);
    }

    return result;
}

/*Numbers are in the range 1..n, so I use the original array as a frequency map by encoding 
counts through modular arithmetic. I increment index (value-1) by n for every occurrence, 
then divide by n to extract frequency. This keeps O(1) extra space and O(n) time.*/