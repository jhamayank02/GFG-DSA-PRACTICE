class Info{
    int maxValue, minValue, size;
    boolean isBST;
    
    Info(int maxValue, int minValue, boolean isBST, int size){
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.isBST = isBST;
        this.size = size;
    }
}

class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P145_Largest_BST {
    static int maxSize = 0;
    
    static Info solve(Node root){
        // Base case
        if(root == null){
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
        }
        
        Info left = solve(root.left);
        Info right = solve(root.right);
        
        Info currentNode = new Info(0,0,false,0);
        currentNode.maxValue = Math.max(root.data, right.maxValue);
        currentNode.minValue = Math.min(root.data, left.minValue);
        currentNode.size = left.size + right.size + 1;
        
        if(left.isBST == true && right.isBST == true && root.data > left.maxValue && root.data < right.minValue){
            currentNode.isBST = true;
        }
        else{
            currentNode.isBST = false;
        }

        // Answer update
        if(currentNode.isBST){
            maxSize = Math.max(maxSize, currentNode.size);
        }
        
        return currentNode;
    }
    
    // Time complexity O(n) || Space complexity O(height)
    static int largestBst(Node root)
    {
        // Write your code here
        Info temp = solve(root);
        
        return maxSize;
    }

    public static void main(String[] args) {
        // Node root = new Node(5);
        // root.left = new Node(2);
        // root.right = new Node(4);
        // root.left.left = new Node(1);
        // root.left.right = new Node(3);

        // System.out.println(largestBst(root));
        Node root = new Node(8);

        System.out.println(largestBst(root));
    }
}
