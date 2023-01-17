public class Doubly_LL {

    Node head;

    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int d){
            this.data = d;
            this.prev = null;
            this.next = null;
        }
    }

    public static void printList(Doubly_LL list){
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
    

    public static Doubly_LL insertAtHead(Doubly_LL list, int data){
        Node new_node = new Node(data);

        if(list.head == null){
            list.head = new_node;
        }
        else{
            new_node.next = list.head;
            list.head.prev = new_node;
            list.head = new_node;
        }

        return list;
    }

    public static Doubly_LL insertAtTail(Doubly_LL list, int data){
        Node new_node = new Node(data);

        if(list.head == null){
            list.head = new_node;
        }
        else{
            Node temp = list.head;

            while(temp.next != null){
                temp = temp.next;
            }

            temp.next = new_node;
            new_node.prev = temp;

            return list;
        }

        return list;
    }

    public static Doubly_LL insertAtPosition(Doubly_LL list, int data, int pos){
        Node new_node = new Node(data);

        if(list.head == null){
            list.head = new_node;
        }

        else{
            Node temp = list.head;
            int currentPos = 1;

            if(currentPos == pos){
                new_node.next = list.head;
                list.head.prev = new_node;
                list.head = new_node;
                return list;
            }

            while(currentPos < pos-1 && temp.next != null){
                temp = temp.next;
                currentPos++;
            }

            if(temp.next == null){
                temp.next = new_node;
                new_node.prev = temp;
                return list;
            }

            new_node.next = temp.next;
            new_node.prev = temp;
            temp.next = new_node;
            new_node.next.prev = new_node;

        }
        return list;
    }

    public static Doubly_LL deleteFromHead(Doubly_LL list){
        if(list.head == null){
            return list;
        }
        
        Node temp = list.head;

        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;

        return list;
    }

    public static Doubly_LL deleteFromTail(Doubly_LL list){
        if(list.head == null){
            return list;
        }
        
        list.head = list.head.next;
        list.head.prev = null;

        return list;
    }

    public static Doubly_LL deleteFromPosition(Doubly_LL list, int pos){
        if(list.head == null){
            return list;
        }
        
        Node temp = list.head;
        int currentPos = 1;

        if(currentPos == pos){
            list.head = null;
            return list;
        }

        while(currentPos < pos-1 && temp.next != null){
            temp = temp.next;
            currentPos++;
        }

        if(temp.next == null && currentPos != pos-1){
            System.out.println("Given position doesn't exist in the list!!!");
            return list;
        }

        temp.next.next.prev = temp;
        temp.next = temp.next.next;

        return list;
    }

    public static void main(String[] args) {

        Doubly_LL list = new Doubly_LL();

        printList(list);
        list = insertAtHead(list, 23);
        list = insertAtHead(list, 27);

        printList(list);
        
        list = insertAtTail(list, 73);
        list = insertAtTail(list, 743);
        
        printList(list);

        list = insertAtPosition(list, 22, 1);
        list = insertAtPosition(list, 22, 3);
        list = insertAtPosition(list, 22, 89);
        printList(list);

        list = deleteFromHead(list);
        list = deleteFromTail(list);
        list = deleteFromPosition(list, 21);

        printList(list);
        
    }
}
