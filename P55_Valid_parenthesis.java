import java.util.Stack;

public class P55_Valid_parenthesis {

    // Time complexity O(n) || Space complexity O(n)
    public static boolean isValidParenthesis(String expression){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < expression.length(); i++){
            
            char character = expression.charAt(i);

            // If opening brackets, push into the stack
            if(character == '(' || character == '{' || character == '['){
                stack.push(character);
            }

            // If closing brackets, check and pop from the stack
            else{
                if(!stack.empty()){
                    char top = stack.peek();
                    
                    if(character == ')' && top == '(' ||
                       character == '}' && top == '{' ||
                       character == ']' && top == '['){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            
        }

        if(stack.empty()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void main(String[] args) {
        

        String expression = "([{(}])";

        System.out.println(isValidParenthesis(expression));
    }
}
