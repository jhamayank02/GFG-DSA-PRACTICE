import java.util.Stack;

// Time complexity - O(n) || Space complexity O(n)
public class P71_Valid_substring {

    static int findMaxLen(String S) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<S.length(); i++){

            char character = S.charAt(i);

            if(character == '('){
                st.push(i);
            }
            else{
                if(st.size() > 0 && S.charAt(st.peek()) == '('){
                    st.pop();
                }
                else{
                    st.push(i);
                }
            }
        }

        int maxLen = 0;
        int len = S.length();

        while(!st.empty()){
            int top = st.pop();
            maxLen = Math.max(maxLen, len-top-1);
            len = top;
        }

        return Math.max(maxLen, len);
    }

    public static void main(String[] args) {
        // String str = ")(";
        String str = "))()(()";

        System.out.println(findMaxLen(str));
    }
}
