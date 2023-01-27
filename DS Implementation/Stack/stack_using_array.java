public class stack_using_array {
    
    public int arr[];
    public int top;
    public int capacity;

    stack_using_array(int size){
        arr = new int[size];
        this.capacity = size;
        top = -1;
    }

    public boolean isEmpty(){
        if(top == -1){
            System.out.println("Stack is empty!!!");
            return true;
        }
        else{
            System.out.println("Stack is not empty!!!");
            return false;
        }
    }

    public boolean isFull(){
        if(top == capacity-1){
            System.out.println("Stack is full!!!");
            return true;
        }
        else{
            System.out.println("Stack is not full!!!");
            return false;
        }
    }

    public void push(int data){
        if(isFull()){
            System.out.println("Stack Overflow!!!");
        }
        else{
            top++;
            arr[top] = data;
            System.out.println("Pushed " + data + " into the stack");
        }
    }

    void pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow!!!");
        }
        else{
            System.out.println("Popped " + arr[top] + " from the stack");
        }
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("Stack Underflow!!!");
        }
        else{
            int elem = arr[top];
            System.out.println(elem + " is present at the top");
        }
    }
    public static void main(String[] args) {
        stack_using_array s = new stack_using_array(2);

        s.isEmpty();
        s.isFull();

        s.push(2);
        s.push(3);
        s.push(45);

        s.pop();
        s.peek();
    }
}
