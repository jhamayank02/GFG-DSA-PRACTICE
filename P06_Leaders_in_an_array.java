import java.util.ArrayList;

public class P06_Leaders_in_an_array {
    
    static void reverse(ArrayList<Integer> ans) {
         
        int j = 0;
        int k = ans.size()-1;

        while(j<k){
            int temp = ans.get(k);
            ans.set(k, ans.get(j));
            ans.set(j, temp);

            j++;
            k--;
        }

    }

    static ArrayList<Integer> leaders(int arr[], int n){

        ArrayList<Integer> ans = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for(int i = n-1; i >= 0 ; i--){

            if(arr[i] >= max){
                ans.add(arr[i]);
                max = arr[i];
            }

        }


        reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        // int n = 6;
        // int A[] = {16,17,4,3,5,2};

        int n = 5;
        int A[] = {1,2,3,4,0};

        ArrayList<Integer> ans = leaders(A, n);
        System.out.println("Result :- " + ans);
    }
}
