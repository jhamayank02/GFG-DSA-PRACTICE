import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class P115_Diagonal_Traversal_of_Binary_Tree {

    public static Node buildTree(Node root) {
        System.out.print("Enter the data : ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
    
        root = new Node(data);
    
        if (data == -1) {
            return null;
        }
    
        System.out.print("\nEnter the data for inserting at the left of " + data + " ");
        root.left = buildTree(root.left);
    
        System.out.print("\nEnter the data for inserting at the right of " + data + " ");
        root.right = buildTree(root.right);
    
        return root;
    }
    
    // Time complexity O(n) || Space complexity O(n)
    static public ArrayList<Integer> diagonal(Node root){
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<Node> leftQueue = new LinkedList<>();

        Node temp = root;

        while(temp != null){

            // Add current node to the ans
            ans.add(temp.data);

            // If left child is not null then store it in the leftQueue. We will use it when we will left with no right child to traverse the tree
            if(temp.left != null){
                leftQueue.add(temp.left);
            }

            // If right child is available then make temp equal to the right child
            if(temp.right != null){
                temp = temp.right;
            }
            // Else pop from the leftQueue and if leftQueue is empty then set temp = null
            else{
                if(!leftQueue.isEmpty()){
                    temp = leftQueue.poll();
                }
                else{
                    temp = null;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);
        System.out.println(diagonal(root));
    }
}
