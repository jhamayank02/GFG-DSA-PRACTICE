import java.util.ArrayDeque;
import java.util.ArrayList;

public class P68_Level_order_traversal_in_spiral_form {
    // A Binary Tree node
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }



    // Approach 1 -> Using Deque || Time complexity O(n) || Space complexity O(n)
    static ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        ArrayDeque<Node> dq = new ArrayDeque<>();
        boolean leftToRight = true;
        dq.add(root);
        
        while(!dq.isEmpty()){
            int size = dq.size();
            
            for(int i=0; i<size; i++){
                
                Node temp = null;
                
                if(leftToRight == true){
                    temp = dq.pollLast();
                }
                else{
                    temp = dq.pollFirst();
                }
                
                ans.add(temp.data);
                
                if(leftToRight == true){
                    if(temp.right != null){
                        dq.addFirst(temp.right);
                    }
                    if(temp.left != null){
                        dq.addFirst(temp.left);
                    }
                }
                else{
                    if(temp.left != null){
                        dq.addLast(temp.left);
                    }
                    if(temp.right != null){
                        dq.addLast(temp.right);
                    }
                }
            }
            leftToRight = !leftToRight;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(7);
        root.left.right = new Node(6);

        root.right.left = new Node(5);
        root.right.right = new Node(4);

        System.out.println(findSpiral(root));
    }
}
