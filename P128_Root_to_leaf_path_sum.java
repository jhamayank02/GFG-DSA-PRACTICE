class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class P128_Root_to_leaf_path_sum {
    public static boolean solve(Node root, int s, int totalSum){
        if(root == null){
            return false;
        }
        
        totalSum += root.data;
        
        if(root != null && root.left == null && root.right == null){
            if(s == totalSum){
                return true;
            }
            return false;
        }
        
        boolean left = solve(root.left, s, totalSum);
        boolean right = solve(root.right, s, totalSum);
        
        return left || right;
    }
    
    /*you are required to complete this function */
    public static boolean hasPathSum(Node root, int S) {
        // Your code here
        return solve(root, S, 0);
    }

    public static void main(String[] args) {
        
    }
}
