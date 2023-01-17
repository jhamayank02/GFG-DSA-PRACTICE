import java.util.HashMap;

class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class P48_Intersection_Point_in_Y_Shapped_Linked_Lists {
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

    static int getLength(Node head){
        int length = 0;

        Node temp = head;

        while(temp != null){
            temp = temp.next;
            length++;
        }

        return length;
    }

    static int intersectPoint(Node head1, Node head2){
        // Approach 1: Using 2 loops || Time complexity O(n*m) || Space complexity O(1)
        // if(head1 == null || head2 == null){
        //     return -1;
        // }
        // Node temp1 = head1;
        
        // while(temp1 != null){
        //     Node temp2 = head2;

        //     while(temp2 != null){
        //         if(temp1 == temp2){
        //             return temp1.data;
        //         }
        //         temp2 = temp2.next;
        //     }

        //     temp1 = temp1.next;
        // }

        // return -1;


        // Approach 2: Using Map || Time complexity O(m+n) || Space complexity O(n) or O(m), whichever is stored in the map
        // if(head1 == null || head2 == null){
        //     return -1;
        // }
        // Node temp1 = head1;
        // Node temp2 = head2;

        // // true - visited
        // // false - not visited
        // HashMap<Node, Boolean> map = new HashMap<>();

        // while(temp1 != null){
        //     map.put(temp1, true);
        //     temp1 = temp1.next;
        // }

        // while(temp2 != null){
        //     if(map.get(temp2) != null && map.get(temp2) == true){
        //         return temp2.data;
        //     }
        //     temp2 = temp2.next;
        // }

        // return -1;


        // Approach 3: Using the difference in node counts || Time complexity O(m+n) || Space complexity O(1)
        if(head1 == null || head2 == null){
            return -1;
        }

        int length1 = 0;
        int length2 = 0;

        Node temp1 = head1;
        Node temp2 = head2;

        length1 = getLength(head1);
        length2 = getLength(head2);

        int difference = Math.abs(length1 - length2);

        if(length1 < length2){
            int count = 0;
            while(count != difference){
                temp2 = temp2.next;
                count++;
            }
        }
        else{
            int count = 0;
            while(count != difference){
                temp1 = temp1.next;
                count++;
            }
        }

        while(temp1 != null && temp2 != null){
            if(temp1 == temp2){
                return temp1.data;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return -1;
    }

    public static void main(String[] args) {
        Node head2 = new Node(30);

        head2 = insertAtHead(head2, 15);
        head2 = insertAtHead(head2, 10);

        Node head1 = new Node(9);
        head1.next = head2.next;

        head1 = insertAtHead(head1, 6);
        head1 = insertAtHead(head1, 3);

        printLL(head1);
        printLL(head2);

        int intersection = intersectPoint(head1, head2);

        System.out.println(intersection);
    }
}
