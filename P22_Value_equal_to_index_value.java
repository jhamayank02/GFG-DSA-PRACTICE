import java.util.ArrayList;

public class P22_Value_equal_to_index_value {
    
    public static ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for(int i = 0; i<n; i++){

            if(arr[i] == i+1){
                ans.add(arr[i]);
            }

        }

        return ans;
    }


    public static void main(String[] args) {
        int N = 5;
        int Arr[] = {15, 2, 45, 12, 7};

        System.out.println(valueEqualToIndex(Arr, N));
    }
}
