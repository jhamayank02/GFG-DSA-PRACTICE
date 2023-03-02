import java.util.ArrayDeque;

public class P87_First_non_repeating_character_in_a_stream {
    public static String FirstNonRepeating(String A)
    {
        // code here
        int count[] = new int[26];
        String ans = "";
        ArrayDeque<Character> q = new ArrayDeque<>();

        
        for(int i=0; i<A.length(); i++){
            int index = A.charAt(i) - 'a';

            // Increase count of the character
            count[index] = count[index] + 1;

            // Push the character in the queue
            q.addLast(A.charAt(i));

            while(!q.isEmpty()){
                // Repeating character
                if(count[q.peekFirst() - 'a'] > 1){
                    q.removeFirst();
                }
                // Non-repeating character
                else{
                    ans += q.peekFirst();
                    break;
                }
            }

            if(q.isEmpty()){
                ans += '#';
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        String A = "aabc";
        System.out.println(FirstNonRepeating(A));
    }
}
