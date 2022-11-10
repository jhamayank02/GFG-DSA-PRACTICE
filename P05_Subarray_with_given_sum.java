import java.util.ArrayList;

public class P05_Subarray_with_given_sum {
    
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here

        // ArrayList<Integer> ans = new ArrayList<>();


        // METHOD - 1 -> Time Complexity O(N^2)

        // int current_sum = 0, i = 0, j = 0;

        // for(i = 0; i < n; i++){

        //     current_sum += arr[i];
            
        //     for(j = i+1; j< n; j++){
        //         System.out.println("sum " + current_sum);

        //         if(current_sum == s){
        //             ans.add(i+1);
        //             ans.add(j);
        //             return ans;
        //         }
                
        //         current_sum += arr[j];
        //     }

        //     if(current_sum == s){
        //         ans.add(i+1);
        //         ans.add(j);
        //         return ans;
        //     }

        //     current_sum = 0;
        //     ans.clear();
        // }
        
        // ans.add(-1);
        // return ans;




        // METHOD - 2 -> EFFICIENT WAY Time Complexity O(N)

        int left = 0, right = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int current_sum = arr[left];

        while(right < n){

            if(current_sum > s){
                current_sum -= arr[left];
                left++;
            }
            else if(current_sum == s){
                ans.add(left+1);
                ans.add(right+1);
                return ans;
            }
            else{
                right++;
                current_sum += arr[right];
            }

        }

    
        // ans.clear();
        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        // int N = 5, S = 12;
        // int A[] = {1,2,3,7,5};
        // int A[] = {1,2,3,4,12};

        int N = 10, S = 15;
        int A[] = {1,2,3,4,5,6,7,8,9,10};

        ArrayList<Integer> ans = subarraySum(A, N, S);
        System.out.println("Printing the result:- " + ans);
    }
}
