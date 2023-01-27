class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class stack_using_linked_list {
    
    Node top;

    public void push(int data){
        if(top == null){
            top = new Node(data);
        }
        else{
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }
    }

    public void pop(){
        if(top == null){
            System.out.println("Stack Underflow!!!");
        }
        else{
            top = top.next;
        }
    }

    public void peek(){
        if(top == null){
            System.out.println("Stack Underflow!!!");
        }
        else{
            System.out.println(top.data + " is present at the top of the stack");
        }
    }

    public void print(){
        if(top == null){
            System.out.println("Stack Underflow!!!");
        }
        else{
            Node temp = top;

            System.out.print("Stack :- ");

            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
       stack_using_linked_list s = new stack_using_linked_list();

       s.pop();
       s.push(34); 
       s.push(338); 
       s.push(87); 
       s.push(348); 
       s.push(95); 
       s.pop();

       s.print();
    }
}
