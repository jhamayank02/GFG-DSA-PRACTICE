import java.util.Stack;

public class P75_Evaluation_of_Postfix_Expression {

    // Time complexity O(n) || Space complexity O(n)
    public static int evaluatePostFix(String S)
    {
        
        Stack<String> st = new Stack<>();

        for(int i=0; i<S.length(); i++){

            String ch = String.valueOf(S.charAt(i));

            // If the character is +,-,/,* then pop two elements from the stack and perform the operation specified by the character
            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")){

                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());

                int val;

                switch (ch) {
                    case "+":
                        val = a + b;
                        break;
                    case "-":
                        val = a - b;
                        break;
                    case "*":
                        val = a * b;
                        break;
                
                    default:
                        val = a / b;
                        break;
                }
                
                st.push(String.valueOf(val));
            }
            // If the character is any number then push it to the stack
            else{
                st.push(ch);
            }
        }
        
        int ans = 0;
        // Pop the remaining one element from the stack that is our answer
        ans = Integer.parseInt(st.pop());

        return ans;
    }

    public static void main(String[] args) {
        // String S = "231*+9-";
        String S = "123+*8-";

        System.out.println(evaluatePostFix(S));
    }
}
