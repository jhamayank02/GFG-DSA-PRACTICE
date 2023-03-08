class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}

public class P93_Implement_Queue_using_Linked_List {
    static QueueNode front, rear;
    
    //Function to push an element into the queue.
	static void push(int a)
	{
        // Your code here

        // For first node
        if(front == null){
            QueueNode newNode = new QueueNode(a);
            front = newNode;
            rear = newNode;
            return;
        }

        QueueNode newNode = new QueueNode(a);
        rear.next = newNode;
        rear = newNode;
	}
	
    //Function to pop front element from the queue.
	static int pop()
	{
        // Your code here
        int val = -1;

        // If queue is empty
        if(front == null){
            return val;
        }

        val = front.data;
        front = front.next;

        // If there was only one node
        if(front == null){
            rear = null;
        }
        return val;
	}

    public static void main(String[] args) {
        QueueNode q = new QueueNode(2);
        push(3);
        System.out.println(pop());
        push(4);
        System.out.println(pop());
    }
}
