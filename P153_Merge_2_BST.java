class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d;
    }
}


public class P153_Merge_2_BST{
    
    public static Node BST_To_LL(Node root, Node prev){
        if(root.right == null){
            return root;
        }

        root.right = BST_To_LL(root, prev);
        



    }

    public static void main(String[] args) {
        
    }
}
