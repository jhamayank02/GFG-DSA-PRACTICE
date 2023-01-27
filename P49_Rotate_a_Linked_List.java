class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class P49_Rotate_a_Linked_List {
    public static void printLL(Node head) {
        if (head == null) {
            System.out.println("Linked list is empty!!!");
        } else {
            Node temp = head;

            System.out.print("List:- ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static Node insertAtHead(Node head, int data) {
        if (head == null) {
            Node new_node = new Node(data);
            head = new_node;
        } else {
            Node new_node = new Node(data);

            new_node.next = head;
            head = new_node;
        }

        return head;
    }

    public static Node reverse(Node head){
        Node current = head;
        Node prev = null;
        Node next = null;

        while(current != null){
            next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static Node rotate(Node head, int k){
        // Approach 1: By splitting the list in two parts and then swap the positions of both the lists || Time complexity O(n) || Space complexity O(1)
        int count = 0;

        Node temp1 = head;

        while(temp1 != null && count != k-1){
            temp1 = temp1.next;
            count++;
        }

        if(temp1.next == null){
            return head;
        }

        Node temp2 = temp1.next;
        temp1.next = null;

        Node newHead = temp2;

        while(temp2.next != null){
            temp2 = temp2.next;
        }

        temp2.next = head;
        head = newHead;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(5);

        head = insertAtHead(head, 18);
        head = insertAtHead(head, 26);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 12);
        head = insertAtHead(head, 19);
        head = insertAtHead(head, 6);
        head = insertAtHead(head, 8);
        head = insertAtHead(head, 9);

        printLL(head);

        head = rotate(head, 9);

        printLL(head);
    }
}
