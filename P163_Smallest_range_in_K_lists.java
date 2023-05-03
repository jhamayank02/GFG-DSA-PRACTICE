import java.util.Comparator;
import java.util.PriorityQueue;

class Node{
    int data;
    int row;
    int col;
    
    Node(int data, int row, int col){
        this.data = data;
        this.row = row;
        this.col = col;
    }
}

class NodeComparator implements Comparator<Node>{
             
    // Overriding compare()method of Comparator
        // for descending order of cgpa
    public int compare(Node n1, Node n2) {
        if (n1.data > n2.data)
            return 1;
        else if (n1.data < n2.data)
            return -1;
        return 0;
    }
}

public class P163_Smallest_range_in_K_lists {

    // Time complexity O(n*klogk) || Space complexity O(k)
    static int[] findSmallestRange(int[][] KSortedArray,int n,int k)
	{
	    int mini = Integer.MAX_VALUE;
	    int maxi = Integer.MIN_VALUE;
	    PriorityQueue<Node> minHeap = new PriorityQueue<>(new NodeComparator());
	    
	    // Step 1: Create a min heap for starting element of each list and tracking mini and maxi values
	    for(int i=0; i<k; i++){
	        int element = KSortedArray[i][0];
	        maxi = Math.max(maxi, element);
	        mini = Math.min(mini, element);
	        minHeap.add(new Node(element, i, 0));
	    }
	    
	    int start = mini, end = maxi;
	    
	    // Process ranges
	    while(!minHeap.isEmpty()){
	        
	        // Fetch mini
	        Node temp = minHeap.peek();
	        mini = temp.data;
	        minHeap.poll();
	        
	        // Range or answer update
	        if(maxi - mini < end - start){
	            start = mini;
	            end = maxi;
	        }
	    
	    
	        // Next element exists
	        if(temp.col < n-1){
	            maxi = Math.max(maxi, KSortedArray[temp.row][temp.col+1]);
	            minHeap.add(new Node(KSortedArray[temp.row][temp.col+1], temp.row, temp.col+1));
	        }
	        // Next element does not exist
	        else{
	            break;
	        }
	    }
	    
	    int ans[] = {start, end};
	    
	    return ans;
	}

    public static void main(String[] args) {
        
    }
}
