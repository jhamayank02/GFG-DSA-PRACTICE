import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

public class P122_Tree_from_Postorder_and_Inorder {
    
    public static int findPosition(int element, int in[], int n){
        for(int i=0; i<n; i++){
            if(in[i] == element){
                return i;
            }
        }
        return -1;
    }
    
    static int postOrderIndex = 0;
    
    // Time complexity O(n^2) || Space complexity O(n)
    public static Node solve(int in[], int post[], int n, int inOrderStart, int inOrderEnd){
        // Base Case
        if(postOrderIndex < 0 || inOrderStart > inOrderEnd){
            return null;
        }
        
        int element = post[postOrderIndex--];
        int position = findPosition(element, in, n);
        
        Node root = new Node(element);

        root.right = solve(in, post, n, position+1, inOrderEnd);
        root.left = solve(in, post, n, inOrderStart, position-1);
        
        return root;
    }
    
    //Function to return a tree created from postorder and inoreder traversals.
    public static Node buildTree(int in[], int post[], int n) {
        // Your code here
        postOrderIndex = n-1;
        
        Node ans = solve(in, post, n, 0, n-1);
        
        return ans;
    }
    public static void main(String[] args) {
        int N = 8;
        int in[] = {4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = {8, 4, 5, 2, 6, 7, 3, 1};

        buildTree(in, post, N);
    }
}
