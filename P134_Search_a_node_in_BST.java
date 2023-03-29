class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P134_Search_a_node_in_BST {
    
    public static boolean search(Node root, int x) {
        // Recursive way
        // Time complexity -> Average case O(logn)/O(height) || Worst case O(n) || Space complexity O(height)
        // Base case
        // if(root == null){
        //     return false;
        // }
        // if(root.data == x){
        //     return true;
        // }
        
        // if(x < root.data){
        //     return search(root.left, x);
        // }
        // else{
        //     return search(root.right, x);
        // }
        
        
        // Iterative way
        // Average case O(logn)/O(height) || Worst case O(n) || Space complexity O(1)
        Node temp = root;
        
        while(temp != null){
            if(temp.data == x){
                return true;
            }
            else if(temp.data < x){
                temp = temp.right;
            }
            else{
                temp = temp.left;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        
    }
}
