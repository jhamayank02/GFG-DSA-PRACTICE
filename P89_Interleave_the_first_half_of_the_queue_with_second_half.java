import java.util.ArrayDeque;
import java.util.Stack;

public class P89_Interleave_the_first_half_of_the_queue_with_second_half {
 
    static void interleave(ArrayDeque<Integer> q){
        // Approach 1: Using Queue || Time complexity O(n) || Space complexity O(n)
        // ArrayDeque<Integer> newQ = new ArrayDeque<>();
        // int size = q.size();

        // for(int i=0; i<size/2; i++){
        //     newQ.add(q.peekFirst());
        //     q.removeFirst();
        // }

        // while(!newQ.isEmpty()){
        //     q.addLast(newQ.peekFirst());
        //     newQ.removeFirst();
        //     q.addLast(q.peekFirst());
        //     q.removeFirst();
        // }

        // Approach 2: Using Stack || Time complexity O(n) || Space complexity O(n)
        Stack<Integer> st = new Stack<>();
        int size = q.size();

        for(int i=0; i<size/2; i++){
            st.push(q.peekFirst());
            q.removeFirst();
        }

        while(!st.empty()){
            q.addLast(st.pop());
        }

        for(int i=0; i<size/2; i++){
            int val = q.removeFirst();
            q.addLast(val);
        }

        for(int i=0; i<size/2; i++){
            st.push(q.peekFirst());
            q.removeFirst();
        }

        while(!st.empty()){
            q.addLast(st.pop());
            q.addLast(q.peekFirst());
            q.removeFirst();
        }
    }
    
    public static void main(String[] args) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        // ArrayDeque<Integer> q = new ArrayDeque<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        
        System.out.println(q);

        interleave(q);

        System.out.println(q);
    }
}
