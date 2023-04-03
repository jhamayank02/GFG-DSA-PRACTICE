class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P147_Count_BST_nodes_that_lie_in_a_given_range {
    static int count;
    
    public static void solve(Node root, int min, int max){
        if(root == null){
            return;
        }
        
        if(root.data >= min && root.data <= max){
            count++;
        }
        
        // Don't go int left part you will only find smaller values
        if(root.data <= min){
            solve(root.right, min, max);
        }
        // Don't go int right part you will only find larger values
        else if(root.data >= max){
            solve(root.left, min, max);
        }
        else{
            solve(root.left, min, max);
            solve(root.right, min, max);
        }
    }
    
    // Time complexity O(n) || Space complexity O(height)
    public static int getCount(Node root,int l, int h)
    {
        count = 0;
        
        solve(root, l, h);
        
        return count;
    }

    public static void main(String[] args) {
        
    }
}
