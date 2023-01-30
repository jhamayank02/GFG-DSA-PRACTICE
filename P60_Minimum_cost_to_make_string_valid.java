import java.util.Stack;

public class P60_Minimum_cost_to_make_string_valid {

    public static int findMinCost(String str){

        // Odd condition
        if(str.length() % 2 != 0){
            return -1;
        }

        // Even condition
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '{'){
                s.push(ch);
            }
            else{
                // ch is closed brace
                if(!s.empty() && s.peek() == '{'){
                    s.pop();
                }
                else{
                    s.push(ch);
                }
            }
        }

        // Stack contains invalid expression
        int a = 0;
        int b = 0;

        while(!s.empty()){
            if(s.peek() == '{'){
                b++;
            }
            else{
                a++;
            }

            s.pop();
        }

        int ans = (a+1)/2 + (b+1)/2;
        return ans;

    }

    public static void main(String[] args) {
        String str = "{{}}}";

        System.out.println(findMinCost(str));
    }
}
