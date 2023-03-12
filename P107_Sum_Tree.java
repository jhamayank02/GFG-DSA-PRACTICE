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

class pair {
    boolean first;
    int second;  

    public pair(boolean first, int second)  
    {  
        this.first = first;  
        this.second = second;  
    }
}

public class P107_Sum_Tree {
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

    public static pair isSumTreeFast(Node root) {
        // Base case
        if (root == null) {
            pair p = new pair(true, 0);
            return p;
        }
        
        // Leaf node
        if(root.left == null && root.right == null){
            pair p = new pair(true, root.data);
            return p;
        }

        pair leftAns = isSumTreeFast(root.left);
        pair rightAns = isSumTreeFast(root.right);

        int leftSum = leftAns.second;
        int rightSum = rightAns.second;

        boolean condition = (leftSum + rightSum == root.data);
        pair ans = new pair((leftAns.first && rightAns.first && condition), (leftSum + rightSum + root.data));

        return ans;
    }

    public static boolean isSumTree(Node root) {

        return isSumTreeFast(root).first;
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(isSumTree(root));
    }
}
