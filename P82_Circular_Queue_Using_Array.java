class CircularQueue{
    int front, rear;
    int arr[];
    int size;

    CircularQueue(){
        rear = -1;
        front = -1;

        arr = new int[10];
        size = 10;
    }

    CircularQueue(int s){
        rear = -1;
        front = -1;

        size = s;
        arr = new int[size];
    }

    // Time complexity O(1) || Space complexity O(1)
    boolean isEmpty(){
        if(front == -1){
            return true;
        }
        else{
            return false;
        }
    }

    // Time complexity O(1) || Space complexity O(1)
    boolean isFull(){
        if((rear == size-1 && front == 0) || (rear == (front-1)%size)){
            return true;
        }
        else{
            return false;
        }
    }

    // Time complexity O(1) || Space complexity O(1)
    void push(int x){
        if(!isFull()){
            // First element to insert
            if(front == -1){
                rear = 0;
                front = 0;
                arr[rear] = x;
            }
            else if(rear == size - 1 && front != 0){
                rear = 0;
            }
            else{
                rear++;
            }
            arr[rear] = x;
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
            // Queue has only one element
            if(front == rear){
                front = -1;
                rear = -1;
            }
            else if(front == size-1){
                front = 0;
            }
            else{
                front++;
            }
        }
    }

    // Time complexity O(1) || Space complexity O(1)
    void printQueue(){
        if(isEmpty()){
            System.out.println("Queue Underflow!!!");
            return;
        }

        System.out.print("Queue :- ");
        int i = front;

        do{
            System.out.print(arr[i] + " ");
            i = (i+1)%size;
        }while(i != front);
        System.out.println();
    }
}

public class P82_Circular_Queue_Using_Array {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(6);
        q.push(7);
        q.push(8);
        q.push(9);
        q.push(10);
        q.pop();
        q.push(10);
        System.out.println(q.isFull());
        q.push(10);
        System.out.println(q.isFull());
        q.push(10);
        System.out.println(q.isFull());

        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        System.out.println(q.front);
        System.out.println(q.rear);
        q.pop();

        q.printQueue();
    }
}
