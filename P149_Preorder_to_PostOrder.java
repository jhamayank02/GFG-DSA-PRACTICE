class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d;
    }
}

public class P149_Preorder_to_PostOrder {

    static int index;

    public static Node solve(int pre[], int size, int min, int max) {

        if (index >= size) {
            return null;
        }

        Node root = null;

        if (pre[index] > min && pre[index] < max) {
            root = new Node(pre[index]);
            index++;

            root.left = solve(pre, pre.length, min, root.data);
            root.right = solve(pre, pre.length, root.data, max);
        }

        return root;
    }

    // Time complexity O(n) || Space complexity O(n)
    public static Node post_order(int pre[], int size) {
        index = 0;

        Node root = new Node(pre[index]);
        index++;

        root.left = solve(pre, pre.length, Integer.MIN_VALUE, root.data);
        root.right = solve(pre, pre.length, root.data, Integer.MAX_VALUE);

        return root;

    }

    public static void postOrderTraversal(Node root) {
        // Base case
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int pre[] = { 40, 30, 35, 80, 100 };

        Node root = post_order(pre, 5);

        postOrderTraversal(root);
    }
}
