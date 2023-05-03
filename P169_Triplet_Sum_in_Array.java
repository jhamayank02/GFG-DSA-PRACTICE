import java.util.*;

class P169_Triplet_Sum_in_Array{

    public static boolean find3Numbers(int A[], int n, int X) { 
        // Approach 1: Using sorting and after than fixed 1 element and use two pointer approach. Let us say we have fixed arr[i], start j = i+1 and k = n-1 and
        //  if sum > x -> k--
        //  else if sum < x -> j++
        //  else return true;

        // Time compexity O(n^2) || Space complexity O(1)
    //    Arrays.sort(A);
       
    //    for(int i=0; i<n; i++){
           
    //        int j = i+1;
    //        int k = n-1;
           
    //        while(j < k){
               
    //            int sum = A[i] + A[j] + A[k];
    //            if(sum > X){
    //                k--;
    //            }
    //            else if(sum < X){
    //                j++;
    //            }
    //            else{
    //                return true;
    //            } 
    //        }
    //    }
    
    //     return false;




    // Approach 2: Using Hashmap
    // Time complexity O(n^2) || Space complexity O(n)
    for(int i=0; i<n; i++){
        HashMap<Integer, Boolean> map = new HashMap<>();
        int req_sum = X - A[i];
        
        for(int j=i+1; j<n; j++){
            if(map.containsKey(req_sum - A[j])){
                return true;
            }
            else{
                map.put(A[j], true);
            }
        }
    }
    
    return false;
    }

    public static void main(String[] args){

    }
}