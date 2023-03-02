import java.util.ArrayDeque;

public class P91_Sum_of_minimum_and_maximum_elements_of_all_subarrays_of_size_k {
    
    public static int solve(int arr[], int n, int k){
        ArrayDeque<Integer> maxi = new ArrayDeque<>();
        ArrayDeque<Integer> mini = new ArrayDeque<>();
        int ans = 0;

        // Addition of first k size window
        for(int i=0; i<k; i++){
            while(!maxi.isEmpty() && arr[maxi.peekLast()] <= arr[i]){
                maxi.removeLast();
            }
            while(!mini.isEmpty() && arr[mini.peekLast()] >= arr[i]){
                mini.removeLast();
            }

            maxi.addLast(i);
            mini.addLast(i);
        }

        for(int i=k; i<n; i++){
            ans += arr[maxi.peekFirst()] + arr[mini.peekFirst()];

            // Next window

            // Removal
            while(!maxi.isEmpty() && (i - maxi.peekFirst() >= k)){
                maxi.removeFirst();
            }
            while(!mini.isEmpty() && (i - mini.peekFirst() >= k)){
                mini.removeFirst();
            }

            // Addition
            while(!maxi.isEmpty() && arr[maxi.peekLast()] <= arr[i]){
                maxi.removeLast();
            }
            while(!mini.isEmpty() && arr[mini.peekLast()] >= arr[i]){
                mini.removeLast();
            }

            maxi.addLast(i);
            mini.addLast(i);
        }

        // Make sure to consider last window
        ans += arr[maxi.peekFirst()] + arr[mini.peekFirst()];

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {2,5,-1,7,-3,-1,-2};

        System.out.println(solve(arr, arr.length, 4));
    }
}
