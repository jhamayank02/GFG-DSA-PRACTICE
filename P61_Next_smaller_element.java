import java.util.ArrayList;
import java.util.Stack;


public class P61_Next_smaller_element {
    
    public static int[] nextSmallerElement(ArrayList<Integer> arr){
        int ans[] = new int[arr.size()];

        Stack<Integer> s = new Stack<>();
        s.push(-1);

        for(int i=arr.size()-1; i>=0; i--){

            while(s.peek() >= arr.get(i)){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(arr.get(i));

        }
    
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(4);
        arr.add(3);
        
        System.out.println(arr);

        
        int ans[] = nextSmallerElement(arr);
        
        System.out.print("Answer :- ");
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
