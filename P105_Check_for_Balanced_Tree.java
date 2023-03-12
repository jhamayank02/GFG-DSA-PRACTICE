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

class pair {
    boolean first;
    long second;  

    public pair(boolean first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }
    public void printPair(){
        System.out.println(first);
        System.out.println(second);
    }
}

public class P105_Check_for_Balanced_Tree {

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
    
    // Time complexity O(n^2)
    public static boolean isBalanced(Node root)
    {
	    // if(root == null){
        //     return true;
        // }

        // boolean left = isBalanced(root.left);
        // boolean right = isBalanced(root.right);

        // int leftHeight = height(root.left);
        // int rightHeight = height(root.right);

        // boolean balanced = (Math.abs(leftHeight - rightHeight) <= 1)?true:false;

        // if(left && right && balanced){
        //     return true;
        // }
        // else{
        //     return false;
        // }

        return isBalancedFast(root).first;
    }
    
    // Time complexity O(n)
    // pair.first = isBalanced and pair.second = height
    public static pair isBalancedFast(Node root)
    {
	    if(root == null){
            pair p = new pair(true, 0);
            return p;
        }

        pair left = isBalancedFast(root.left);
        pair right = isBalancedFast(root.right);

        boolean leftAns = left.first;
        boolean rightAns = right.first;

        boolean diff = (Math.abs(left.second - right.second) <= 1)?true:false;

        pair ans = new pair(false, 0);
        ans.second = Math.max(left.second, right.second) + 1;
        
        if(leftAns && rightAns && diff){
            ans.first = true;
            return ans;
        }
        else{
            ans.first = false;
            return ans;
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(isBalanced(root));
    }
}
