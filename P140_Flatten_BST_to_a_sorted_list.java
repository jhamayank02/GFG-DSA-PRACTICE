import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P140_Flatten_BST_to_a_sorted_list {

    // Time complexity O(n) || Space complexity O(height)
    public static void inOrderTraversal(Node root, ArrayList<Node> inorder){
        // Base case
        if(root == null){
            return;
        }
    
        inOrderTraversal(root.left, inorder);
        inorder.add(root);
        inOrderTraversal(root.right, inorder);
    }

    // Time complexity O(n) || Space complexity O(n)
    public static Node flattenBST(Node root){
        if(root == null){
            return null;
        }

        ArrayList<Node> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);

        for(int i=0; i<inorder.size()-2; i++){
            Node temp = inorder.get(i);
            temp.left = null;
            temp.right = inorder.get(i+1);
        }

        // For last element
        Node last = inorder.get(inorder.size()-1);
        last.left = null;
        last.right = null;

        return inorder.get(0);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(8);
        root.right.left = new Node(11);
        root.right.right = new Node(15);

        Node newRoot = flattenBST(root);
        while(newRoot != null){
            System.out.print(newRoot.data + " ");
            newRoot = newRoot.right;
        }
    }
}
