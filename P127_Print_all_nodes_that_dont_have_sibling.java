import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

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

public class P127_Print_all_nodes_that_dont_have_sibling {
    
    // Using the level order traversal || Time complexity O(NlogN) || Space complexity O(height)
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(node == null || (node.left == null && node.right == null)){
            ans.add(-1);
            return ans;
        }
        
        // Do level order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            
            // If any of the left or right child is null then add it to the answer list
            if(temp.left == null && temp.right != null){
                ans.add(temp.right.data);
            }
            else if(temp.left != null && temp.right == null){
                ans.add(temp.left.data);
            }
            
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
        
        // If answer list's size is 0 it means the tree doesn't have nodes that dont't have siblings
        if(ans.size() == 0){
            ans.add(-1);
        }
        
        Collections.sort(ans);
        
        return ans;
    }


    // Using Recursion || Time complexity O(nlogn) || Space complexity O(height)
    ArrayList<Integer> noSibling2(Node node)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(node == null || (node.left == null && node.right == null)){
            ans.add(-1);
            return ans;
        }
        
        solve(node, ans);
        
        if(ans.size() == 0){
            ans.add(-1);
        }

        Collections.sort(ans);
        
        return ans;
    }
    
    public static Node solve(Node root, ArrayList<Integer> ans){
        // Base case
        if(root == null){
            return null;
        }
        
        Node leftTree = solve(root.left, ans);
        Node rightTree = solve(root.right, ans);
        
        if((leftTree == null && rightTree == null) || (leftTree != null && rightTree != null)){
            return root;
        }
        else{
            if(leftTree != null){
                ans.add(leftTree.data);
            }
            else{
                ans.add(rightTree.data);
            }
            return root;
        }
    }
    
    public static void main(String[] args) {
        
    }
}
