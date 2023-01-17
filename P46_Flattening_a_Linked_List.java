class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        this.data = d;
        this.next = null;
        this.bottom = null;
    }
}  

public class P46_Flattening_a_Linked_List {
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

    public static Node solve(Node first, Node second){
        Node current = second;
        Node next = second.next;

        while(next != null && first != null){
            if(first.data > current.data && first.data < next.data){
                current.next = first;
                first = first.next;
                current.next.next = next;
                current = current.next;
                next = next.next;
            }
            else{
                current = next;
                if(next != null){
                    next = next.next;
                }
            }
        }

        return second;
    }

    public static Node flatten(Node head){

        if(head == null){
            return head;
        }

        if(head.bottom.data < head.data){
            return solve(head.bottom, head);
        }
        else{
            return solve(head, head.bottom);
        }


    }

    public static void main(String[] args) {
        Node head = new Node(28);

        head = insertAtHead(head, 19);
        head = insertAtHead(head, 10);
        head = insertAtHead(head, 5);

        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next.bottom = new Node(20);

        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        printLL(head);

        printLL(flatten(head));

    }
}
