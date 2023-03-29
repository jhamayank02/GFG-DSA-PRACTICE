class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P133_Flatten_binary_tree_to_linked_list {
    
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
    
    // Time complexity O(n) || Space complexity O(1)
    public static void flatten(Node root)
    {
        Node current = root;
        
        while(current != null){
            if(current.left != null){
                Node prev = findPredecessor(current);
                prev.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            
            current = current.right;
        }
    }
    public static void main(String[] args) {
        
    }
}
