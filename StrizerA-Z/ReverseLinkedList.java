// Company Tags     Paytm    VMWare    Zoho    Accolite    Amazon    Microsoft    Samsung    Snapdeal    D-E-Shaw    MakeMyTrip    Teradata
// Walmart    Goldman Sachs    Intuit    Adobe SAP Labs    Tejas Network    Cisco    Qualcomm    Cognizant    Mahindra Comviva    IgniteWorld

// Given the head of a linked list, the task is to reverse this list and return the reversed head.

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedList {
    // Function to reverse the linked list
    public static Node reverseList(Node head) {
        Node prev = null; // To keep track of the previous node
        Node current = head; // Start with the head
        Node next = null; // To keep track of the next node

        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the pointer
            prev = current; // Move prev one step forward
            current = next; // Move current one step forward
        }

        // After the loop, prev will be the new head of the reversed list
        return prev;
    }

    // Function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the linked list
        head = reverseList(head);

        System.out.println("Reversed Linked List:");
        printList(head);
    }
}

/* Input:
A linked list: 1 -> 2 -> 3 -> 4 -> null

Output:
Reversed linked list: 4 -> 3 -> 2 -> 1 -> null */
