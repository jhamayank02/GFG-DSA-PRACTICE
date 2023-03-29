class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P137_Lowest_Common_Ancestor_in_a_BST {

    Node LCA(Node root, int n1, int n2)
	{
        // Time complexity O(n) || Space complexity O(height)
        // if(root == null){
        //     return null;
        // }
        
        // if(root.data < n1 && root.data < n2){
        //     return LCA(root.right, n1, n2);
        // }
        
        // if(root.data > n1 && root.data > n2){
        //     return LCA(root.left, n1, n2);
        // }
        
        // return root;
        
        
        // Time complexity O(n) || Space complexity O(1)
        while(root != null){
            if(root.data < n1 && root.data < n2){
                root = root.right;
            }
            else if(root.data > n1 && root.data > n2){
                root = root.left;
            }
            else{
                return root;
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        
    }
}
