import java.util.Stack;

class P69_Reverse_each_word_in_a_given_string {
    
    public static String reverseWords(String S)
    {
        // Approach 1: Time complexity O(n) || Space complexity O(n)
        // Stack<Character> st = new Stack<>();
        // String ans = "";
        
        // // For n-1 words
        // for(int i=0; i<S.length(); i++){
        //     // If . occurs pop from the stack till the stack is empty and add the characters to the ans string
        //     if(S.charAt(i) == '.'){
                
        //         while(!st.empty()){
        //             ans += st.pop();
        //         }
        //         ans += '.';
                
        //     }
        //     // Push the characters in the stack
        //     else{
        //         st.push(S.charAt(i));
        //     }
        // }
        
        // // For the last nth word
        // while(!st.empty()){
        //     ans += st.pop();
        // }

        // return ans;



        // Approach 2: Time complexity O(n) || Space complexity O(1)
        String ans = "";
        String temp = "";

        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '.'){
                temp = reverse(temp);
                ans += temp + '.';
                temp = "";
            }
            else{
                temp += S.charAt(i);
            }
        }

        ans += reverse(temp);

        return ans;
    }    
    
    public static String reverse(String str){ 
        String ans = "";
        for(int i=str.length()-1; i>=0; i--){
            ans += str.charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "i.like.this.program.very.much";

        System.out.println(reverseWords(str));
    }
}
