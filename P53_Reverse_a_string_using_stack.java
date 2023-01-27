import java.util.Stack;

public class P53_Reverse_a_string_using_stack {
    
    public static void main(String[] args) {

        // Time complexity O(n) || Space complexity O(n)
        
        Stack<Character> stack = new Stack<>();

        String str = "HELLO";

        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
        }

        String reversedStr = "";

        for(int i=0; i<str.length(); i++){
            reversedStr += stack.pop();
        }

        System.out.println("Original string :- " + str);
        System.out.println("Reversed string :- " + reversedStr);
    }
}
