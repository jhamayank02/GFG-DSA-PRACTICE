class Node{
    int data;
    Node next;

    Node(int d){
        this.data = d;
        this.next = null;
    }
}

class P33_Reverse_LL{

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

    public static Node reverseRecursivelyLL(Node prev, Node current, Node forward){
        // Base Case
        // Reached to the end of the list
        // if(current == null){
        //     return prev;
        // }
        // Only one node is present OR Reached to the end of the list
        if(forward == null || forward == current){
            current.next = prev;
            return current;
        }

        current.next = prev;
        prev = current;
        current = forward;

        if(forward.next != null){
            forward = forward.next;
        }

        return reverseRecursivelyLL(prev, current, forward);
    }

    public static Node reverseLL(Node head){

        // Approach 1 :- Iterative Solution Time Complexity - O(n) Space Complexity - O(1)

        // if(head == null || head.next == null){
        //     return head;
        // }

        // Node prev = null;
        // Node current = head;
        // Node next = null;

        // while(current != null){
        //     next = current.next;
        //     current.next = prev;
        //     prev = current;
        //     current = next;
        // }

        // head = prev;

        // return head;


        // Approach 2 :- Recursive Solution Time Complexity - O(n) Space Complexity - O(n)
        // head = reverseRecursivelyLL(null, head, head.next);
        
        // return head;





        // Approach 3: By changing pointers
        // Time complexity O(n) || Space complexity O(1)
        Node prev = null;
		Node next = null;

		while(head != null){

			next = head.next;
			head.next = prev;
			prev = head;
			head = next;

		}

		return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(4);

        printLL(head);

        head = insertAtHead(head, 12);
        head = insertAtHead(head, 834);
        head = insertAtHead(head, 45);

        printLL(head);

        head = reverseLL(head);

        printLL(head);
    }
}