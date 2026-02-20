// Given the head of a linked list, the task is to find the middle. For example, the middle of 1-> 2->3->4->5 is 3. If there are two middle nodes (even count), return the second middle. // For example, middle of 1->2->3->4->5->6 is 4.

// Company Tags  
// VMWare  Zoho  Flipkart  Morgan Stanley  Amazon  Microsoft  Samsung  Hike  Payu  MAQ Software  Adobe  Wipro  SAP Labs  Qualcomm  Nagarro  GE  Veritas  IgniteWorld  Netskope


class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MiddleOfLinkedList {
    
    // Function to find the middle element of the linked list
    int getMiddle(Node head) {
        if (head == null) return -1; // Return -1 if list is empty

        Node slow = head;
        Node fast = head;

        // Move fast by two steps and slow by one step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data; // Return the middle node's value
    }

    public static void main(String[] args) {
        MiddleOfLinkedList list = new MiddleOfLinkedList();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Middle Element: " + list.getMiddle(head)); // Output: 3

        // Creating an even-length linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = new Node(6);

        System.out.println("Middle Element: " + list.getMiddle(head2)); // Output: 4
    }
}
