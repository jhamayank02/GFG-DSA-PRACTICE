public class Circular_LL {

    Node tail; // No need to create head node as we can access first as well as last node using tail node
    
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public static void printList(Circular_LL list){
        if(list.tail == null){
            System.out.println("List is empty!!!");
        }
        else{
            Node temp = list.tail.next; // temp is pointing to the head of the list

            System.out.println("Printing the list:-");

            while(temp != list.tail){
                System.out.print(temp.data + " ");

                temp = temp.next;
            }

            System.out.print(temp.data);

            System.out.println();

        }
    }

    public static Circular_LL insertAtHead(Circular_LL list, int data){
        if(list.tail == null){
            Node new_node = new Node(data);

            list.tail = new_node;
            list.tail.next = list.tail;

        }

        else{
            Node new_node = new Node(data);

            new_node.next = list.tail.next;
            list.tail.next = new_node;

        }
        return list;
    }

    public static Circular_LL insertAtTail(Circular_LL list, int data){
        if(list.tail == null){
            Node new_node = new Node(data);

            list.tail = new_node;
            list.tail.next = list.tail;

        }

        else{
            Node new_node = new Node(data);

            new_node.next = list.tail.next;
            list.tail.next = new_node;
            list.tail = new_node;

        }
        return list;
    }

    public static Circular_LL insertAtPosition(Circular_LL list, int data, int pos){
        if(list.tail == null){
            Node new_node = new Node(data);

            list.tail = new_node;
            list.tail.next = list.tail;

        }

        else{
            Node new_node = new Node(data);

            int currentPos = 1;
            Node temp = list.tail.next; // Now temp is pointing to the head(starting) node of the list

            if(currentPos == pos){
                new_node.next = temp;
                list.tail.next = new_node;
                return list;
            }

            do{
                temp = temp.next;
                currentPos++;
            }while(currentPos < pos-1 && temp != list.tail);

            if(currentPos != pos-1 && temp == list.tail){
                System.out.println("Given position doesn't exist in the list!!!");
                return list;
            }

            new_node.next = temp.next;
            temp.next = new_node;

        }
        return list;
    }

    public static Circular_LL deleteFromHead(Circular_LL list){
        if(list.tail == null){
            System.out.println("List is empty!!!");
        }
        else{
            list.tail.next = list.tail.next.next;
        }

        return list;
    }

    public static Circular_LL deleteFromTail(Circular_LL list){
        if(list.tail == null){
            System.out.println("List is empty!!!");
        }
        else{
            Node temp = list.tail.next;

            while(temp.next != list.tail){
                temp = temp.next;
            }

            temp.next = list.tail.next;
            list.tail = temp;
        }

        return list;
    }

    public static Circular_LL deleteFromPosition(Circular_LL list, int pos){
        if(list.tail == null){
            System.out.println("List is empty!!!");
        }
        else{
            Node temp = list.tail.next;
            int currentPos = 1;

            if(currentPos == pos){
                list.tail = list.tail.next;
                return list;
            }

            do{
                temp = temp.next;
                currentPos++;
            }while(currentPos < pos && temp != list.tail);

            if(currentPos != pos-1 && temp == list.tail){
                System.out.println("Given position doesn't exist in the list!!!");
                return list;
            }

            if(temp.next == list.tail && currentPos == pos-1){
                list.tail = list.tail.next;
                return list;
            }

            temp.next = temp.next.next;

        }

        return list;
    }

    public static void main(String[] args) {
        
        Circular_LL list = new Circular_LL();

        printList(list);
        
        list = insertAtHead(list, 23);
        list = insertAtHead(list, 34);
        list = insertAtTail(list, 334);
        list = insertAtPosition(list, 33, 1);
        list = insertAtPosition(list, 33, 83);
        list = insertAtPosition(list, 33, 3);

        printList(list);

        // list = deleteFromHead(list);
        // list = deleteFromTail(list);
        // list = deleteFromPosition(list, 1);
        list = deleteFromPosition(list, 5); // Not Working
        // list = deleteFromPosition(list, 23);

        printList(list);


    }
}
