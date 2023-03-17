import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}
class pair{
    int a; // Max sum by including nodes at current level
    int b; // Max sum by excluding nodes at current level
    
    pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}

public class P120_Maximum_sum_of_Non_adjacent_nodes {
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

    public static pair solve(Node root){
        // Base case
        if(root == null){
            pair p = new pair(0,0);
            return p;
        }
        
        pair left = solve(root.left);
        pair right = solve(root.right);
        
        pair res = new pair(0,0);
        res.a = root.data + left.b + right.b;
        res.b = Math.max(left.a, left.b) + Math.max(right.a, right.b);
        
        return res;
    }
  
    // Time complexity O(n) || Space complexity O(height)
    public static int getMaxSum(Node root)
    {
        // add your code here
        pair ans = solve(root);
        return Math.max(ans.a, ans.b);
    }
    

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(getMaxSum(root));
    }
}
