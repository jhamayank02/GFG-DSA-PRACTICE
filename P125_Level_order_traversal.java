import java.util.ArrayList;
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

public class P125_Level_order_traversal {

    // Approach -> Using Queue || Time complexity O(n) || Space complexity O(n)
    static ArrayList <Integer> levelOrder(Node node) 
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(node == null){
            return ans;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            ans.add(temp.data);
            
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
        
        return ans;
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Adds the current level in the answer list
    public static void solve(Node node, ArrayList<Integer> ans, int level){
        // Base Case
        if(node == null){
            return;
        }

        if(level == 1){
            ans.add(node.data);
        }
        else if(level > 1){
            solve(node.left, ans, level-1);
            solve(node.right, ans, level-1);
        }
    }

    // Approach -> Using recursion || Time complexity O(n^2) || Space complexity O(height)
    static ArrayList <Integer> levelOrder2(Node node){
        ArrayList<Integer> ans = new ArrayList<>();

        if(node == null){
            return ans;
        }

        int height = height(node);

        for(int i=1; i<=height; i++){
            solve(node, ans, i);
        }

        return ans;
    }

    
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        System.out.println(levelOrder2(root));
    }
}
