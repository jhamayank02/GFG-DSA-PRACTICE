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

public class P119_Kth_Ancestor_in_a_Tree {
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


    // To acheive pass by reference of k's value
    static int temp = 0;
    
    public static Node solve(Node root, int k, int node){
        // Base Case
        if(root == null){
            return null;
        }
        
        if(root.data == node){
            temp = k;
            temp--;
            return root;
        }
        
        Node leftAns = solve(root.left, k, node);
        Node rightAns = solve(root.right, k, node);
        
        if(leftAns != null && rightAns == null){
            
            if(temp <= 0){
                // Lock ans, so that we can not reach on this condition again
                temp = Integer.MAX_VALUE;
                return root;
            }
            
            --temp;
            return leftAns;
        }
        else if(leftAns == null && rightAns != null){
            
            if(temp <= 0){
                // Lock ans, so that we can not reach on this condition again
                temp = Integer.MAX_VALUE;
                return root;
            }
            --temp;
            
            return rightAns;
        }
        
        return null;
    }
    
    // Time complexity O(n) || Space complexity O(height)
    public static int kthAncestor(Node root, int k, int node)
    {
        Node ans = solve(root, k, node);
        
        // ans.data == node -> Means the given node does not have ancestor
        if(ans == null || (ans.data == node)){
            return -1;
        }
        else{
            return ans.data;    
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(kthAncestor(root, 2, 4));
    }
}
