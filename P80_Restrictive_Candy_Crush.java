import java.util.Stack;

public class P80_Restrictive_Candy_Crush {
    // public static String reduced_String(int k, String s)
    // {
    //     // Your code goes here
    //     String ans = "";
    //     Stack<Character> st = new Stack<>();

    //     for(int i=0; i<s.length(); i++){
    //         char ch = s.charAt(i);
    //         st.push(ch);
    //     }

    //     while(!st.empty()){
    //         int count = 1;

    //         char ch = st.pop();
    //         ans = ch + ans;

    //         // Remove chars

    //         while(!st.empty() && st.peek() == ch && count < k){
    //             ans = ch + ans;
    //             st.pop();
    //             count++;
    //         }

    //         // Identical char group found
    //         if(count == k){
    //             ans = ans.substring(k, ans.length());

    //             for(int i=0; i<ans.length(); i++){
    //                 st.push(ans.charAt(i));
    //             }
    //             ans = ""; 
    //         }

    //         if(st.empty()){
    //             return ans;
    //         }
    //     }

    //     return ans;
    // }
    public static String reduced_String(int k, String s)
    {
        // Your code goes here
        String ans = "";
        Stack<Character> st = new Stack<>();

        if(k == 1 || s.length() == 0 || s.length() < k){
            return s;
        }


        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);
            if(st.empty()){
                st.push(ch);
                // ans = ch + ans;
                ans += ch;
                // System.out.println(ans);
            }
            else{
                int count = 1;
                while(!st.empty() && ch == st.peek() && count <= k){
                    st.pop();
                    count++;
                    ans = ans.substring(0, ans.length()-1);
                }

                if(count < k){
                    while(count > 0){
                        st.push(ch);
                        // ans = ch + ans;
                        ans += ch;
                        count--;
                    }
                }
                // System.out.println(ans);
            }
        }

        // int s = 0;
        // int e = ans.length() - 1;

        // while(s<e){
        //     char temp = ans.charAt(e)
        // }


        return ans;
    }

    public static void main(String[] args) {
        int k = 2;
        // String s = "geeksforgeeks";
        // String s = "geegsforgeeks";
        String s = "geegsforgeegs";

        System.out.println(reduced_String(k, s));
    }
}