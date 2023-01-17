public class Circular_Doubly_LL {

    Node tail;
 
    static class Node{
        int data;
        Node prev;
        Node next;

        Node(int d){
            this.data = d;
            this.next = null;
            this.prev = null;
        }
    }

    public static void printList(Circular_Doubly_LL list){
        if(list.tail == null){
            System.out.println("List is empty!!!");
        }
        else{
            Node temp = list.tail.next;

            while(temp != list.tail){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.print(temp.data + "\n");
        }
    }

    public static Circular_Doubly_LL insertAtHead(Circular_Doubly_LL list, int data){
        Node new_node = new Node(data);

        if(list.tail == null){
            list.tail = new_node;
            list.tail.next = list.tail;
            list.tail.prev = list.tail;
        }

        else{
            new_node.next = list.tail.next;
            new_node.prev = list.tail;
            list.tail.next = new_node;
            new_node.next.prev = new_node;
        }

        return list;
    }

    public static Circular_Doubly_LL insertAtTail(Circular_Doubly_LL list, int data){
        Node new_node = new Node(data);

        if(list.tail == null){
            list.tail = new_node;
            list.tail.next = list.tail;
            list.tail.prev = list.tail;
        }

        else{
            new_node.next = list.tail.next;
            new_node.prev = list.tail;
            list.tail.next = new_node;
            list.tail = new_node;
        }

        return list;
    }

    public static Circular_Doubly_LL insertAtPosition(Circular_Doubly_LL list, int data, int pos){
        Node new_node = new Node(data);

        if(list.tail == null){
            list.tail = new_node;
            list.tail.next = list.tail;
            list.tail.prev = list.tail;
        }

        else{
            Node temp = list.tail.next;
            int curPos = 1;

            if(curPos == pos){
                new_node.next = temp;
                new_node.prev = temp.prev;
                temp.prev.next = new_node;
                temp.prev = new_node;

                return list;
            }

            // temp = temp.next;
            // curPos++;

            while(curPos < pos-1 && temp != list.tail.next){
                temp = temp.next;
                curPos++;
            }

            if(temp == list.tail.next){
                System.out.println("Given position doesn't exist in the list!!!");
                return list;
            }

            new_node.next = temp.next;
            new_node.prev = temp;
            temp.next.prev = new_node;
            temp.next = new_node;
        }

        return list;
    }

    public static Circular_Doubly_LL deleteFromHead(Circular_Doubly_LL list){
        if(list.tail == null){
            System.out.println("List is empty!!!");
        }
        else{
            Node head = list.tail.next;
            head.next.prev = head.prev;
            head.prev.next = head.next;
            list.tail = head.prev;
        }
        return list;
    }

    public static Circular_Doubly_LL deleteFromTail(Circular_Doubly_LL list){
        if(list.tail == null){
            System.out.println("List is empty!!!");
        }
        else{
            list.tail.next.prev = list.tail.prev;
            list.tail.prev.next = list.tail.next;
            list.tail = list.tail.prev;
        }
        return list;
    }

    public static Circular_Doubly_LL deleteFromPosition(Circular_Doubly_LL list, int pos){
        if(list.tail == null){
            System.out.println("List is empty!!!");
        }
        else{
            Node temp = list.tail.next;
            Node tail = list.tail;
            int curPos = 1;

            if(curPos == pos){
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
            }

            do{
                temp = temp.next;
                curPos++;
            }while(curPos < pos-1 && temp == list.tail.next);

            if(temp == list.tail.next){
                System.out.println("Given position doesn't exist in the list!!!");
                return list;
            }

            temp.next = temp.next.next;
            temp.next.prev = temp;
            list.tail = tail;
        }
        return list;
    }

    public static void main(String[] args) {

        Circular_Doubly_LL list = new Circular_Doubly_LL();

        printList(list);

        list = insertAtHead(list, 23);
        list = insertAtHead(list, 233);
        list = insertAtTail(list, 23453);
        list = insertAtPosition(list, 1, 2); // Not Working

        printList(list);

        list = deleteFromHead(list);
        list = deleteFromTail(list);
        list = deleteFromPosition(list, 1); // Not Working

        printList(list);
        
    }
}
