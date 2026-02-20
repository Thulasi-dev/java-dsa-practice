/*Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]*/

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // store next node
            curr.next = prev;          // reverse link
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }

        return prev; // new head
    }
}

/*Complexity (Say This Confidently)

Time Complexity: O(n)
Space Complexity: O(1) (in-place)

 One-Line Interview Explanation

“I reverse the linked list by iterating once and changing each node’s next pointer using three pointers: previous, current, and next.”*/
