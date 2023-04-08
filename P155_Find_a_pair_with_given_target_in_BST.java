import java.util.HashMap;
import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d;
    }
}

class P155_Find_a_pair_with_given_target_in_BST{

    public static boolean solve(Node root, HashMap<Integer, Boolean> map, int target){
        if(root == null){
            return false;
        }
        
        int req = Math.abs(root.data - target);
        if(map.containsKey(req) && (root.data + req == target)){
            return true;
        }
        
        map.put(root.data, true);
        
        boolean result = false;
        
        result = solve(root.left, map, target);
        if(result == true){
            return result;
        }
        result = solve(root.right, map, target);
        
        return result;
    }
    
    // Approach: Using map || Time complexity O(n) || Space complexity O(n)
    public int isPairPresent(Node root, int target)
    {
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        boolean result = solve(root, map, target);
        
        return result ? 1 : 0;
    }





    public static void pushLeftNodes(Stack<Node> st, Node node){
        while(node != null){
            st.push(node);
            node = node.left;
        }
    }
    
    public static void pushRightNodes(Stack<Node> st, Node node){
        while(node != null){
            st.push(node);
            node = node.right;
        }
    }
    
    public static boolean solve2(Node root, int target){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        
        pushLeftNodes(st1, root);
        pushRightNodes(st2, root);
        
        Node low = st1.pop();
        Node high = st2.pop();
        
        while(low.data < high.data){
            
            int sum = low.data + high.data;
            
            // If the sum is less than the target then increment low
            if(sum < target){
                pushLeftNodes(st1, low.right);
                low = st1.pop();
            }
            // if the sum is greater than target then decrement high
            else if(sum > target){
                pushRightNodes(st2, high.left);
                high = st2.pop();
            }
            // If sum is equal to the target it means the pair is found
            else{
                return true;
            }
        }

        
        return false;
    }
    
    // Approach 2: Using two pointer approach || Time complexity O(n) || Space complexity O(logn) or O(height of BST)
    public int isPairPresent2(Node root, int target){        
        return solve2(root, target) ? 1 : 0;
    }
    public static void main(String[] args) {
        
    }
}