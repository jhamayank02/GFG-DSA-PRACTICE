class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}    
    
public class P51_Add_1_to_a_number_represented_as_linked_list {
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

    static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while(current != null){
            
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            
        }
        
        return prev;
    }

    public static Node addOne(Node head) {
        // Time complexity -> O(n) || Space complexity O(1)

        // If the list will be empty then it will simply return 1 as ans
        if(head == null){
            head = new Node(1);
            return head;
        }
        // Now head is pointing to the head of the reversed list, this will help in returning ans
        head = reverse(head);

        // temp will be used to traverse the list
        Node temp = head;

        // prev will store temp's previous element
        Node prev = null;
        
        // Here we have taken carry as 1, as we have to add 1 in the list
        int carry = 1;

        do{

            int sum = carry + temp.data;
            int digit = sum % 10;
            carry = sum / 10;

            temp.data = digit; // Change the temp's data with the new data

            if(temp != null){
                prev = temp;
                temp = temp.next;
            }

        }while(temp != null && carry != 0);

        // In case we have left with a carry and no node then add a new node at the end of the list with the carry as its data
        // Eg -> 99 + 1 = 100 -> Here in actual list we only have 2 nodes. To return the ans we need one extra node
        if(temp == null && carry != 0){
            Node new_node = new Node(carry);
            prev.next = new_node;
        }

        // head is pointing to the end of the list
        return reverse(head);
    }

    public static void main(String[] args) {
        Node head = new Node(9);

        head = insertAtHead(head, 9);
        head = insertAtHead(head, 4);

        printLL(head);

        head = addOne(head);

        printLL(head);
    }
}