import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class P164_Find_median_in_a_stream {

    public static int signum(int a, int b){
        if(a == b){
            return 0;
        }
        else if(a > b){
            return 1;
        }
        else{
            return -1;
        }
    }

    public static int getMedian(int element, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int median){
        switch(signum(maxHeap.size(), minHeap.size())){
            case 0: if(element > median){
                        minHeap.add(element);
                        median = minHeap.peek();
                    }
                    else{
                        maxHeap.add(element);
                        median = maxHeap.peek();
                    }
                    break;

            case 1: if(element > median){
                        minHeap.add(element);
                        median = (minHeap.peek() + maxHeap.peek()) / 2;
                    }
                    else{
                        minHeap.add(maxHeap.peek());
                        maxHeap.poll();
                        maxHeap.add(element);
                        median = (minHeap.peek() + maxHeap.peek()) / 2;
                    }
                    break;

            case -1: if(element > median){
                        maxHeap.add(minHeap.peek());
                        minHeap.poll();
                        minHeap.add(element);
                        median = (minHeap.peek() + maxHeap.peek()) / 2;
                    }
                    else{
                        maxHeap.add(element);
                        median = (minHeap.peek() + maxHeap.peek()) / 2;
                    }
                    break;
        }

        return median;
    }
    
    // Time complexity O(nlogn) || Space complexity O(n)
    public static ArrayList<Integer> findMedian(ArrayList<Integer> arr, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int median = 0;

        for(int i=0; i<n; i++){
            median = getMedian(arr.get(i), maxHeap, minHeap, median);
            ans.add(median);
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(4);

        System.out.println(findMedian(arr, arr.size()));
    }
}
