// Top K Frequent Elements

/*Given an integer array nums and an integer k, return the k most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.

Input: nums = [1,2,2,3,3,3], k = 2
Output: [2,3]

Input: nums = [7,7], k = 1
Output: [7]

Time: O(n)  
Space: O(n)

*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket array (index = frequency)
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // Step 3: Collect top k frequent elements
        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return result;
    }
}
