public class P157_Is_Binary_Tree_Heap {
    
    // Time complexity O(n) || Space complexity O(height)
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        
        int ans = 1 + countNodes(root.left) + countNodes(root.right);
        
        return ans;
    }
    
    // Time complexity O(n) || Space complexity O(height)
    public static boolean isCBT(Node root, int i, int total){
        if(root == null){
            return true;
        }
        if(i >= total){
            return false;
        }
        
        return isCBT(root.left, 2*i+1, total) && isCBT(root.right, 2*i+2, total);
    }
    
    // Time complexity O(n) || Space complexity O(height)
    public static boolean isMaxOrder(Node root){
        // Leaf node
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        
        // Only left child
        if(root.right == null){
            return root.data > root.left.data;
        }
        // Two child
        else{
            return (root.data > root.left.data) && (root.data > root.right.data) && isMaxOrder(root.left) && isMaxOrder(root.right);
        }
    }
    
    // Time complexity O(n) || Space complexity O(height)
    public static boolean isHeap(Node tree) {
        int nodeCount = countNodes(tree);
        return isCBT(tree, 0, nodeCount) && isMaxOrder(tree);
    }

    public static void main(String[] args) {
        
    }
}
