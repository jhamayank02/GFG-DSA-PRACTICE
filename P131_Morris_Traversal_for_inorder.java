import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

class P131_Morris_Traversal_for_inorder{

    
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
    public static void morrisTraversal(Node root){
        Node current = root;

        while(current != null){

            if(current.left == null){
                System.out.print(current.data + " ");
                current = current.right;
            }
            else{
                Node predecessor = findPredecessor(current);

                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }
                else{
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        morrisTraversal(root);
    }
}