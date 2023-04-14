import java.util.Comparator;
import java.util.PriorityQueue;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
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

public class P162_Merge_K_sorted_linked_lists {
    // Time complexity O(n*klogk) || Space complexity O(k)
    Node mergeKList(Node[]arr,int K)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        
        int n = arr.length;
        
        if(n == 0){
            return null;
        }
        
        // Time complexity O(klogk) || Space complexity O(k)
        for(int i=0; i<n; i++){
            if(arr[i] != null){
                pq.add(arr[i]);
            }
        }
        
        Node head = null;
        Node tail = null;
        
        // Time complexity O(n*klogk) || Space complexity O(k)
        while(pq.size() > 0){
            Node top = pq.peek();
            pq.poll();
            
            if(top.next != null){
                pq.add(top.next);
            }
            
            if(head == null){
                head = top;
                tail = top;
            }
            else{
                tail.next = top;
                tail = tail.next;
            }
        }
        
        return head;
    }

    public static void main(String[] args) {
        
    }
}
