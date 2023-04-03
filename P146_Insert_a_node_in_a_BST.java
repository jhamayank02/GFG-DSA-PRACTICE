class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}


public class P146_Insert_a_node_in_a_BST {

    public static Node solve(Node root, int key){
        if(root == null){
            Node newNode = new Node(key);
            return newNode;
        }
        
        if(root.data == key){
            return root;
        }
        else if(root.data > key){
            root.left = solve(root.left, key);
            return root;
        }
        else{
            root.right = solve(root.right, key);
            return root;
        }
    }
    
    // Time complexity O(height) || Space complexity O(height)
    public static Node insert(Node root, int Key) {
        
        solve(root, Key);
        
        return root;
    }

    public static void main(String[] args) {
        
    }
}
