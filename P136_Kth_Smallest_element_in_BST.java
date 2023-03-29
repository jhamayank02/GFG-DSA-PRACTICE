class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

// Time complexity O(n) || Space complexity O(height)
public class P136_Kth_Smallest_element_in_BST {

    public static int i = 0;
    public static int solve(Node root, int k){
        if(root == null){
            return -1;
        }
        
        // Left
        int left = solve(root.left, k);

        if(left != -1){
            return left;
        }

        // Root
        i++;
        if(i == k){
            return root.data;
        }

        // Right
        return solve(root.right, k);
    }

    public static int kthSmallest(Node root, int k){
        int ans = solve(root, k);
        return ans;
    }
    
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(100);
        root.left.right = new Node(3);

        System.out.println(kthSmallest(root, 3));
    }
}
