import javax.swing.text.Position;

class Singly_LL{

    Node head;
    Node tail;

    static class Node{
        int data;
        Node next;

        Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    public static void printList(Singly_LL list){
        if(list.head == null){
            System.out.println("List is empty!!!");
        }
        else{
            Node temp = list.head;

            System.out.println("Printing the list:-");

            while(temp != null){
                System.out.print(temp.data + " ");

                temp = temp.next;
            }

            System.out.println();

        }
    }

    public static Singly_LL insertAtHead(Singly_LL list, int d){

        Node new_node = new Node(d);

        // If new_node is null means no memory is available for new node creation
        if(new_node != null){

            // If head is null then it means the list is empty
            if(list.head == null){
                list.head = new_node;
                list.tail = new_node;
            }

            // Else make the new_node as the new head
            else{
                new_node.next = list.head;
                list.head = new_node;
            }
    
        }
        else{
            System.out.println("*****Stack Overflow*****");
        }

        return list;
    }

    public static Singly_LL insertAtTail(Singly_LL list, int d){

        Node new_node = new Node(d);

        // If new_node is null means no memory is available for new node creation
        if(new_node != null){

            // If head is null then it means the list is empty
            if(list.head == null){
                list.head = new_node;
            }

            // Else make the new_node as the new tail
            else{
                list.tail.next = new_node;
                list.tail = new_node;
            }
    
        }
        else{
            System.out.println("*****Stack Overflow*****");
        }

        return list;
    }

    public static Singly_LL insertAtPosition(Singly_LL list, int d, int pos){

        Node new_node = new Node(d);

        // If new_node is null means no memory is available for new node creation
        if(new_node != null){

            // If head is null then it means the list is empty
            if(list.head == null){
                list.head = new_node;
            }

            else{
                int index = 1;
                Node temp = list.head;

                while(index != pos-1 && temp != null){
                    temp = temp.next;
                    index++;
                }

                if(temp == null){
                    list.tail.next = new_node;
                    list.tail = new_node;
                    return list;
                }

                new_node.next = temp.next;
                temp.next = new_node;
            }
    
        }
        else{
            System.out.println("*****Stack Overflow*****");
        }

        return list;
    }




    public static Singly_LL deleteFromFront(Singly_LL list){

        if(list.head == null){
            System.out.println("List is empty!!!");
        }

        else{
            list.head = list.head.next;
        }

        return list;

    }

    public static Singly_LL deleteFromRear(Singly_LL list){

        if(list.head == null){
            System.out.println("List is empty!!!");
        }

        else{
            Node temp = list.head;

            while(temp.next != list.tail){
                temp = temp.next;
            }

            temp.next = null;
            list.tail = temp;

        }

        return list;

    }

    public static Singly_LL deleteFromPosition(Singly_LL list, int pos){

        if(list.head == null){
            System.out.println("List is empty!!!");
        }

        else{
            int index = 1;
            Node temp = list.head;

            // If the given position is 1
            if(index == pos){
                list.head = list.head.next;

                // if the list becomes empty means if there was only one element then make the tail null as well
                if(list.head == null){
                    list.tail = null;
                }

                return list;
            }

            while(index < pos-1 && temp != null){
                temp = temp.next;
                index++;
            }

            if(temp == null){
                return list;
            }

            temp.next = temp.next.next;

        }

        return list;

    }

    public static void main(String[] args) {
        
        Singly_LL list = new Singly_LL();

        printList(list);

        list = insertAtHead(list, 10);
        list = insertAtHead(list, 20);
        list = insertAtHead(list, 30);
        list = insertAtHead(list, 40);

        list = insertAtTail(list, 1);

        list = insertAtPosition(list, 100, 3);
        list = insertAtPosition(list, 109, 13);

        printList(list);

        list = deleteFromFront(list);
        list = deleteFromRear(list);
        list = deleteFromPosition(list, 3);
        list = deleteFromPosition(list, 30);
        list = deleteFromPosition(list, 1);

        printList(list);


    }

}