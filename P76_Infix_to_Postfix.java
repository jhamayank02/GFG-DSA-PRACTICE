import java.util.HashMap;
import java.util.Stack;

public class P76_Infix_to_Postfix {
    public static String infixToPostfix(String exp) {
        // Precedence -> ^ > *,/ > +,-

        String ans = "";

        Stack<Character> st = new Stack<>();

        HashMap<Character, Integer> precedence = new HashMap<>();
        precedence.put('^', 3);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('+', 1);
        precedence.put('-', 1);

        for(int i=0; i<exp.length(); i++){

            char scanned_ch = exp.charAt(i);

            if(scanned_ch == '^' || scanned_ch == '*' || scanned_ch == '/' || scanned_ch == '-' || scanned_ch == '+'){

                // The scanned scanned_character and element at the top of the stack both are '^'
                if(!st.empty() && scanned_ch == '^' && st.peek() == '^'){
                    st.push(scanned_ch);
                }
                // Precedence of the scanned operator is greater than the operator at the top of the stack or the top of the stack is '('
                else if(!st.empty() && (st.peek() == '(' || (precedence.get(scanned_ch) > precedence.get(st.peek())))){
                    st.push(scanned_ch);
                }
                // Precedence of scanned operator is less than or equal to the operator at the top of the stack so pop out from the stack until a parenthesis appears or the operator at the stack top has less precedence than the scanned operator
                else{
                    while(!st.empty() && st.peek() != '(' && (precedence.get(scanned_ch) <= precedence.get(st.peek()))){
                        ans += st.pop();
                    }
                    st.push(scanned_ch);
                }
            
            }
            // A closing parenthesis ')'
            else if(scanned_ch == ')'){
                while(!st.empty() && st.peek() != '('){
                    ans += st.pop();
                }

                // This will remove '(' from the stack
                st.pop();
            }
            // A openining parenthesis '('
            else if(scanned_ch == '('){
                st.push(scanned_ch);
            }
            // A operand
            else{
                ans += scanned_ch;
            }

        }


        // At the end pop out all the elements from the stack add it to the output string
        while(!st.empty()){
            if(st.peek() == '('){
                st.pop();
                continue;
            }
            ans += st.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        // String str = "A*(B+C)/D";
        String str = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println(infixToPostfix(str));

    }
}
