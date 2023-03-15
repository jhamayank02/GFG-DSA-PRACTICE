import java.util.ArrayList;
import java.util.Scanner;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class P113_Left_View_of_Binary_Tree {
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

    public static void solve(Node root, int level, ArrayList<Integer> ans){
        // Base case
        if(root == null){
            return;
        }
        
        // You entered into a new level
        if(level == ans.size()){
            ans.add(root.data);
        }
        
        solve(root.left, level+1, ans);
        solve(root.right, level+1, ans);
    }
    //Function to return list containing elements of left view of binary tree.
    public static ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> ans = new ArrayList<>();
      
      if(root == null){
          return ans;
      }
      
      int level = 0;
      solve(root, level, ans);
      
      return ans;
    }
    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);
        System.out.println(leftView(root));
    }
}
