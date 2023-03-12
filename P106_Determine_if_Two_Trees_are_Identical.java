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

public class P106_Determine_if_Two_Trees_are_Identical {
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

    public static boolean isIdentical(Node root1, Node root2) {
        // Code Here
        if (root1 == null && root2 == null) {
            return true;
        } else if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        if (root1.data == root2.data) {
            boolean left = isIdentical(root1.left, root2.left);
            boolean right = isIdentical(root1.right, root2.right);
            return left && right;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Node root1 = null;
        root1 = buildTree(root1);

        Node root2 = null;
        root2 = buildTree(root2);

        System.out.println(isIdentical(root1, root2));
    }
}
