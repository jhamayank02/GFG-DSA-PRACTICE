import java.util.Stack;

import javax.imageio.plugins.tiff.TIFFImageReadParam;

public class P59_Redundant_brackets {

    // Time complexity O(n) || Space complexity O(n)
    public static boolean findRedundantBrackets(String s){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                st.push(ch);
            }
            else{
                // ch ya toh ')' hai or lowercase letter
                if(ch == ')'){

                    boolean isRedundant = true;
                    while(st.peek() != '('){
                        char top = st.peek();

                        if(top == '+' || top == '-' || top == '*' || top == '/'){
                            isRedundant = false;
                        }
                        st.pop();
                    }

                    if(isRedundant == true){
                        return true;
                    }
                    st.pop();

                }
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        String str = "(a + (b * c))";

        System.out.println(findRedundantBrackets(str));
    }
}
