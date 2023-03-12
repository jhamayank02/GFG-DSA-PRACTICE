import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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

public class P110_Boundary_Traversal_of_binary_tree {
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

    public static void traverseLeft(Node root, ArrayList<Integer> ans) {
        if ((root == null) || (root.left == null && root.right == null)) {
            return;
        }

        ans.add(root.data);

        if (root.left != null) {
            traverseLeft(root.left, ans);
        } else if (root.right != null) {
            traverseLeft(root.right, ans);
        }

    }

    public static void traverseLeaf(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans.add(root.data);
        }

        traverseLeaf(root.left, ans);
        traverseLeaf(root.right, ans);
    }

    public static void traverseRight(Node root, ArrayList<Integer> ans) {
        if ((root == null) || (root.left == null && root.right == null)) {
            return;
        }

        if (root.right != null) {
            traverseRight(root.right, ans);
        } else {
            traverseRight(root.left, ans);
        }

        ans.add(root.data);
    }

    public static ArrayList<Integer> boundary(Node root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(root.data);

        // Left part print/store
        traverseLeft(root.left, ans);

        // Traverse leaf nodes
        // Left subtree
        traverseLeaf(root.left, ans);
        // Right subtree
        traverseLeaf(root.right, ans);

        // Traverse right part
        traverseRight(root.right, ans);

        return ans;
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(boundary(root));
    }
}
