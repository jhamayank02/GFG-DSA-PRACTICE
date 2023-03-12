import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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

public class P109_Reverse_level_order_traversal {
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

    // Time complexity O(n) || Space complexity O(n)
    public static ArrayList<Integer> reverseLevelOrderTraversal(Node root){
        // Base case
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();

        q.add(root);

        while(!q.isEmpty()){
            Node current = q.poll();

            st.push(current.data);

            if(current.right != null){
                q.add(current.right);
            }
            if(current.left != null){
                q.add(current.left);
            }
        }

        while(!st.empty()){
            ans.add(st.pop());
        }

        return ans;
    }

    public static void main(String[] args) {
        Node root = null;

        root = buildTree(root);
        System.out.println(reverseLevelOrderTraversal(root));
        
    }
}
