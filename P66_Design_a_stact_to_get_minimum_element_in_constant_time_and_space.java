import java.util.Stack;

public class P66_Design_a_stact_to_get_minimum_element_in_constant_time_and_space {
    
    // Time complexity O(1) || Space complexity O(1)
    static Stack<Integer> s = new Stack<>();
    static int mini = Integer.MAX_VALUE;

    public static void push(int data){
        // For first element
        if(s.empty()){
            s.push(data);
            mini = data;
        }
        else{
            if(data<mini){
                int val = 2 * data - mini;
                s.push(val);
                mini = data;
            }
            else{
                s.push(data);
            }
        }

    }

    public static int pop(){
        // Check underflow condition
        if(s.empty()){
            return -1;
        }
        
        int curr = s.pop();

        if(curr>mini){
            return curr;
        }
        else{
            int prevMin = mini;
            int val = 2*mini - curr;
            mini = val;
            return prevMin;
        }
    }

    public static int top(){
        if(s.empty()){
            return -1;
        }

        int curr = s.peek();

        if(curr<mini){
            return mini;
        }
        else{
            return curr;
        }
    }

    public static boolean isEmpty(){
        return s.empty();
    }

    public static int min(){
        if(s.empty()){
            return -1;
        }
        else{
            return mini;
        }
    }

    public static void main(String[] args) {
        P66_Design_a_stact_to_get_minimum_element_in_constant_time_and_space s = new P66_Design_a_stact_to_get_minimum_element_in_constant_time_and_space();
        
        s.push(5);
        System.out.println(min());

        s.push(3);
        s.push(8);
        System.out.println(min());

        s.push(2);
        s.push(4);

        System.out.println(min());

        s.pop();
        s.pop();

        System.out.println(min());
    }
}
