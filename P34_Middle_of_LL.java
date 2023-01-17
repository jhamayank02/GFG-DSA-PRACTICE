class Node{
    int data;
    Node next;

    Node(int d){
        this.data = d;
        this.next = null;
    }
}

public class P34_Middle_of_LL {
    public static void printLL(Node head){
        if(head == null){
            System.out.println("Linked list is empty!!!");
        }
        else{
            Node temp = head;

            System.out.print("List:- ");
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static Node insertAtHead(Node head, int data){
        if(head == null){
            Node new_node = new Node(data);
            head = new_node;
        }
        else{
            Node new_node = new Node(data);

            new_node.next = head;
            head = new_node;
        }

        return head;
    }
    
    public static Node midOfLL(Node head){
        // Approach 1 :- By traversing the whole Linked List || Time Complexity - O(n) || Space Complexity - O(1)

        // if(head == null){
        //     return head;
        // }

        // Node temp = head;
        // int length = 0;

        // while(temp != null){
        //     temp = temp.next;
        //     length++;
        // }

        // int count = (length/2) + 1;

        // temp = head;

        // while(--count != 0){
        //     temp = temp.next;
        // }

        // return temp;




        // Approach 2 :- Fast and Slow pointer approach || Time Complexity - O(n/2) = O(n) || Space Complexity - O(1)

        if(head == null || head.next == null){
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while(fast != null){
            slow = slow.next;
            fast = fast.next;

            if(fast != null){
                fast = fast.next;
            }
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        

        head = insertAtHead(head, 12);
        head = insertAtHead(head, 834);
        head = insertAtHead(head, 45);

        printLL(head);

        Node mid = midOfLL(head);
        System.out.println("Middle of the Linked List is " + mid.data);
    }
}
