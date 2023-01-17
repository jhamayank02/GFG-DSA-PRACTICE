class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class P43_Add_2_Numbers_represented_by_Linked_Lists {
    
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
    
    public static Node reverse(Node head){
        Node current = head;
        Node prev = null;
        Node next = null;

        while(current != null){
            next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // public static Node insertAtTail(Node head, Node tail, Node temp){
    public static void insertAtTail(Node head, Node tail, int digit){
        Node temp = new Node(digit);

        if(head == null){
            head = temp;
            tail = temp;
        }
        else{
            tail.next = temp;
            tail = temp;
        }

        // return head;
    }

    public static Node add(Node first, Node second){
        int carry = 0;

        Node ansHead = null;
        Node ansTail = null;

        // while(first != null && second != null){
        while(first != null || second != null){

            int val1 = 0;
            if(first != null){
                val1 = first.data; 
            }

            int val2 = 0;
            if(second != null){
                val2 = second.data; 
            }

            int sum = carry + val1 + val2;
            int digit = sum % 10;
            
            Node temp = new Node(digit);

            // Add digit at the tail of the ans LL
            // ansHead = insertAtTail(ansHead, ansTail, digit);
            // insertAtTail(ansHead, ansTail, digit);
            if(ansHead == null){
                ansHead = temp;
                ansTail = temp;
            }
            else{
                ansTail.next = temp;
                ansTail = temp;
            }

            carry = sum / 10;

            if(first != null){
                first = first.next;
            }
            if(second != null){
                second = second.next;
            }
        }

        // If any of the two lists is shorter than the other
        // while(first != null){
        //     int sum = carry + first.data;
        //     int digit = sum % 10;

        //     Node temp = new Node(digit);

        //     // ansHead = insertAtTail(ansHead, ansTail, digit);
        //     if(ansHead == null){
        //         ansHead = temp;
        //         ansTail = temp;
        //     }
        //     else{
        //         ansTail.next = temp;
        //         ansTail = temp;
        //     }

        //     first = first.next;
        //     carry = sum / 10;
        // }
        // while(second != null){
        //     int sum = carry + second.data;
        //     int digit = sum % 10;

        //     Node temp = new Node(digit);

        //     // ansHead = insertAtTail(ansHead, ansTail, digit);
        //     if(ansHead == null){
        //         ansHead = temp;
        //         ansTail = temp;
        //     }
        //     else{
        //         ansTail.next = temp;
        //         ansTail = temp;
        //     }
        //     second = second.next;
        //     carry = sum / 10;
        // }
        // while(carry != 0){
        //     int sum = carry;
        //     int digit = sum % 10;

        //     Node temp = new Node(digit);

        //     // ansHead = insertAtTail(ansHead, ansTail, digit);
        //     if(ansHead == null){
        //         ansHead = temp;
        //         ansTail = temp;
        //     }
        //     else{
        //         ansTail.next = temp;
        //         ansTail = temp;
        //     }
        //     carry = sum / 10;
        // }

        printLL(ansHead);

        return ansHead;
    }

    public static Node addTwoLists(Node first, Node second){

        // Time complexity -> 186 -> O(M) + 187 -> O(N) 190 -> O(max(M,N)) 193 -> O(M+N) ==> O(M+N) || Space complexity O(max(M,N))

        // Step 1: Reverse input LL

        first = reverse(first);
        second = reverse(second);

        // Step 2: Add 2 LL
        Node ans = add(first, second);

        // Step 3: Reverse answer list
        ans = reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        Node first = new Node(5);
        first = insertAtHead(first, 4);

        Node second = new Node(5);
        second = insertAtHead(second, 4);
        second = insertAtHead(second, 3);

        printLL(first);
        printLL(second);

        Node ans = addTwoLists(first, second);
        printLL(ans);
    }

}
