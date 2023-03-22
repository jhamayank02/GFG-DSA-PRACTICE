import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class P123_Burning_Tree {
    
    public static Node createParentMapping(Node root, int target, HashMap<Node, Node> nodeToParent){
        Node result = null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        nodeToParent.put(root, null);
        
        while(!q.isEmpty()){
            Node front = q.poll();
            
            if(front.data == target){
                result = front;
            }
            
            if(front.left != null){
                nodeToParent.put(front.left, front);
                q.add(front.left);
            }
            if(front.right != null){
                nodeToParent.put(front.right, front);
                q.add(front.right);
            }
        }
        
        return result;
    }
    
    public static int burnTree(Node root, HashMap<Node, Node> nodeToParent){
        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        visited.put(root, true);
        
        int ans = 0;
        
        while(!q.isEmpty()){
            
            boolean flag = false;
            int size = q.size();

            for(int i=0; i<size; i++){
                // Process neighbouring nodes
                Node front = q.poll();
                
                if(front.left != null && (visited.get(front.left) == null || visited.get(front.left) == false)){
                    flag = true;
                    q.add(front.left);
                    visited.put(front.left, true);
                }
                if(front.right != null && (visited.get(front.right) == null || visited.get(front.right) == false)){
                    flag = true;
                    q.add(front.right);
                    visited.put(front.right, true);
                }
                
                if(nodeToParent.get(front) != null && (visited.get(nodeToParent.get(front)) == null || visited.get(nodeToParent.get(front)) == false)){
                    flag = true;
                    q.add(nodeToParent.get(front));
                    visited.put(nodeToParent.get(front), true);
                }
            }
            
            if(flag == true){
                ans++;
            }
        }
        
        return ans;
    }
    
    // Time complexity O(n) || Space complexity O(n)
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        int ans = 0;
        HashMap<Node, Node> nodeToParent = new HashMap<>();
        
        Node targetNode = createParentMapping(root, target, nodeToParent);
        
        ans = burnTree(targetNode, nodeToParent);
        
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
