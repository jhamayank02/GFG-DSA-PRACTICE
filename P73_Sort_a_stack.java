import java.util.Stack;

public class P73_Sort_a_stack {

    public static void sortedInsert(Stack<Integer> s, int x){
        if(s.empty() || s.peek() < x){
            s.push(x);
            return;
        }

        int val = s.pop();

        sortedInsert(s, x);

        s.push(val);
    }

    // Time complexity O(n^2) || Space complexity O()
    public static void sort2(Stack<Integer> s){
        if(s.empty()){
            return;
        }

        int val = s.pop();

        sort2(s);

        sortedInsert(s, val);
    }

    
    // Time Complexity O(n^2) || Space Complexity O(n)
    public static Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
        Stack<Integer> ans = new Stack<>();

        // Time Complexity O(1) || Space Complexity O(n)
        int arr[] = new int[s.size()];

        // Time Complexity O(n) || Space Complexity O(1)
        for(int i=0; i<arr.length; i++){
            arr[i] = s.pop();
        }

        // Time Complexity O(n^2) || Space Complexity O(1)
        for(int i=0; i<arr.length; i++){

            for(int j=0; j<arr.length-1; j++){

                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }

        }

        // Time Complexity O(n) || Space Complexity O(1)
        for(int i=arr.length-1; i>=0; i--){
            ans.push(arr[i]);
        }
        
        return ans;
	}

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(41);
        s.push(3);
        s.push(32);
        s.push(2);
        s.push(11);

        // System.out.println(sort(s));
        sort2(s);
        System.out.println(s);
    }
}
