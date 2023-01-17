import java.util.ArrayList;

class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class P42_check_LL_is_palindrome_or_not {
    
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

    public static Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
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

    public static void palindrome(Node head){
        // Approach 1: By using a array || Time complexity O(n) || Space complexity O(n)
        // if(head == null){
        //     System.out.println("List is empty!!!");
        //     return;
        // }

        // ArrayList list = new ArrayList<Integer>();

        // Node temp = head;

        // while(temp != null){
        //     list.add(temp.data);
        //     temp = temp.next;
        // }

        // int s = 0;
        // int e = list.size()-1;

        // while(s <= e){

        //     if(list.get(s) != list.get(e)){
        //         System.out.println("List is not palindrome!!!");
        //         return;
        //     }

        //     s++;
        //     e--;
        // }

        // System.out.println("List is palindrome!!!");



        // Approach 2: By finding the middle element/node || Time complexity O(n) || Space complexity O(1)
        if(head == null || head.next == null){
            System.out.println("List is palindrome!!!");
            return;
        }

        // Step 1: Find middle
        Node middle = getMid(head);

        // Step 2: Reverse list after middle
        Node temp = middle.next;
        middle.next = reverse(temp);

        // Step 3: Compare both halves
        Node head1 = head;
        Node head2 = middle.next;

        while(head2 != null){
            if(head1.data != head2.data){
                System.out.println("List is not palindrome!!!");
                return;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        System.out.println("List is palindrome!!!");

        // Step 4: Repeat step 2 so that the list becomes like the original one before reversing its half part(Optional)
        temp = middle.next;
        middle.next = reverse(temp);

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        palindrome(head);
        printLL(head);
    }
}