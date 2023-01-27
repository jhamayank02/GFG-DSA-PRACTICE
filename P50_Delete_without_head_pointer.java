class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}    

public class P50_Delete_without_head_pointer {
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

    static void deleteNode(Node del){
        del.data = del.next.data;
        del.next = del.next.next;
    }

    public static void main(String[] args) {
        Node head = new Node(5);

        head = insertAtHead(head, 18);
        head = insertAtHead(head, 26);
        head = insertAtHead(head, 3);

        printLL(head);

        deleteNode(head.next);

        printLL(head);
    }
}
