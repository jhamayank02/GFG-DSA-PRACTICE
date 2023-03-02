import java.util.ArrayDeque;
import java.util.Stack;

public class P86_Reverse_First_K_elements_of_Queue {
    public static ArrayDeque<Integer> modifyQueue(ArrayDeque<Integer> q, int k) {
        // add code here.
        // Time complexity O(n) || Space complexity O(k)
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<k; i++){
            st.push(q.removeFirst());
        }

        while(!st.isEmpty()){
            q.add(st.pop());
        }

        for(int i=0; i<q.size()-k; i++){
            int val = q.peekFirst();
            q.removeFirst();
            q.add(val);
        }

        return q;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        modifyQueue(q, 3);

        System.out.println(q);
    }
}
