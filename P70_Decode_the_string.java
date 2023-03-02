import java.util.Stack;

public class P70_Decode_the_string {

    static String decodedString(String s){
        Stack<String> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        String result = new String();

        // Put all the characters in the strStack and digits in the integer stack
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch - '0' >= 0 && ch - '0' <= 9){
                intStack.push(ch-'0');

                // if(i<s.length()-1 && s.charAt(i+1) - '0' >= 0 && s.charAt(i+1) - '0' <= 9){
                //      String prevDigit = String.valueOf(intStack.pop() + s.charAt(i+1));
                //      intStack.push(prevDigit)
                // }
            }
            else{
                strStack.push(ch+"");
            }
        }

        System.out.println(strStack);
        System.out.println(intStack);



        String temp = "";

        while(!strStack.empty() && !intStack.empty()){

            String ch = strStack.pop();

            if(ch.equals("]")){
                // Discard it
            }
            else if(ch.equals("[")){
                int count = intStack.pop();

                String temp2 = "";

                for(int i=0; i<count; i++){
                    temp2 += temp;
                }

                if(intStack.empty()){
                    result = temp2;
                    return result;
                }

                strStack.push(temp2);
                temp = "";
            }
            else{
                temp = ch + temp;
            }

        }



        return result;
    }

    public static void main(String[] args) {
        // String str = "3[b2[ca]]";
        String str = "3[a3[b]1[ab]]";
        // String str = "11[geeks]";

        System.out.println(decodedString(str));
        System.out.println(String.valueOf("a"));
        System.out.println(String.valueOf("1"));
    }
}
