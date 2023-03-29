import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class BST_Creation {

    public static Node insertIntoBST(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        // Left part mein jao
        if(data < root.data){
            root.left = insertIntoBST(root.left, data);
        }
        // Right part mein jao
        else{
            root.right = insertIntoBST(root.right, data);
        }

        return root;
    }

    public static Node takeInput(Node root){

        System.out.print("Enter data : ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        while(data != -1){
            root = insertIntoBST(root, data);
            System.out.print("Enter data : ");
            data = sc.nextInt();
        }

        sc.close();
        return root;
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

    public static Node minVal(Node root){
        Node temp = root;

        while(temp != null && temp.left != null){
            temp = temp.left;
        }

        return temp;
    }

    public static Node maxVal(Node root){
        Node temp = root;

        while(temp != null && temp.right != null){
            temp = temp.right;
        }

        return temp;
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

    // Time complexity -> Average case O(height) || Worst case O(n)  || Space complexity -> Average case O(height) || Worst case O(n)
    public static Node deleteFromBST(Node root, int val){
        // Base case
        if(root == null){
            return null;
        }

        if(root.data == val){
            // 0 child case
            if(root.left == null && root.right == null){
                root = null;
                return root;
            }

            // 1 child case
            // Left child
            if(root.left != null && root.right == null){
                Node temp = root.left;
                root.left = null;
                return temp;
            }
            // Right child
            if(root.left == null && root.right != null){
                Node temp = root.right;
                root.right = null;
                return temp;
            }

            // 2 child case
            if(root.left != null && root.right != null){
                // int minVal = minVal(root.left).data;

                // root.data = minVal;
                // root.left = deleteFromBST(root.left, minVal);

                // OR

                int minVal = minVal(root.right).data;

                root.data = minVal;
                root.right = deleteFromBST(root.right, minVal);
                return root;
            }
        }
        else if(root.data > val){
            root.left = deleteFromBST(root.left, val);
            return root;
        }
        else{
            root.right = deleteFromBST(root.right, val);
            return root;
        }

        return root;
    }

    public static Node search(Node root, int x) {
        // Time complexity O(logn) / O(height) || Space complexity O(1)
        Node temp = root;
        
        while(temp != null){
            if(temp.data == x){
                return temp;
            }
            else if(temp.data < x){
                temp = temp.right;
            }
            else{
                temp = temp.left;
            }
        }
        
        return temp;
    }
    
    public static void main(String[] args) {
        Node root = null;

        root = takeInput(root);

        // System.out.print("Preorder traversal : ");
        // preOrderTraversal(root);

        System.out.print("Levelorder traversal : ");
        levelOrderTraversal(root);
        
        // deleteFromBST(root, 50);
        
        // System.out.print("Levelorder traversal : ");
        // levelOrderTraversal(root);

        inorderPredecessor(root, 50);
        inorderPredecessor(root, 100);
        inorderPredecessor(root, 60);
        inorderPredecessor(root, 115);
    }
}
