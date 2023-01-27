import java.util.Stack;

public class P57_Reverse_stack_using_recursion {

    public static void insertAtBottom(Stack stack, int element){
        // Base case
        if(stack.empty()){
            stack.push(element);
            return;
        }

        int preserveVal = (Integer)stack.peek();
        stack.pop();

        insertAtBottom(stack, element);

        stack.push(preserveVal);
    }

    // Time complexity O(n^2)
    public static void reverse(Stack stack){
        // Base case
        if(stack.empty()){
            return;
        }

        int preserveVal = (Integer)stack.pop();

        // Recursive call
        reverse(stack);

        insertAtBottom(stack, preserveVal);

    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(7);
        stack.push(1);
        stack.push(4);
        stack.push(5);

        System.out.println("Orginal stack :- " + stack);

        reverse(stack);

        System.out.println("Reversed stack :- " + stack);
    }
}
