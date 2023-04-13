import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

public class P144_Merge_2_BST_To_Create_New_BST {

    // Approach 1: Time complexity O(m+n) || Space complexity O(m+n)
        /*
        1. Store inorder traversal of both BST in inorder1 and inorder2 arrays
        2. Now create a third array inorder by merging both inorder1 and inorder2
        3. Now create a BST from inorder array
        */

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

    // Time complexity O(m+n) || Space complexity O(m+n)
    public static ArrayList<Integer> merge2SortedArrays(ArrayList<Integer> inorder1, ArrayList<Integer> inorder2){
        ArrayList<Integer> inorder = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < inorder1.size() && j < inorder2.size()){

            if(inorder1.get(i) < inorder2.get(j)){
                inorder.add(inorder1.get(i));
                i++;
            }
            else{
                inorder.add(inorder2.get(j));
                j++;
            }

        }

        while(i < inorder1.size()){
            inorder.add(inorder1.get(i));
            i++;
        }
        while(j < inorder2.size()){
            inorder.add(inorder2.get(j));
            j++;
        }

        return inorder;
    }

    // Time complexity O(k) || Space complexity O(k)
    public static Node bstFromInorder(ArrayList<Integer> in, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;
        int element = in.get(mid);
        Node root = new Node(element);
        root.left = bstFromInorder(in, start, mid-1);
        root.right = bstFromInorder(in, mid+1, end);

        return root;
    }


    // Time complexity O(m+n) || Space complexity O(m+n)
    public static Node mergeTwoBST(Node root1, Node root2){
        // Store inorder of bith the BST
        ArrayList<Integer> inorder1 = new ArrayList<>();
        ArrayList<Integer> inorder2 = new ArrayList<>();

        inOrderTraversal(root1, inorder1);
        inOrderTraversal(root2, inorder2);

        // Merge both sorted inorder arrays
        ArrayList<Integer> inorder = merge2SortedArrays(inorder1, inorder2);

        // Create a BST from merged inorder array
        Node root = null;
        root = bstFromInorder(inorder, 0, inorder.size()-1);

        return root;
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







    // Approach 2: Time complexity O(m+n) || Space complexity O(height1 + height2)

    // Time complexity O(n) || Space complexity O(height)
    static Node prev = null;

    // Time complexity O(n) || Space complexity O(height)
    public static Node BST_To_DLL(Node head, Node root){
        if(root == null){
            return head;
        }

        head = BST_To_DLL(head, root.left);
        
        if(prev == null){
            head = root;
        }
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        
        head = BST_To_DLL(head, root.right);
        return head;
    }

    // Time complexity O(m+n) || Space complexity O(1)
    public static Node mergeTwoDLL(Node head1, Node head2){
        if(head1 == null && head2 == null){
            return null;
        }
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }


        Node head = null;
        Node tail = null;

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                if(head == null){
                    head = head1;
                    tail = head1;
                }
                else{
                    tail.right = head1;
                    head1.left = tail;
                    tail = tail.right;
                }
                head1 = head1.right;
            }
            else{
                if(head == null){
                    head = head2;
                    tail = head2;
                }
                else{
                    tail.right = head2;
                    head2.left = tail;
                    tail = tail.right;
                }
                head2 = head2.right;
            }
        }

        if(head1 != null){
            tail.right = head1;
            head1.left = tail;

            head1 = head1.right;
            tail = tail.right;
        }

        if(head2 != null){
            tail.right = head2;
            head2.left = tail;

            head2 = head2.right;
            tail = tail.right;
        }

        return head;
    }

    public static int countNodes(Node head){
        int count = 0;
        while(head != null){
            count++;
            head = head.right;
        }

        return count;
    }

    static Node DLL_head;
    public static Node sortedDLLToBST(int n){
        if(n <= 0 || DLL_head == null){
            return null;
        }

        Node left = sortedDLLToBST(n/2);

        Node root = DLL_head;

        root.left = left;
        DLL_head = DLL_head.right;

        root.right = sortedDLLToBST(n-n/2-1);

        return root;
    }

    // Time complexity O(m+n) || Space complexity O(height1 + height2)
    public static Node mergeTwoBST2(Node root1, Node root2){
        Node head1 = null;
        head1 = BST_To_DLL(head1, root1);
        prev = null; 
        Node head2 = null;
        head2 = BST_To_DLL(head2, root2);

        Node head = mergeTwoDLL(head1, head2);

        int n = countNodes(head);

        DLL_head = head;
        Node root = sortedDLLToBST(n);

        return root;
    }

    public static void main(String[] args) {
        Node root1 = new Node(50);
        root1.left = new Node(40);
        root1.right = new Node(60);
        root1.right.right = new Node(70);

        Node root2 = new Node(55);
        root2.left = new Node(45);
        root2.right = new Node(65);
        root2.left.left = new Node(35);
        root2.left.right = new Node(47);

        // Node root = mergeTwoBST(root1, root2);
        // inOrderTraversal(root);
        Node root = mergeTwoBST2(root1, root2);
        inOrderTraversal(root);
        // inOrderTraversal(root1);
        // inOrderTraversal(root2);
    }
}
