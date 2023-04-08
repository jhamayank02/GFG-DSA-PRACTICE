import java.util.ArrayList;
import java.util.PriorityQueue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d;
    }
}

public class P152_Print_BST_elements_in_given_range {
 
    public static PriorityQueue<Integer> solve(Node root, PriorityQueue<Integer> pq, int min, int max){
        if(root == null){
            return pq;
        }
        
        if(root.data >= min && root.data <= max){
            pq.add(root.data);
        }
        
        if(root.data == min){
            solve(root.right, pq, min, max);
        }
        else if(root.data == max){
            solve(root.left, pq, min, max);
        }
        else{
            solve(root.right, pq, min, max);
            solve(root.left, pq, min, max);
        }
        
        return pq;
    }
    
    // Time complexity O(n) || Space complexity O(n)
	public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
	    ArrayList<Integer> ans = new ArrayList<>();
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    
	    solve(root, pq, low, high);
	    
	    while(!pq.isEmpty()){
	        ans.add(pq.poll());
	    }
	    
        return ans;
    }




    public static Node findPredecessor(Node root){
        if(root == null){
            return null;
        }

        Node pred = root.left;

        while(pred.right != null && pred.right != root){
            pred = pred.right;
        }

        return pred;
    }

    // Approach -> Using Morris inorder traversal || Time complexity O(n) || Space complexity O(1)
	public static ArrayList<Integer> printNearNodes2(Node root,int low,int high) {
	    ArrayList<Integer> ans = new ArrayList<>();
        
        Node current = root;

        while(current != null){

            if(current.left == null){
                if(current.data >= low && current.data <= high){
                    ans.add(current.data);
                }
                current = current.right;
            }
            else{
                Node predecessor = findPredecessor(current);

                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }
                else{
                    predecessor.right = null;
                    if(current.data >= low && current.data <= high){
                        ans.add(current.data);
                    }
                    current = current.right;
                }
            }
        }
        
        
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
