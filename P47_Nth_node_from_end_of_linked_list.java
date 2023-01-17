class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}


public class P47_Nth_node_from_end_of_linked_list {
    
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

    static int getNthFromLast(Node head, int n)
    {
    	// Your code here
    	int length = 0;
    	
    	Node temp = head;
    	
    	while(temp != null){
    	    temp = temp.next;
    	    length++;
    	}
    	
    	// Position of the Node we have to return from start
    	int required_position = length - n + 1;
    	
    	// If the given position doesn't exist in the list
    	if(required_position < 1){
    	    return -1;
    	}
    	
    	temp = head;
    	
    	int count = 0;
    	
    	while(count < required_position - 1 && temp != null){
    	    temp = temp.next;
    	    count++;
    	}
    	
    	return temp.data;
    	
    }

    public static void main(String[] args) {
        Node head = new Node(9);

        head = insertAtHead(head, 8);
        head = insertAtHead(head, 7);
        head = insertAtHead(head, 6);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        printLL(head);

        System.out.println("The data of the location 2 from the end is " + getNthFromLast(head, 2));
    }
}
