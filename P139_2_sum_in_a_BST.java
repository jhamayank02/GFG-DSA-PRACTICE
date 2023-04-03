import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P139_2_sum_in_a_BST {

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

    // Time complexity O(n) || Space complexity O(n)
    public static ArrayList<Integer> twoSumInBST(Node root, int target){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return null;
        }

        ArrayList<Integer> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);

        int i = 0;
        int j = inorder.size()-1;

        while(i<j){
            if(inorder.get(i) + inorder.get(j) == target){
                ans.add(inorder.get(i));
                ans.add(inorder.get(j));
                return ans;
            }
            else if(inorder.get(i) + inorder.get(j) > target){
                j--;
            }
            else if(inorder.get(i) + inorder.get(j) < target){
                i++;
            }
        }

        return ans;
    }
    

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(8);
        root.right.left = new Node(11);
        root.right.right = new Node(15);

        System.out.println(twoSumInBST(root, 20));
    }
}
