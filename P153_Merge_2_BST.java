import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d;
    }
}


public class P153_Merge_2_BST{
    
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

    public static List<Integer> merge(Node root1,Node root2)
    {
        prev = null;
        List<Integer> ans = new ArrayList<>(); // S.C O(m+n)

        Node head1 = null;
        Node head2 = null;
        head1 = BST_To_DLL(head1, root1); // T.C O(m) || S.C O(height BST1)

        prev = null;
        head2 = BST_To_DLL(head2, root2); // T.C O(n) || S.C O(height BST2)

        Node head = mergeTwoDLL(head1, head2); // T.C O(m+n) || S.C O(height BST1 + height BST 2)

        Node temp = head;
        while(temp != null){
            ans.add(temp.data);
            temp = temp.right;
        }

        return ans;
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

        List<Integer> ans = merge(root1, root2);
        System.out.println(ans);
    }
}
