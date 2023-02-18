import java.util.ArrayList;

public class P68_Level_order_traversal_in_spiral_form {
    // A Binary Tree node
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        

        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(7);
        root.left.right = new Node(6);

        root.right.left = new Node(5);
        root.right.right = new Node(4);

        System.out.println(findSpiral(root));
    }
}
