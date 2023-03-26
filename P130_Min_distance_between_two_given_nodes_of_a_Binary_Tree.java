class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}
class pair{
    int depth;
    boolean found;
    
    pair(int height, boolean found){
        this.depth = height;
        this.found = found;
    }
}

public class P130_Min_distance_between_two_given_nodes_of_a_Binary_Tree {
    
    // Time complexity O(n) || Space complexity O(height)
    // The given node is guaranteed to be in the binary tree 
    public static pair findDepth(Node root, int target, pair p){
        if(root == null || p.found == true){
            return p;
        }
        
        if(root.data == target){
            p.found = true;
            return p;
        }
        p.depth++;

        pair left = findDepth(root.left, target, p);
        pair right = findDepth(root.right, target, p);

        if(left.found == true){
            return left;
        }
        else if(right.found == true){
            return right;
        }
        else{
            p.depth--;
            return p;
        }
    }

    // Time complexity O(n) || Space complexity O(height)
    public static Node LCA(Node root, int n1, int n2){
        if(root == null){
            return null;
        }
        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if(left != null && right != null){
            return root;
        }
        else if(left == null && right != null){
            return right;
        }
        else if(left != null && right == null){
            return left;
        }
        else{
            return null;
        }
    }
    
    // Time complexity O(n) || Space complexity O(height)
    public static int findDist(Node root, int a, int b) {
        // Find distance of a from root node = depth(a) - 1;
        int distance_a = findDepth(root, a, new pair(0, false)).depth - 1;
        // Find distance of a from root node = depth(b) - 1;
        int distance_b = findDepth(root, b, new pair(0, false)).depth - 1;

        // Find lowest common ancestor of a and b
        Node lca = LCA(root, a, b);
        // Find distance of lca of a and b from root node = depth(lca) - 1;
        int distance_lca = findDepth(root, lca.data, new pair(0, false)).depth - 1;

        // distance(a,b) = distance(root, a) + distance(root, b) + 2*distance(root, lca);
        int ans = distance_a + distance_b - 2*distance_lca;

        return ans;
    }
    public static void main(String[] args) {

        Node root = new Node(69);
        root.left = new Node(26);
        root.right = new Node(85);
        root.left.left = new Node(19);
        root.left.right = new Node(53);
        root.right.left = new Node(81);
        System.out.println(findDist(root, 53, 85));

    }
}
