class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class P41_Merge_2_sorted_linked_lists {
    
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

        // If only one element is present in the first list
        if(first.next == null){
            first.next = second;
            return first;
        }
        
        // Current element of the first list
        Node curr1 = first;
        // Next element of the first list
        Node next1 = first.next;
        // Current element of the second list
        Node curr2 = second;
        // Next element of the second list
        Node next2 = second.next;


        // Until one of the lists comes to the end
        while(next1 != null && curr2 != null){

            // If the second list's current element can be inserted between the first list's current and next element
            if(curr2.data >= curr1.data && curr2.data <= next1.data){
                curr1.next = curr2;
                curr2.next = next1;

                curr1 = curr2;

                curr2 = next2;
                if(curr2 == null){
                    next2 = null;
                    break;
                }
                next2 =  curr2.next;
            }
            // Else check between next 2 elements
            else{
                curr1 = next1;
                next1 = next1.next;

                if(next1 == null){
                    curr1.next = curr2;
                    return first;
                }
            }
        }

        return first;
    }

    public static Node merge(Node first, Node second){
        // Time complexity O(m+n) || Space complexity O(1)

        // If first list is empty then return the second list
        if(first == null){
            return first;
        }

        // If second list is empty then return the first list
        if(second == null){
            return second;
        }

        // If the first element of the first list is smaller than the second list's first element
        if(first.data <= second.data){
            return solve(first, second);
        }
        else{
            return solve(second, first);
        }

    }

    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1 = insertAtHead(head1, 3);
        head1 = insertAtHead(head1, 1);

        Node head2 = new Node(5);
        head2 = insertAtHead(head2, 4);
        head2 = insertAtHead(head2, 2);

        printLL(head1);
        printLL(head2);

        Node merged = merge(head1, head2);
        printLL(merged);
    }
}
