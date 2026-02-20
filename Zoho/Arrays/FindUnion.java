/*Union of Arrays with Duplicates
You are given two arrays a[] and b[], return the Union of both the arrays in any order.

The Union of two arrays is a collection of all distinct elements present in either of the arrays.
 If an element appears more than once in one or both arrays, it should be included only once in the result.

Note: Elements of a[] and b[] are not necessarily distinct.
Note that, You can return the Union in any order but the driver code will print the result in sorted order only
Input: a[] = [1, 2, 3, 2, 1], b[] = [3, 2, 2, 3, 3, 2]
Output: [1, 2, 3]
Time & Space
Time: O(n + m)
Space: O(n + m)*/


// HashSet Method
public static ArrayList<Integer> findUnion(int[] a, int[] b) {
    HashSet<Integer> set = new HashSet<>();

    // add all elements of first array
    for (int num : a) {
        set.add(num);
    }

    // add all elements of second array
    for (int num : b) {
        set.add(num);
    }

    // convert set to arraylist
    return new ArrayList<>(set);
}

-------------------------------------

// two pointer method
public static ArrayList<Integer> findUnion(int[] a, int[] b) {

    ArrayList<Integer> union = new ArrayList<>();

    int i = 0, j = 0;

    while (i < a.length && j < b.length) {

        // Skip duplicates in a[]
        if (i > 0 && a[i] == a[i - 1]) {
            i++;
            continue;
        }

        // Skip duplicates in b[]
        if (j > 0 && b[j] == b[j - 1]) {
            j++;
            continue;
        }

        if (a[i] < b[j]) {
            union.add(a[i]);
            i++;
        } 
        else if (a[i] > b[j]) {
            union.add(b[j]);
            j++;
        } 
        else { // equal
            union.add(a[i]);
            i++;
            j++;
        }
    }

    // Add remaining elements from a[]
    while (i < a.length) {
        if (i == 0 || a[i] != a[i - 1]) {
            union.add(a[i]);
        }
        i++;
    }

    // Add remaining elements from b[]
    while (j < b.length) {
        if (j == 0 || b[j] != b[j - 1]) {
            union.add(b[j]);
        }
        j++;
    }

    return union;
}
