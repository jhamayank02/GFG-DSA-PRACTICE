import java.util.HashMap;

class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class P36_Check_LL_is_circular_or_not {
    
    
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

    public static void circularOrNot(Node head){
        // Approach 1: By traversing the whole linked list || Time Complexity O(n) || Space Complexity O(1)

        // if(head == null || head.next == head){
        //     System.out.println("The linked list is circular!!!");
        //     return;
        // }

        // if(head.next == null){
        //     System.out.println("The linked list is not circular!!!");
        //     return;
        // }

        // Node temp = head.next;

        // while(temp != null && temp != head){
        //     temp = temp.next;
        // }

        // if(temp == null){
        //     System.out.println("The linked list is not circular!!!");
        // }
        // else{
        //     System.out.println("The linked list is circular!!!");
        // }



        // Approach 2: Fast and Slow pointer || Time complexity O(n) || Space complexity O(1)

        // if(head == null || head.next == head){
        //     System.out.println("The linked list is circular!!!");
        //     return;
        // }

        // if(head.next == null){
        //     System.out.println("The linked list is not circular!!!");
        //     return;
        // }

        // Node slow = head;
        // Node fast = head.next;

        // while(fast != null && fast != slow){
        //     slow = slow.next;
        //     fast = fast.next;

        //     if(fast != null){
        //         fast = fast.next;
        //     }
        // }

        // if(fast == slow){
        //     System.out.println("The linked list is circular!!!");
        // }
        // else{
        //     System.out.println("The linked list is not circular!!!");
        // }



        // Approach 3: Using Map || Time complexity O(n) || Space complexity O(n)

        if(head == null || head.next == head){
            System.out.println("The linked list is circular!!!");
            return;
        }

        if(head.next == null){
            System.out.println("The linked list is not circular!!!");
            return;
        }

        Node temp = head;
        HashMap<Integer, Boolean> map = new HashMap<>();

        while(temp != null){

            if(map.get(temp.data) == null){
                map.put(temp.data, true);
            }
            else{
                System.out.println("The linked list is circular!!!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("The linked list is not circular!!!");

    }


    public static void main(String[] args) {
        Node head = new Node(4);

        head = insertAtHead(head, 12);
        head = insertAtHead(head, 834);
        head = insertAtHead(head, 45);

        // head.next.next = head;

        printLL(head);

        circularOrNot(head);
    }
}
