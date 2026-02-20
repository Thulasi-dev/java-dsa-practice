// Given an integer array nums, return true if any value appears at least twice in the array, and return false // if every element is distinct.

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
        if (seen.contains(nums[i])) {
            return true;
        }
        seen.add(nums[i]);
    }
    return false;
}

	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(containsDuplicate(nums));

}
}

/*Short Interview Explanation

“This program checks whether an array contains any duplicate elements.
I use a HashSet because it stores only unique values and provides O(1) lookup time.
I iterate through the array and for each element, I first check if it already exists in the set.
If it exists, I immediately return true because a duplicate is found.
If not, I add the element to the set.
If the loop completes without finding duplicates, I return false.” 

Time Complexity: O(n) — single traversal of the array
Space Complexity: O(n) — extra space for the HashSet*/