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

public class P117_Lowest_Common_Ancestor_in_a_Binary_Tree {
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

    // Time complexity O(n) || Space complexity O(height)
    public static Node lca(Node root, int n1,int n2)
	{
		// Base case
		if(root == null){
		    return null;
		}
		
		if(root.data == n1 || root.data == n2){
		    return root;
		}
		
		Node leftAns = lca(root.left, n1, n2);
		Node rightAns = lca(root.right, n1, n2);
		
		if(leftAns != null && rightAns != null){
		    return root;
		}
		else if(leftAns != null && rightAns == null){
		    return leftAns;
		}
		else if(leftAns == null && rightAns != null){
		    return rightAns;
		}
		else{
		    return null;
		}
	}
    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(lca(root, 0, 0).data);
    }
}
