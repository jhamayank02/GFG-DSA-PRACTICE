import java.util.Stack;

public class P58_Sort_a_stack {

    public static void sort(Stack stack){
        // Base case
        if(stack.empty()){
            return;
        }

        int preserveVal = (Integer)stack.pop();

        // Recursive call
        sort(stack);

        sortedInsert(stack, preserveVal);
    }

    public static void sortedInsert(Stack stack, int element){
        // Base case
        if(stack.empty() || (Integer)stack.peek() <= element){
            stack.push(element);
            return;
        }

        int preserveVal = (Integer)stack.pop();

        sortedInsert(stack, element);

        // Recursive call
        stack.push(preserveVal);
        
    }
    

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(-2);
        stack.push(9);
        stack.push(-7);
        stack.push(3);

        System.out.println("Stack before sorting :- " + stack);

        sort(stack);

        System.out.println("Stack after sorting :- " + stack);
    }
}
