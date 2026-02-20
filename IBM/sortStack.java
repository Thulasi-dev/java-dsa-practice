/* Sort a stack

Given a stack of integers st[]. Sort the stack in ascending order (smallest element at the bottom and largest at the top).

Input: st[] = [1, 2, 3]
Output: [3, 2, 1]

Input: st[] = [41, 3, 32, 2, 11]
Output: [41, 32, 11, 3, 2]

Remove all elements using recursion, then insert them back one by one
in their correct sorted position.
 
Time & Space Complexity

Time: O(n²) (due to recursive insertion)
Space: O(n) (recursive call stack)*/

public void sortStack(Stack<Integer> st) {
    // Base case: if stack is empty, return
    if (st.isEmpty()) {
        return;
    }

    // Step 1: Remove top element
    int top = st.pop();

    // Step 2: Sort remaining stack
    sortStack(st);

    // Step 3: Insert the element in sorted order
    insertSorted(st, top);
}

private void insertSorted(Stack<Integer> st, int element) {
    // If stack is empty or element is greater than top
    if (st.isEmpty() || st.peek() <= element) {
        st.push(element);
        return;
    }

    // Otherwise remove top and recurse
    int top = st.pop();
    insertSorted(st, element);

    // Put back the removed element
    st.push(top);
}



