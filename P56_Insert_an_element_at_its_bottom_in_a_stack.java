import java.util.Stack;

class P56_Insert_an_element_at_its_bottom_in_a_stack{

    public static void insert(Stack stack, int element){
        // Base case
        if(stack.empty()){
            stack.push(element);
            return;
        }

        int preserveVal = (Integer)stack.peek();
        stack.pop();

        insert(stack, element);

        stack.push(preserveVal);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(7);
        stack.push(1);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack before insertion :- " + stack);

        insert(stack, 9);

        System.out.println("Stack after insertion :- " + stack);
    }
}