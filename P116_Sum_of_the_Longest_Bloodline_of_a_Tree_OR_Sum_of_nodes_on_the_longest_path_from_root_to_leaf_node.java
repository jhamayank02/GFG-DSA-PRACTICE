import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class pair {
    int first;
    int second;

    public pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class P116_Sum_of_the_Longest_Bloodline_of_a_Tree_OR_Sum_of_nodes_on_the_longest_path_from_root_to_leaf_node {
    
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

    public static pair solve(Node root, int noOfNodes, int sum){
        // Base case
        if(root == null){
            pair p = new pair(sum, noOfNodes);
            return p;
        }

        sum += root.data;
        noOfNodes++;

        pair i = solve(root.left, noOfNodes, sum);
        pair j = solve(root.right, noOfNodes, sum);

        if(i.second == j.second){
            if(i.first >= j.first){
                return i;
            }
            else{
                return j;
            }
        }
        else if(i.second > j.second){
            return i;
        }
        else{
            return j;
        }
    }

    // Time complexity O(n) || Space complexity O(n)
    public static int sumOfLongRootToLeafPath(Node root)
    {
        if(root == null){
            return 0;
        }

        int sum = solve(root, 1, 0).first;

        return sum;
    }
    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(sumOfLongRootToLeafPath(root));
    }
}
