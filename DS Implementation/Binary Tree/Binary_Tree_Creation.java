import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

class Node{
    int data;
    Node left, right;

    Node(int d){
        data = d;
        left = null;
        right = null;
    }
}

public class Binary_Tree_Creation {
    
    public static Node buildTree(Node root){
        System.out.print("Enter the data : ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        root = new Node(data);

        if(data == -1){
            return null;
        }

        System.out.print("\nEnter the data for inserting at the left of " + data + " ");
        root.left = buildTree(root.left);

        System.out.print("\nEnter the data for inserting at the right of " + data + " ");
        root.right = buildTree(root.right);

        return root;
    }

    public static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node temp = q.poll();
            
            // Previous level has been completed
            if(temp == null){
                System.out.println();

                // Queue still has some elements
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
                System.out.print(temp.data + " ");
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
    }

    public static void inOrderTraversal(Node root){
        // Base case
        if(root == null){
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(Node root){
        // Base case
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
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

    public static Node buildFromLevelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the data for the root node : ");
        int rootData = sc.nextInt();
        root = new Node(rootData);
        q.add(root);

        while(!q.isEmpty()){

            Node temp = q.poll();

            System.out.print("Enter the data for the left node of " + temp.data + " : ");
            int leftData = sc.nextInt();
            if(leftData != -1){
                temp.left = new Node(leftData);
                q.add(temp.left);
            }

            System.out.print("Enter the data for the right node of " + temp.data + " : ");
            int rightData = sc.nextInt();
            if(rightData != -1){
                temp.right = new Node(rightData);
                q.add(temp.right);
            }

        }

        return root;
    }

    public static void main(String[] args) {
        Node root = null;

        // root = buildTree(root);

        root = buildFromLevelOrderTraversal(root);
        levelOrderTraversal(root);
        // inOrderTraversal(root);
        // preOrderTraversal(root);
        // postOrderTraversal(root);
    }
}
