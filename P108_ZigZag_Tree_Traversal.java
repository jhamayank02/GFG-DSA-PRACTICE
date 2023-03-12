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

class pair {
    boolean first;
    int second;

    public pair(boolean first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class P108_ZigZag_Tree_Traversal {
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

    public static ArrayList<Integer> zigZagTraversal(Node root)
	{
        ArrayList<Integer> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            int ans[] = new int[size];

            // Level Process
            for(int i=0; i<size; i++){
                Node frontNode = q.poll();

                // Normal insert or Reverse insert
                int index = leftToRight ? i : size-i-1;
                ans[index] = frontNode.data;

                if(frontNode.left != null){
                    q.add(frontNode.left);
                }
                if(frontNode.right != null){
                    q.add(frontNode.right);
                }
            }

            // Change Direction
            leftToRight = !leftToRight;

            for(int element : ans){
                result.add(element);
            }
        }

        return result;
	}

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(zigZagTraversal(root));
    }

}
