import java.util.Scanner;

class Node{
    int data;
    Node left, right;

    Node(int d){
        data = d;
        left = null;
        right = null;
    }
}

public class P103_Height_of_Binary_Tree {

    public static Node buildTree(Node root){
        System.out.print("Enter the data : ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        root = new Node(data);

        if(data == -1){
            return null;
        }

        System.out.print("\nEnter the data for inserting at the left of " + data + " ");
        root.left = buildTree(root.left);

        System.out.print("\nEnter the data for inserting at the right of " + data + " ");
        root.right = buildTree(root.right);

        return root;
    }
    
    // Time complexity O(n) || Space complexity O(height)
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

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(height(root));
    }
}
