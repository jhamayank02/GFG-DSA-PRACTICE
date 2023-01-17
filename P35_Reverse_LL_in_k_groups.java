// class Node {
//     int data;
//     Node next;

//     Node(int d) {
//         this.data = d;
//         this.next = null;
//     }
// }

// public class P35_Reverse_LL_in_k_groups {

//     public static void printLL(Node head) {
//         if (head == null) {
//             System.out.println("Linked list is empty!!!");
//         } else {
//             Node temp = head;

//             System.out.print("List:- ");
//             while (temp != null) {
//                 System.out.print(temp.data + " ");
//                 temp = temp.next;
//             }
//             System.out.println();
//         }
//     }

//     public static Node insertAtHead(Node head, int data) {
//         if (head == null) {
//             Node new_node = new Node(data);
//             head = new_node;
//         } else {
//             Node new_node = new Node(data);

//             new_node.next = head;
//             head = new_node;
//         }

//         return head;
//     }

//     public static Node reverse(Node prev, Node current, Node next, int k){

//         int count = 0;

//         while(count != k && next != current){

//             current.next = prev;
//             prev = current;
//             current = next;
//             if(next.next != null){
//                 next = next.next;
//             }

//             count++;
//         }

//         head.next

//         return prev;
//     }

//     public static Node reverse_K_grp(Node head, int k){
//         if(head == null || head.next == null){
//             return head;
//         }

//         Node 
        
//         return head;
//     }

//     public static void main(String[] args) {
//         Node head = new Node(4);

//         head = insertAtHead(head, 12);
//         head = insertAtHead(head, 834);
//         head = insertAtHead(head, 45);

//         printLL(head);

//     }
// }
