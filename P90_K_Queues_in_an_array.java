class KQueues{

    int freespot;
    int k;
    int size;
    int front[];
    int rear[];
    int next[];
    int arr[];

    KQueues(int size, int k){
        this.size = size;
        this.k = k;

        front = new int[k];
        rear = new int[k];
        arr = new int[size];
        next = new int[size];
        freespot = 0;

        for(int i=0; i<k; i++){
            front[i] = -1;
            rear[i] = -1;
        }

        for(int i=0; i<size-1; i++){
            next[i] = i+1;
        }
        next[size-1] = -1;
    }

    void enqueue(int data, int q){

        // Overflow check
        if(freespot == -1){
            System.out.println("Queue Overflow!!!");
            return;
        }

        // Find first free index
        int index = freespot;
        // Update freespot
        freespot = next[index];

        // Check whether first element
        if(front[q-1] == -1){
            front[q-1] = index;
            next[index] = -1;
            rear[q-1] = index;
            arr[index] = data;
        }
        else{
            // Link new element to the previous element
            next[rear[q-1]] = index;
            next[index] = -1;
            rear[q-1] = index;
            arr[index] = data;
        }
    }

    void dequeue(int q){
        // Check Underflow
        if(front[q-1] == -1){
            System.out.println("Queue Underflow!!!");
            return;
        }

        // Find index to pop
        int index = front[q-1];
        // Move front ahead
        front[q-1] = next[index];

        // Manage freespots
        next[index] = freespot;
        freespot = index;

        System.out.println("Dequeued " + arr[index]);

    }

}

class P90_K_Queues_in_an_array{

    public static void main(String[] args) {
        KQueues q = new KQueues(10, 3);

        q.enqueue(10, 1);
        q.enqueue(15, 1);
        q.enqueue(20, 2);
        q.enqueue(25, 1);

        q.dequeue(1);
        q.dequeue(2);
        q.dequeue(2);
    }
}