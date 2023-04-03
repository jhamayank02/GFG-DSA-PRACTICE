import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

    
public class P141_Normal_BST_to_balanced_BST {
    // Time complexity O(n) || Space complexity O(height)
    public static void inOrderTraversal(Node root, ArrayList<Integer> inorder){
        // Base case
        if(root == null){
            return;
        }

        inOrderTraversal(root.left, inorder);
        inorder.add(root.data);
        inOrderTraversal(root.right, inorder);
    }

    public static Node solve(ArrayList<Integer> inorder, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = solve(inorder, start, mid-1);
        root.right = solve(inorder, mid+1, end);

        return root;
    }

    // Time complexity O(n) || Space complexity O(n)
    public static Node normalToBalancedBST(Node root){
        if(root == null){
            return null;
        }

        ArrayList<Integer> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);
        System.out.println(inorder);
        
        return solve(inorder, 0, inorder.size()-1);
    }
    
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.left.left = new Node(2);
        root.right = new Node(12);
        root.right.right = new Node(16);
        root.right.right.right = new Node(20);

        Node newRoot = normalToBalancedBST(root);
        ArrayList<Integer> ans = new ArrayList<>();
        inOrderTraversal(newRoot, ans);
        System.out.println(ans);
    }
}
