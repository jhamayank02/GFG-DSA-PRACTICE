class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P148_Inorder_Successor_in_BST {
    public static Node solve(Node root, int k, Node succ){
        
        // Base case
        if(root.data == k){
            if(root.right == null){
                return succ;
            }
            else{
                // Find min value in the right subtree
                Node temp = root.right;
                
                while(temp.left != null){
                    temp = temp.left;
                }
                
                return temp;
            }
        }
        
        if(root.data > k){
            succ = root;
            return solve(root.left, k, succ);
        }
        else{
            return solve(root.right, k, succ);
        }
    }
    
    // Time complexity O(n) || Space complexity O(height)
	public Node inorderSuccessor(Node root,Node x)
    {
        Node succ = null;
        
        return solve(root, x.data, succ);
    }

    // Time complexity O(height) || Space complexity O(1)
    public Node inorderSuccessor2(Node root,Node x)
    {
        Node succ = null;
        
        // Successor lies in right subtree. Find right subtree's minimum value
        if(x.right != null){
            
            Node temp = x.right;
            
            while(temp.left != null){
                temp = temp.left;
            }
            
            succ = temp;
        }
        // Successor is one of the ancestor
        else{
            Node temp = root;
            
            while(temp != null && temp.data != x.data){
                if(temp.data < x.data){
                    temp = temp.right;
                }
                else{
                    succ = temp;
                    temp = temp.left;
                }
            }
        }
        
        return succ;
    }

    public static void main(String[] args) {
        
    }
}
