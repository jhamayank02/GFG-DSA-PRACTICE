import java.util.Stack;

public class P54_Delete_middle_element_of_stack {

    public static void deleteMid(Stack s, int count, int size){
        // Base case
        if(count == size/2){
            s.pop();
            return;
        }

        int preserveVal = (Integer)s.pop();

        deleteMid(s, count+1, size);

        s.push(preserveVal);
    }
    
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        System.out.println(stack);

        deleteMid(stack, 0, stack.size());

        System.out.println(stack);
    }
}
