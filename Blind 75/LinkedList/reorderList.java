// Reorder Linked List (MEDIUM)
// ZOHO  AMAZON  MICROSOFT  INFOSYS  TCS DIGITAL
/*You are given the head of a singly linked-list.

You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.

Input: head = [2,4,6,8]
Output: [2,8,4,6]

Input:  head=[1,2,3,4]
Middle  2
Reverse second  4 → 3
Merge → 1 → 4 → 2 → 3
output: [1,4,2,3]

Time: O(n)
Space: O(1)
*/

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // STEP 1: Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // STEP 2: Reverse second half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // break first half

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // STEP 3: Merge two halves
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
