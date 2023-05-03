import java.util.ArrayList;
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
    public int compare(Node n1, Node n2) {
        if (n1.data > n2.data)
            return 1;
        else if (n1.data < n2.data)
            return -1;
        return 0;
        }
}

public class P161_Merge_k_Sorted_Arrays {


//Function to merge k sorted arrays.
// Time complexity O(k^2*logk) || Space complexity O(k^2)
public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
{
    PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
    
    // Step 1: Insert first element of all subarrays
    // Time complexity O(klogk) || Space complexity O(k)
    for(int i=0; i<K; i++){
        Node temp = new Node(arr[i][0], i, 0);
        pq.add(temp);
    }
    
    
    // Step 2:
    // Time complexity O(k^2logk) || Space complexity O(k^2)
    ArrayList<Integer> ans = new ArrayList<>();
    
    while(!pq.isEmpty()){
        Node temp = pq.peek();
        ans.add(temp.data);
        pq.poll();
        
        int row = temp.row;
        int col = temp.col;
        
        if(col + 1 < arr[row].length){
            Node next = new Node(arr[row][col+1], row, col+1);
            pq.add(next);
        }
    }
    
    return ans;
    }
    
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(mergeKArrays(arr, 3));
    }
}
