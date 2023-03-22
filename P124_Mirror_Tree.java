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

public class P124_Mirror_Tree {
    
    public static Node solve(Node root){
        // Base case
        if(root == null){
            return null;
        }
        
        Node newRight = solve(root.left);
        Node newLeft = solve(root.right);
        
        root.left = newLeft;
        root.right = newRight;
        
        return root;
    }
    
    // Using Recursion || Time complexity O(n) || Space complexity O(height)
    public static void mirror(Node node) {
        // Your code here
        
        if(node == null){
            return;
        }
        
        node = solve(node);
    }
    
    // Using Queue || Time complexity O(n) || Space complexity O(n)
    public static void mirror2(Node node) {
        // Your code here
        if(node == null){
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Node temp = q.poll();

            Node newLeft = temp.right;
            Node newRight = temp.left;
            
            q.add(temp.left);
            q.add(temp.right);

            temp.left = newLeft;
            temp.right = newRight;
        }
    }

    public static void main(String[] args) {
        
    }
}
