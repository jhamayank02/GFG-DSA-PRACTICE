import java.util.Stack;
import java.lang.Math;

public class P78_Count_the_Reversals {
    static int countRev (String s)
    {
        // Approach 1: Using Stack || Time complexity O(n)  || Space complexity O(n)
        // Stack<Character> st = new Stack<>();
        
        // // Odd condition
        // if(s.length()%2 != 0){
        //     return -1;
        // }

        // // Even condition
        // else{

        //     // Remove valid part from the string
        //     for(int i=0; i<s.length(); i++){
        //         char ch = s.charAt(i);

        //         if(ch == '{'){
        //             st.push(ch);
        //         }
        //         else{
        //             if(!st.empty() && st.peek() == '{'){
        //                 st.pop();
        //             }
        //             else{
        //                 st.push(ch);
        //             }
        //         }
        //     }

        //     // Now at this point the stack contains the invalid part of the string
        //     int a = 0; // Count of the closed brace
        //     int b = 0; // Count of the open brace

        //     while(!st.empty()){
        //         char ch = st.pop();

        //         if(ch == '{'){
        //             b++;
        //         }
        //         else{
        //             a++;
        //         }
        //     }


        //     int ans = ((a+1)/2) + ((b+1)/2);
        //     return ans;
        // }


        // Approach 2: Time complexity O(n) || Space complexity O(1)
        
        // If string length is odd
        if(s.length()%2 != 0){
            return -1;
        }

        // If string length is even

        int open = 0, close = 0, reversals = 0;

        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) == '{'){
                open++;
            }
            else{
                if(open == 0){
                    close++;
                }
                else{
                    open--;
                }
            }
        }

        reversals = (int)(Math.ceil(open/2.0) + Math.ceil(close/2.0));

        return reversals;
    }

    public static void main(String[] args) {
        String S = "}{{}}{{{";
        // String S = "{{}{{{}{{}}{{";

        System.out.println(countRev(S));
    }
}
