import java.util.*;

public class P170_Find_All_Four_Sum_Numbers {
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // Approach 1: Using sorting and 2 loops and 2 pointer approach
        // Time complexity O(n^3) || Space complexity O(1)
        Arrays.sort(arr);
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            // skip the duplicates:
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for(int j=i+1; j<n; j++){
                // skip the duplicates:
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int m = j+1;
                int p = n-1;
                
                while(m < p){
                    int sum = arr[i] + arr[j] + arr[m] + arr[p];
                    
                    if(sum < k){
                        m++;
                    }
                    else if(sum > k){
                        p--;
                    }
                    else{
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[m]);
                        temp.add(arr[p]);
                        
                        ans.add(temp);
                        
                        
                        m++;
                        p--;
                        
                        // skip the duplicates:
                        while (m < p && arr[m] == arr[m - 1]) m++;
                        while (m < p && arr[p] == arr[p + 1]) p--;
                    }
                }
                
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        HashSet<ArrayList<Integer>> arr = new HashSet<>();

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(2);
        temp.add(3);

        ArrayList<Integer> temp2 = new ArrayList<>();
        temp2.add(2);
        temp2.add(3);

        arr.add(temp);
        arr.add(temp2);

        System.out.println(arr);
    }
}
