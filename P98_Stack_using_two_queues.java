import java.util.LinkedList;
import java.util.Queue;

public class P98_Stack_using_two_queues {
    
    static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    // Time complexity O(1) || Space complexity O(1)
    static void push(int a)
    {
	    // Your code here
        q1.add(a);
    }
    
    //Function to pop an element from stack using two queues. 
    // Time complexity O(n) || Space complexity O(1)
    static int pop()
    {
	    // Your code here
        if(q1.isEmpty()){
            return -1;
        }

        while(!q1.isEmpty() && q1.size()>1){
            q2.add(q1.poll());
        }
        
        int val = q1.poll();

        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }

        return val;
    }
	
    public static void main(String[] args) {
        P98_Stack_using_two_queues st = new P98_Stack_using_two_queues();
        st.push(2);
        st.push(3);
        System.out.println(st.pop());
        // st.pop();
        st.push(4);
        System.out.println(st.pop());
        // st.pop();
    }
}
