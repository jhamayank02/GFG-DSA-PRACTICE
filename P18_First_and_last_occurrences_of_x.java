import java.util.ArrayList;

public class P18_First_and_last_occurrences_of_x {
    
    public static ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        ArrayList<Long> ans = new ArrayList<>();

        long firstIndex = -1;
        long lastIndex = -1;

        for(int i=0; i<n; i++){

            if(arr[i] == x){

                if(firstIndex == -1){
                    firstIndex = lastIndex = i;
                }
                else{
                    lastIndex = i;
                }

            }

        }

        ans.add(firstIndex);
        ans.add(lastIndex);

        return ans;

    }

    public static void main(String[] args) {
        int n=9, x=5;
        long arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };

        ArrayList<Long> ans = find(arr, n, x);
        System.out.println(ans);
    }
}
