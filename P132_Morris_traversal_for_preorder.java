import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P132_Morris_traversal_for_preorder {
    
    
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

    public static Node findPredecessor(Node root){
        if(root == null){
            return null;
        }

        Node pred = root.left;

        while(pred.right != null && pred.right != root){
            pred = pred.right;
        }

        return pred;
    }

    // Time complexity O(n) || Space complexity O(1)
    public static void morrisTraversalForPreorder(Node root){
        Node current = root;

        while(current != null){

            if(current.left == null){
                System.out.print(current.data + " ");
                current = current.right;
            }
            else{
                Node predecessor = findPredecessor(current);
                
                if(predecessor.right == current){
                    predecessor.right = null;
                    current = current.right;
                }
                else{
                    System.out.print(current.data + " ");
                    predecessor.right = current;
                    current = current.left;
                }
            }

        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        morrisTraversalForPreorder(root);
    }
}


