class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class P38_Remove_duplicates_from_a_sorted_LL {

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

        Node current = head;

        while(current != null){

            if(current.next != null && current.data == current.next.data){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }

    }
    
    public static void main(String[] args) {
        Node head = new Node(4);

        head = insertAtHead(head, 3);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        printLL(head);

        removeDuplicates(head);

        printLL(head);

    }
}
