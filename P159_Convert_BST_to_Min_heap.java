import java.util.ArrayList;

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
    }
}

public class P159_Convert_BST_to_Min_heap {

    public static void inorderTraversal(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        inorderTraversal(root.left, inorder);
        inorder.add(root.data);
        inorderTraversal(root.right, inorder);
    }

    public static void preorderTraversal(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    static int index = 0;

    public static void solve(Node root, ArrayList<Integer> inorder){
        if(root == null || index >= inorder.size()){
            return;
        }

        root.data = inorder.get(index);
        index++;

        solve(root.left, inorder);
        solve(root.right, inorder);
    }

    // Time complexity O(n) || Space complexity O(n)
    public static void bstToMinHeap(Node root){

        ArrayList<Integer> inorder = new ArrayList<>();

        // T.C O(n) || S.C O(height)
        inorderTraversal(root, inorder);

        // T.C O(n) || S.C O(height)
        solve(root, inorder);
    }
    
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.left = new Node(5);
        root.right.right = new Node(7);

        System.out.print("BST :- ");
        preorderTraversal(root);

        bstToMinHeap(root);

        System.out.print("\nMin Heap :- ");
        preorderTraversal(root);
    }
}
