import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class P84_Queue_Reversal {

    public static void solve(Queue<Integer> q){
        // Base Case
        if(q.size() <= 1){
            return;
        }

        int element = q.peek();
        q.remove();

        solve(q);

        q.add(element);
    }
    
    public static Queue<Integer> rev(Queue<Integer> q){
        // Approach 1: Using stack || Time complexity O(n) || Space complexity O(n)
        // if(q.size() == 0){
        //     return q;
        // }

        // Stack<Integer> st = new Stack<>();

        // while(!q.isEmpty()){
        //     int element = q.peek();
        //     q.remove();
        //     st.push(element);
        // }

        // while(!st.empty()){
        //     int element = st.peek();
        //     st.pop();
        //     q.add(element);
        // }

        // return q;



        // Approach 1: Using Recursion || Time complexity O(n) || Space complexity O(n)
        if(q.size() <= 1){
            return q;
        }

        int element = q.peek();
        q.remove();

        rev(q);

        q.add(element);

        return q;
    }
    
    public static void main(String[] args) {
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();

        q.add(4);
        q.add(3);
        q.add(1);
        q.add(10);
        q.add(12);
        q.add(6);

        System.out.println("Queue :- " + q);
        rev(q);
        System.out.println("Queue :- " + q);
    }
}
