import java.util.HashMap;

class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class P39_Remove_duplicates_from_a_unsorted_LL {

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

    public static void removeDuplicates(Node head){

        // Approach 1: Using 2 loop || Time complexity O(n^2) || Space complexity O(1)

        // if(head == null || head.next == null){
        //     return;
        // }

        // Node current = head;

        // while(current != null){

        //     Node prev = current;
        //     Node inner_current = current.next;
        //     Node next = inner_current;

        //     while(next != null){

        //         if(current.data == next.data){
        //             prev.next = next.next;
        //         }
        //         else{
        //             prev = inner_current;
        //             inner_current = inner_current.next;
        //             next = inner_current.next;
        //         }
        //     }

        //     current = current.next;


        // Approach 2: Using Map || Time complexity O(n) || Space complexity O(n)
        
        if(head == null || head.next == null){
            return;
        }

        Node temp = head;
        Node prev = null;

        HashMap<Integer, Boolean> map = new HashMap<>();

        while(temp != null){

            if(map.get(temp.data) == null){
                map.put(temp.data, true);
                prev = temp;
                temp = temp.next;
            }
            else{
                System.out.println("Removed " + temp.data);
                // if(temp.next == null){
                //     temp.next = null;
                //     break;
                // }
                prev.next = temp.next;
                prev = temp;
                if(temp.next == null){
                    temp = null;
                    break;
                }
                temp = temp.next.next;
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(2);

        head = insertAtHead(head, 2);
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 4);

        printLL(head);

        removeDuplicates(head);

        printLL(head);
    }
}
