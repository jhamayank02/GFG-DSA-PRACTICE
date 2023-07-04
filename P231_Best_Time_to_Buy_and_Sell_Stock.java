import java.util.*;

class P231_Best_Time_to_Buy_and_Sell_Stock{

    // Time complexity O(n) || Space complexity O(1)
    public static int maximumProfit(ArrayList<Integer> prices){
        int n = prices.size();
        int profit = 0;
        int mini = prices.get(0);

        for(int i=1; i<n; i++){
            int cost = prices.get(i) - mini;
            profit = Math.max(cost, profit);

            mini = Math.min(mini, prices.get(i));
        }

        return profit;
    }

    public static void main(String args[]){

    }
}