import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

public class P104_Diameter_of_a_Binary_Tree {

    public static Node buildTree(Node root) {
        System.out.print("Enter the data : ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        root = new Node(data);

        if (data == -1) {
            return null;
        }

        System.out.print("\nEnter the data for inserting at the left of " + data + " ");
        root.left = buildTree(root.left);

        System.out.print("\nEnter the data for inserting at the right of " + data + " ");
        root.right = buildTree(root.right);

        return root;
    }

    public static int height(Node node) 
    {
        // Base case
        if(node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameter(Node root) {
        // Time complexity O(n^2)
        // Base case
        // if(root == null){
        //     return 0;
        // }

        // int op1 = diameter(root.left);
        // int op2 = diameter(root.right);
        // int op3 = height(root.left) + 1 + height(root.right);

        // int ans = Math.max(op1, Math.max(op2, op3));
        // return ans;



        // Time complexity O(n) || Space complexity O(height)
        return (int) diameterFast(root).first;
    }

    // pair.first = diameter and pair.second = height
    public static pair diameterFast(Node root){
        // Base case
        if(root == null){
            pair p = new pair(0, 0);
            return p;
        }

        pair left = diameterFast(root.left);
        pair right = diameterFast(root.right);

        int op1 = (int) left.first;
        int op2 = (int) right.first;
        int op3 = (int) (left.second + right.second + 1);

        pair ans = new pair(0, 0);
        ans.first = Math.max(op1, Math.max(op2, op3));
        ans.second = Math.max(left.second, right.second) + 1;
        return ans;
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(diameter(root));
    }
}
