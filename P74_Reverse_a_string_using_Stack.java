import java.util.Stack;

public class P74_Reverse_a_string_using_Stack {
    public static String reverse(String S){
        //code here

        Stack<Character> st = new Stack<>();

        for(int i=0; i<S.length(); i++){
            st.push(S.charAt(i));
        }

        S = "";

        while(!st.empty()){
            S += st.pop();
        }

        return S;
    }

    public static void main(String[] args) {
        String S="GeeksforGeeks";

        System.out.println(reverse(S));
    }
}
