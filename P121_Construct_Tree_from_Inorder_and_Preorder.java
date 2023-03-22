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

public class P121_Construct_Tree_from_Inorder_and_Preorder {

    public static int findPosition(int inorder[], int element, int n){
        for(int i=0; i<n; i++){
            if(inorder[i] == element){
                return i;
            }
        }
        return -1;
    }
    
    static int preOrderIndex = 0;
    
    // public static Node solve(int inorder[], int preorder[], int inOrderStart, int inOrderEnd, int n, HashMap<Integer, Integer> nodeToIndex){
    public static Node solve(int inorder[], int preorder[], int inOrderStart, int inOrderEnd, int n){
        // Base Case
        if(preOrderIndex >= n || inOrderStart > inOrderEnd){
            return null;
        }
        
        int element = preorder[preOrderIndex];
        preOrderIndex++;
        Node root = new Node(element);
        int position = findPosition(inorder, element, n);
        // int position = nodeToIndex.get(element);
        
        // Recursive Calls
        // root.left = solve(inorder, preorder, inOrderStart, position-1, n, nodeToIndex);
        // root.right = solve(inorder, preorder, position+1, inOrderEnd, n, nodeToIndex);
        root.left = solve(inorder, preorder, inOrderStart, position-1, n);
        root.right = solve(inorder, preorder, position+1, inOrderEnd, n);
        
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        // HashMap<Integer, Integer> nodeToIndex = new HashMap<>();
        // for(int i=0; i<n; i++){
        //     nodeToIndex.put(inorder[i], i);
        // }
        
        // Node ans = solve(inorder, preorder, 0, n-1, n, nodeToIndex);
        Node ans = solve(inorder, preorder, 0, n-1, n);
        
        return ans;
    }

    public static void postOrderTraversal(Node root){
        // Base case
        if(root == null){
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // int N = 6;
        // int inorder[] = {3, 1, 4, 0, 5, 2};
        // int preorder[] = {0, 1, 3, 4, 2, 5};
        // int N = 5;
        // int inorder[] = {10, 1, 30, 40, 20};
        // int preorder[] = {1, 10, 20, 30, 40};
        int N = 1;
        int inorder[] = {-1};
        int preorder[] = {-1};
        
        

        Node root = buildTree(inorder, preorder, N);
        postOrderTraversal(root);
    }
}
