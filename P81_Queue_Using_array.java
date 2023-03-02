class Queue{

    int front, rear;
    int arr[];
    int size;

    Queue(){
        rear = 0;
        front = 0;

        arr = new int[10];
        size = 10;
    }

    Queue(int s){
        rear = 0;
        front = 0;

        size = s;
        arr = new int[size];
    }

    // Time complexity O(1) || Space complexity O(1)
    boolean isEmpty(){
        if(front == rear){
            front = 0;
            rear = 0;
            return true;
        }
        else{
            return false;
        }
    }

    // Time complexity O(1) || Space complexity O(1)
    boolean isFull(){
        if(rear == size && front == 0){
            return true;
        }
        else{
            return false;
        }
    }

    // Time complexity O(1) || Space complexity O(1)
    void push(int x){
        if(!isFull()){
            arr[rear] = x;
            rear++;
        }
        else{
            System.out.println("Queue Overflow!!!");
        }
    }

    // Time complexity O(1) || Space complexity O(1)
    void pop(){
        if(isEmpty()){
            System.out.println("Queue Underflow!!!");
        }
        else{
            arr[front] = -1; // -1 represents a empty block in the array
            front++;
        }
    }

    // Time complexity O(1) || Space complexity O(1)
    void printQueue(){
        System.out.print("Queue :- ");
        for(int i=front ; i<rear; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}

public class P81_Queue_Using_array {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.push(1);
        q.push(2);
        q.push(2);
        q.push(2);
        q.push(2);
        q.push(2);
        q.push(2);
        q.push(2);
        q.push(2);
        q.push(2);
        q.push(45);

        q.pop();

        q.printQueue();
    }
}
