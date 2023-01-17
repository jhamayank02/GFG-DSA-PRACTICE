class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}    
    
public class P45_Merge_Sort_in_Linked_List {
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

    public static Node findMid(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node merge(Node left, Node right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        Node ans = new Node(-1);
        Node temp = ans;

        while(left != null && right != null){
            if(left.data < right.data){
                temp.next = left;
                temp = left;
                left = left.next;
            }
            else{
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }

        while(left != null){
            temp.next = left;
            temp = left;
            left = left.next;
        }

        while(right != null){
            temp.next = right;
            temp = right;
            right = right.next;
        }

        ans = ans.next;

        return ans;
    }  

    public static Node mergeSort(Node head){
        // Base Case
        if(head == null || head.next == null){
            return head;
        }

        // Break LL into two halves, after finding mid
        Node mid = findMid(head);

        Node left = head;
        Node right = mid.next;

        mid.next = null;

        // Recursive calls to sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge both left and right halves
        Node result = merge(left, right);

        return result;

    }

    public static void main(String[] args) {
        Node head = new Node(9);

        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 3);

        printLL(head);

        head = mergeSort(head);

        printLL(head);
    }
}
