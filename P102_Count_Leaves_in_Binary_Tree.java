import java.util.Scanner;

class Node{
    int data;
    Node left, right;

    Node(int d){
        data = d;
        left = null;
        right = null;
    }
}

class P102_Count_Leaves_in_Binary_Tree {

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

    public static int inOrderTraversal(Node root, int count){
        // Base case
        if(root == null){
            return count;
        }

        count = inOrderTraversal(root.left, count);
        
        if(root.left == null && root.right == null){
            count++;
        }
        
        count = inOrderTraversal(root.right, count);

        return count;
    }
    
    public static int countLeaves(Node node) 
    {
        int count = 0;
        count = inOrderTraversal(node, count);

        return count;
    }
    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(countLeaves(root));
    }
}
