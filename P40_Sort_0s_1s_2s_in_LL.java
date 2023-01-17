class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class P40_Sort_0s_1s_2s_in_LL {

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

    // public static void sort(Node head){
    public static Node sort(Node head) {

        // Approach 1: Count 0s, 1s and 2s || Time complexity O(n) || Space complexity || O(1)

        // int zero_count = 0;
        // int one_count = 0;
        // int two_count = 0;

        // Node temp = head;

        // while(temp != null){

        // if(temp.data == 0){
        // zero_count++;
        // }
        // else if(temp.data == 1){
        // one_count++;
        // }
        // else{
        // two_count++;
        // }

        // temp = temp.next;
        // }

        // temp = head;

        // while(temp != null){

        // if(zero_count != 0){
        // temp.data = 0;
        // zero_count--;
        // }
        // else if(one_count != 0){
        // temp.data = 1;
        // one_count--;
        // }
        // else{
        // temp.data = 2;
        // two_count--;
        // }

        // temp = temp.next;

        // }

        // Approach 2: Create 3 LL and merge them (When data replacement is not allowed) || Time complexity O(n) || Space complexity O(1)

        Node zero_head = new Node(-1);
        Node zero_tail = zero_head;
        Node one_head = new Node(-1);
        Node one_tail = one_head;
        Node two_head = new Node(-1);
        Node two_tail = two_head;

        Node current = head;

        if (current == null) {
            return null;
        }

        int value = -1;

        // Create separate list for 0s, 1s and 2s
        while (current != null) {
            value = current.data;
            if (value == 0) {
                zero_tail.next = current;
                zero_tail = current;
            } else if (value == 1) {
                one_tail.next = current;
                one_tail = current;
            } else {
                two_tail.next = current;
                two_tail = current;
            }

            current = current.next;
        }

        // Merge 0s, 1s and 2s list

        if (one_head.next != null) {
            // 1s list is not empty
            zero_tail.next = one_head.next;
        } else {
            // 1s list is empty
            zero_tail.next = two_head.next;
        }

        one_tail.next = two_head.next;
        two_tail.next = null;

        head = zero_head.next;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);

        head = insertAtHead(head, 1);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 0);
        head = insertAtHead(head, 1);

        printLL(head);

        head = sort(head);

        printLL(head);
    }

}