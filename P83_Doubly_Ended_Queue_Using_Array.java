class DoublyEndedQueue{
    int front, rear, size, arr[];

    DoublyEndedQueue(){
        rear = front = -1;
        size = 10;
        arr = new int[size];
    }

    DoublyEndedQueue(int s){
        rear = front = -1;
        size = s;
        arr = new int[size];
    }

    void push_front(int x){
        if((front == 0 && rear == size-1) && !(front != 0 && rear == (front-1)%size)){
            System.out.println("Queue Overflow!!!");
        }
        else if(front == -1){
            front = rear = 0;
        }
        else if(front == 0){
            front = size-1;
        }
        else{
            front--;
        }
        arr[front] = x;
    }

    void push_back(int x){
        if((front == 0 && rear == size-1) && !(front != 0 && rear == (front-1)%size)){
            System.out.println("Queue Overflow!!!");
        }
        else if(front == -1){
            front = rear = 0;
        }
        else if(front != 0 && rear != size-1){
            rear = 0;
        }
        else{
            rear++;
        }
        arr[rear] = x;
    }

    void pop_front(){
        if(front == -1){
            System.out.println("Queue Underflow!!!");
        }
        else if(front == rear){
            System.out.println("Popped " + arr[rear]);
            front = rear = -1;
        }
        else if(rear == 0){
                System.out.println("Popped " + arr[rear]);
                rear = size-1;
        }
        else{
            System.out.println("Popped " + arr[rear]);
            rear--;
        }
    }

    void pop_back(){
        if(front == -1){
            System.out.println("Queue Underflow!!!");
        }
        else if(front == rear){
            System.out.println("Popped " + arr[rear]);
            front = rear = -1;
        }
        else if(rear == 0){
            System.out.println("Popped " + arr[rear]);
            rear = size-1;
        }
        else{
            System.out.println("Popped " + arr[rear]);
            rear--;
        }
    }

    boolean isEmpty(){
        if(front == -1){
            return true;
        }
        else{
            return false;
        }
    }

    boolean isFull(){
        if((front == 0 && rear == size-1) && (front != 0 && rear == (front-1)%size)){
            return true;
        }
        else{
            return false;
        }
    }

    void printQueue(){
        if(front == -1){
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

public class P83_Doubly_Ended_Queue_Using_Array {
    public static void main(String[] args) {
        DoublyEndedQueue q = new DoublyEndedQueue(5);

        // Queue is empty
        // q.pop_front();
        // q.pop_back();

        q.push_front(1);
        // q.pop_back();
        // q.pop_front();
        q.push_back(3);
        q.push_front(2);
        q.printQueue();
    }
}
