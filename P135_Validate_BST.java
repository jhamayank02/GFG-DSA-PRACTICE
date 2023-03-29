class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P135_Validate_BST {
    
    public static boolean isBST(Node root, int minVal, int maxVal){

        if(root == null){
            return true;
        }

        if(root.data >= minVal && root.data <= maxVal){
            boolean left = isBST(root.left, minVal, root.data);
            boolean right = isBST(root.right, root.data, maxVal);
            return left && right;
        }
        else{
            return false;
        }
    }

    // Time complexity O(n) || Space complexity O(height)
    public static boolean validateBST(Node root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(100);
        root.left.right = new Node(3);

        System.out.println(validateBST(root));
    }
}
