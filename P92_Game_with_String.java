import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class P92_Game_with_String {
    static int minValue(String s, int k){

        // Time complexity O(n) + O(log(n)) = O(n) || Space complexity O(n)

        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        // Store count of all characters
        // Time complexity O(n)
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch, 1);
            }
        }

        // Add frequencies of all characters in priority queue
        // Time complexity O(log(n))
        for(Integer val : map.values()){
            pQueue.add(val);
        }
        
        // Subtract 1, k times from the front of the priority queue i.e. the largest element and push it back
        // Time complexity O(log(n))
        while(k>0){
            int top = pQueue.peek();
            pQueue.poll();
            top--;
            k--;
            pQueue.add(top);
        }
        
        // Now find the sum of squares of frequencies of all distinct characters
        // Time complexity O(log(n))
        int sum = 0;
        while(!pQueue.isEmpty()){
            int val = pQueue.peek();
            pQueue.poll();
            sum += val*val;
        }

        return sum;
    }
    public static void main(String[] args) {
        // String s = "aabcbcbcabcc";
        // int k = 3;
        // String s = "abccc";
        // int k = 1;
        String s = "fxnsmkasmlerxxoxhfwviluzttqqotdwrsqfcsxrddicaxahewemjyleudukxzgqrzvvrtmvwvxzuxiyvnngna";
        int k = 21;

        System.out.println(minValue(s, k));
    }
}
