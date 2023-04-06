class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d;
    }
}

public class P151_Find_the_Closest_Element_in_BST {
    public static int solve(Node root, int k){
        
        if(root != null){
            if(root.data == k){
                return 0;
            }
            else if(k < root.data){
                return Math.min(solve(root.left, k), Math.abs(root.data-k));
            }
            else{
                return Math.min(solve(root.right, k), Math.abs(root.data-k));
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    // Time complexity O(height) || Space complexity O(height)
    static int minDiff(Node  root, int K){ 
        return solve(root, K);  
    } 

    public static void main(String[] args) {
        
    }
}
