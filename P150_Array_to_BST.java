import java.util.ArrayList;
import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d;
    }
}

public class P150_Array_to_BST {
    // Time complexity O(n) || Space complexity O(n)
    public static Node solve(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        
        int mid = (start+end)/2;
        
        Node root = new Node(nums[mid]);
        
        root.left = solve(nums, start, mid-1);
        root.right = solve(nums, mid+1, end);
        
        return root;
    }
    
    // Time complexity O(n) || Space complexity O(n)
    public static int[] preorderTraversal(Node root){
        if(root == null){
            return new int[0];
        }
        
        Stack<Node> st = new Stack<>();
        st.push(root);
        
        ArrayList<Integer> pre = new ArrayList<>();
        
        while(!st.isEmpty()){
            Node temp = st.pop();
            pre.add(temp.data);
            
            if(temp.right != null){
                st.push(temp.right);
            }
            if(temp.left != null){
                st.push(temp.left);
            }
        }
        
        int preArr[] = new int[pre.size()];
        
        for(int i=0; i<pre.size(); i++){
            preArr[i] = pre.get(i);
        }
        
        return preArr;
    }


    // Time complexity O(n) || Space complexity O(n)
    public static void solve(ArrayList<Integer> pre, int nums[], int start, int end){
        if(start > end){
            return;
        }
        
        int mid = (start+end)/2;
        pre.add(nums[mid]);
        
        solve(pre, nums, start, mid-1);
        solve(pre, nums, mid+1, end);
    }


    
    // Time complexity O(n) || Space complexity O(n)
    public static int[] sortedArrayToBST(int[] nums)
    {
        // Approach 1: Time complexity O(n) || Space complexity O(n)
        // Node root = solve(nums, 0, nums.length-1);
        
        // int pre[] = preorderTraversal(root);
        
        // return pre;

        // Approach 2: Time complexity O(n) || Space complexity O(n)
        ArrayList<Integer> pre = new ArrayList<>();
        
        solve(pre, nums, 0, nums.length-1);
        
        int preArr[] = new int[pre.size()];
        
        for(int i=0; i<pre.size(); i++){
            preArr[i] = pre.get(i);
        }
        
        return preArr;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};

        int ans[] = sortedArrayToBST(nums);
    }
}
