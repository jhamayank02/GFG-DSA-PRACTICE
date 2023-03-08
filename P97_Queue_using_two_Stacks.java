import java.util.Stack;

public class P97_Queue_using_two_Stacks {
    
    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    // Time complexity O(1) || Space complexity O(1)
    static void Push(int x)
    {
	   // Your code here
       s1.push(x);
    }
	
    
    //Function to pop an element from queue by using 2 stacks.
    // Time complexity O(n) || Space complexity O(1)
    static int Pop()
    {
	   // Your code here
       if(s1.empty()){
            return -1;
       }

       while(!s1.empty()){
            s2.push(s1.pop());
       }

       int val = s2.pop();

       while(!s2.empty()){
            s1.push(s2.pop());
       }

       return val;
    }


    public static void main(String[] args) {
        P97_Queue_using_two_Stacks q = new P97_Queue_using_two_Stacks();

        q.Push(2);
        q.Push(3);
        
        System.out.println(q.Pop());
        
        q.Push(4);
        
        System.out.println(q.Pop());
    }
}
