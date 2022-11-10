import java.util.ArrayList;
import java.util.Arrays;

public class P07_Find_duplicates_in_an_array {
    
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here

        // Method - 1
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(arr); // Time Complexity - O(nlogn)
        int lastAdded = -1;

        for(int i = 1; i < n; i++){ // Time Complexity - O(n)

            if(arr[i] == arr[i-1] && arr[i] != lastAdded){
                ans.add(arr[i]);
                lastAdded = arr[i];
            }

        }

        if(ans.size() == 0){
            ans.add(-1);
        }
        return ans;

        // Resultant Time Complexitty = O(nlogn) + O(n) = O(nlogn)
    }

    public static void main(String[] args) {
        
        int N = 4;
        int a[] = {23,23, 9, 9};

        ArrayList<Integer> ans = duplicates(a, N);
        System.out.println("Result :- " + ans);
    }
}
