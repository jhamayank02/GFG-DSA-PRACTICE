import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node nextRight;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
        nextRight = null;
    }
}

public class P129_Connect_Nodes_at_Same_Level {
    // Extend level order traversal or BFS || Time complexity O(n) || Space complexity O(n)
    public void connect(Node root)
    {
        // Your code goes here.
        if(root == null){
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        // The previous level has been completed so add null as the separator
        q.add(null);
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp == null){
                continue;
            }
            Node nextRight = q.peek();
            
            temp.nextRight = nextRight;
            
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
            
            // This level has been completed
            if(nextRight == null){
                q.poll();
                q.add(null);
            }
            else if(nextRight != null && (nextRight.left == null && nextRight.right == null)){
                q.add(null);
            }
        }
    }



    // Approach 2 -> Extend preorder traversal || Time complexity O(n) || Space complexity O(n)
    public static void solve(Node root){
        if(root == null){
            return;
        }
        if(root.left != null){
            if(root.right != null){
                root.left.nextRight = root.right;
            }
            else if(root.nextRight != null && root.nextRight.left != null){
                root.left.nextRight = root.nextRight.left;
            }
            else if(root.nextRight != null && root.nextRight.right != null){
                root.left.nextRight = root.nextRight.right;
            }
            else{
                root.left.nextRight = null;
            }
        }
        if(root.right != null){
            if(root.nextRight != null){
                if(root.nextRight.left != null){
                    root.right.nextRight = root.nextRight.left;
                }
                else{
                    root.right.nextRight = root.nextRight.right;
                }
            }
            else{
                root.right.nextRight = null;
            }
        }
        
        solve(root.left);
        solve(root.right);
    }
    //Function to connect nodes at same level.
    public void connect2(Node root){
        if(root == null){
            return;
        }
        root.nextRight = null;
        solve(root);
    }
    public static void main(String[] args) {
        
    }
}
