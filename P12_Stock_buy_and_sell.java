import java.util.ArrayList;

public class P12_Stock_buy_and_sell {

    //Function to find the days of buying and selling stock for max profit.
    public static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int buy = 0;
        int sell = 0;
        int flag = 0; 
        // flag = 0 -> The values are already added to the ans or we don't have to add it in ans
        // flag = 1 -> The values are not added to the ans so we have to add it to the ans

        for(int i = 1; i < n; i++){

            // Check if previous day's price is lower than today
            if(A[i-1] < A[i]){
                sell++;
                flag = 1; // Values of sell got changed so now we have to add it in the ans array at appropriate time
            }

            // buy != sell --> If buy == sell means buy on same day and sell on same day so there is no profit so we will not consider this
            // flag = 1 --> Means the value of buy and sell is not added to the ans array previously
            else if(buy != sell && flag == 1){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(0, buy);
                arr.add(1, sell);

                ans.add(arr);

                buy = sell = i; // set the value of buy and sell to the current position
                flag = 0; // As the current value of buy and sell is already added to the ans array so set the flag = 0
            }

            // Increase the buy and sell as no above condition is satisfied
            else{
                buy = sell = i;
            }

        }


        // Check for the last state of buy and sell as the for loop was terminated and last state of buy and sell was not checked
        if(buy != sell && flag == 1){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(0, buy);
            arr.add(1, sell);

            ans.add(arr);
        }

        return ans;
    }

    public static void main(String[] args) {
        // int N = 7;
        // int A[] = {100,180,260,310,40,535,695};  
        int N = 5;
        int A[] = {4,2,2,2,4};  

        System.out.println(stockBuySell(A, N));
    }
}
