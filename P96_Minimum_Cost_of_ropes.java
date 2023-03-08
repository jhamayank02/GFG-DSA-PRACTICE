import java.util.PriorityQueue;

public class P96_Minimum_Cost_of_ropes {
    static long minCost(long arr[], int n) 
    {
        // Time complexity O(nlog(n)) || Space complexity O(n)
        long totalCost = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        // T.C O(nlog(n))
        for(int i=0; i<n; i++){
            pq.add(arr[i]);
        }

        // T.C O(log(n))
        while(pq.size() > 1){
            long a = pq.poll();
            long b = pq.poll();

            long cost = a + b;
            totalCost += cost;

            pq.add(cost);
        }

        System.out.println(pq);

        return totalCost;
    }
    
    public static void main(String[] args) {
        // int n = 4;
        // long arr[] = {4, 3, 2, 6};
        int n = 5;
        long arr[] = {4, 2, 7, 6, 9};

        System.out.println(minCost(arr, n));
    }
}
