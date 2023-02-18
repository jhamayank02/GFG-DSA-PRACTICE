import java.util.Stack;

public class P70_Decode_the_string {

    static String decodedString(String s){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char currentChar = s.charAt(i);

            // if the current character is ], start decoding
            if(currentChar == ']'){

                String temp = "";

                // Pop from the stack till the [ occurs
                while(st.peek() != '['){
                    temp = st.pop() + temp;
                }

                // Remove the [
                st.pop();

                // Count is taken as string for numbers like 11, 121. As our stack stores the elements in the form of characters i.e. count = '1' + '1'
                String count = "";

                // Conacatenate with count until the next element is a integer and stack is not empty
                while(!st.empty() && Character.getNumericValue(st.peek()) >= 0 && Character.getNumericValue(st.peek()) <= 9){
                    count = st.pop() + count;
                }

                String temp2 = "";

                // Generate the string with repeations
                for(int j=0; j<Integer.parseInt(count); j++){
                    temp2 += temp; 
                }

                // Push all the elements back to the stack
                for(int j=0; j<temp2.length(); j++){
                    st.push(temp2.charAt(j));
                }

            }
            else{
                st.push(currentChar);
            }
        }

        String result = "";
        while(!st.empty()){
            result = st.pop() + result;
        }

        return result;
    }

    public static void main(String[] args) {
        // String str = "3[b2[ca]]";
        // String str = "3[a3[b]1[ab]]";
        String str = "11[geeks]";

        System.out.println(decodedString(str));
    }
}
