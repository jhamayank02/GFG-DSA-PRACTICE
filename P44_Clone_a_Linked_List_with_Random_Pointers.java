import java.util.HashMap;

class Node {
    int data;
    Node next;
    Node random;

    Node(int d) {
        this.data = d;
        this.next = null;
        this.random = null;
    }
}

public class P44_Clone_a_Linked_List_with_Random_Pointers {
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

    public static void insertAtTail(Node head, Node tail, int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            tail = new_node;
        }
        else{
            tail.next = new_node;
            tail = new_node;
        }
    }

    public static Node copyList(Node head){
        // Approach 1: Using Map || Time complexity O(n) || Space complexity O(n)

        // Step 1: Create a clone list(Using original list's next pointer)

        // Node cloneHead = null;
        // Node cloneTail = null;

        // Node temp = head;

        // while(temp != null){
        //     // insertAtTail(cloneHead, cloneTail, temp.data);

        //     Node new_node = new Node(temp.data);
        //     if(cloneHead == null){
        //         cloneHead = new_node;
        //         cloneTail = new_node;
        //     }
        //     else{
        //         cloneTail.next = new_node;
        //         cloneTail = new_node;
        //     }

        //     temp = temp.next;
        // }


        // // Step 2: Create a map
        // HashMap<Node, Node> oldToNewNode = new HashMap<>();

        // Node originalNode = head;
        // Node cloneNode = cloneHead;

        // while(originalNode != null){
        //     oldToNewNode.put(originalNode, cloneNode);

        //     originalNode = originalNode.next;
        //     cloneNode = cloneNode.next;
        // }

        // originalNode = head;
        // cloneNode = cloneHead;

        // while(originalNode != null){

        //     cloneNode.random = oldToNewNode.get(originalNode.random);

        //     originalNode = originalNode.next;
        //     cloneNode = cloneNode.next;
        // }

        // return cloneHead;



        // Approach 1: By changing links || Time complexity O(n) || Space complexity O(1)

        // Step 1: Create a clone list
        Node cloneHead = null;
        Node cloneTail = null;

        Node temp = head;

        while(temp != null){
            // insertAtTail(cloneHead, cloneTail, temp.data);

            Node new_node = new Node(temp.data);
            if(cloneHead == null){
                cloneHead = new_node;
                cloneTail = new_node;
            }
            else{
                cloneTail.next = new_node;
                cloneTail = new_node;
            }

            temp = temp.next;
        }

        // Step 2: Add clone node in between original list
        Node originalNode = head;
        Node cloneNode = cloneHead;

        while(originalNode != null && cloneNode != null){
            Node originalNodeNext = originalNode.next;
            originalNode.next = cloneNode;
            originalNode = originalNodeNext;

            Node cloneNodeNext = cloneNode.next;
            cloneNode.next = originalNode;
            cloneNode = cloneNodeNext;
        }


        // Step 3: Random pointer copy
        temp = head;

        while(temp != null){
            if(temp.next != null){
                if(temp.random != null){
                    temp.next.random = temp.random.next;
                }
                else{
                    temp.next = temp.random; // Here temp.random is null
                }
            }

            temp = temp.next.next;
        }


        // Step 4: Revert changes done in step 2
        originalNode = head;
        cloneNode = cloneHead;

        while(originalNode != null && cloneNode != null){

            originalNode.next = cloneNode.next;
            originalNode = originalNode.next;

            if(originalNode != null){
                cloneNode.next = originalNode.next;
            } 
            cloneNode = cloneNode.next;

        }

        // Step 5: Return clone head
        return cloneHead;
    }

    public static void main(String[] args) {
        Node head = new Node(5);

        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        Node clone = copyList(head);
        printLL(head);
        printLL(clone);
    }
}
