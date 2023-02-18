import java.util.Stack;

public class P73_Sort_a_stack {
    
    // Time Complexity O(n^n) || Space Complexity O(n)
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

        // Time Complexity O(n^n) || Space Complexity O(1)
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

        System.out.println(sort(s));
    }
}
