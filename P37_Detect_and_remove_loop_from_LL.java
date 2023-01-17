class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class P37_Detect_and_remove_loop_from_LL {

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

    public static Node floydDetectLoop(Node head){
        // Approach : Fast and Slow pointer || Time complexity O(n) || Space complexity O(1)

        if(head == null || head.next == head){
            System.out.println("The linked list is circular!!!");
            return head;
        }

        if(head.next == null){
            System.out.println("The linked list is not circular!!!");
            return null;
        }

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast != slow){
            slow = slow.next;
            fast = fast.next;

            if(fast != null){
                fast = fast.next;
            }
        }

        if(fast == slow){
            System.out.println("The linked list is circular!!!");
            return fast;
        }
        else{
            System.out.println("The linked list is not circular!!!");
            return null;
        }
    }

    public static Node startOfLoop(Node head){

        Node intersection = floydDetectLoop(head);

        if(intersection == null){
            return null;
        }

        Node slow = head;
        intersection = intersection.next;

        while(slow != intersection){
            slow = slow.next;
            intersection = intersection.next;
        }

        return slow;

    }

    public static Node removeLoop(Node head){

        Node startLoop = startOfLoop(head);

        if(startLoop == null){
            return head;
        }
        else{
        
            Node temp = startLoop;

            while(temp.next != startLoop){
                temp = temp.next;
            }

            temp.next = null;

            return head;
        }
        
    }

    public static void main(String[] args) {
        Node head = new Node(8);

        head = insertAtHead(head, 10);
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 12);
        head = insertAtHead(head, 834);
        head = insertAtHead(head, 45);

        // printLL(head);
        head.next.next.next.next.next.next = head.next.next.next;

        head = removeLoop(head);

        // Node intersection = floydDetectLoop(head);
        // System.out.println("Intersection " + intersection.data);
        // Node temp = startOfLoop(head);
        // System.out.println("Loop starting at " + temp.data);

        printLL(head);
    }
    
} 
