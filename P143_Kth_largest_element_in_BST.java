import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P143_Kth_largest_element_in_BST {
 
    // Time complexity O(n) || Space complexity O(height)
    public static void inOrderTraversal(Node root, ArrayList<Integer> inorder){
        // Base case
        if(root == null){
            return;
        }

        inOrderTraversal(root.left, inorder);
        inorder.add(root.data);
        inOrderTraversal(root.right, inorder);
    }

    static int visitedCount = 0;
    static int kthLargestVal = -1;
    
    // Time complexity O(n) || Space complexity O(height)
    public static void inOrderTraversal2(Node root, int k){
        // Base case
        if(root == null){
            return;
        }
        
        inOrderTraversal2(root.right, k);
        
        visitedCount++;
        if(visitedCount == k){
            System.out.println(visitedCount + " " + root.data);
            kthLargestVal = root.data;
        }

        inOrderTraversal2(root.left, k);
    }
    
    // Time complexity O(n) || Space complexity O(height)
    public static int kthLargest(Node root,int K)
    {
        // if(root == null){
        //     return -1;
        // }
        
        // ArrayList<Integer> inorder = new ArrayList<>();
        // inOrderTraversal(root, inorder);
        
        // for(int i=inorder.size()-1; i>=0; i--){
        //     if(inorder.size()-i == K){
        //         return inorder.get(i);
        //     }
        // }
        
        // return -1;

        inOrderTraversal2(root, K);
        
        return kthLargestVal;
    }
    
    public static void main(String[] args) {
        Node root = new Node(68);
        root.left = new Node(14);
        root.right = new Node(92);
        
        root.left.left = new Node(5);
        root.left.right = new Node(50);
        root.left.left.left = new Node(3);
        
        root.right.left = new Node(78);
        root.right.right = new Node(97);

        System.out.println(kthLargest(root, 6));
    }
}
