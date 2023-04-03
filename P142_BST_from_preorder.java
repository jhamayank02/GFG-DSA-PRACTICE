import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P142_BST_from_preorder {

    public static int i = 0;
    
    // Time complexity O(n) || Space complexity O(height)
    public static Node bstFromPreorder(ArrayList<Integer> preorder){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return solve(preorder, min, max);
    }

    // Time complexity O(n) || Space complexity O(height)
    public static Node solve(ArrayList<Integer> preorder, int min, int max){
        if(i >= preorder.size()){
            return null;
        }
        if(preorder.get(i) < min || preorder.get(i) > max){
            return null;
        }

        Node root = new Node(preorder.get(i));
        i++;
        root.left = solve(preorder, min, root.data);
        root.right = solve(preorder, root.data, max);

        return root;
    }

    public static void inOrderTraversal(Node root){
        // Base case
        if(root == null){
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        ArrayList<Integer> preorder = new ArrayList<>();
        preorder.add(20);
        preorder.add(10);
        preorder.add(5);
        preorder.add(15);
        preorder.add(13);
        preorder.add(35);
        preorder.add(30);
        preorder.add(40);

        Node root = bstFromPreorder(preorder);
        inOrderTraversal(root);
    }
}
