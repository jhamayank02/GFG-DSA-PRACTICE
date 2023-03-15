import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

class pair {
    Node first ;
    int second;

    public pair(Node first, int second) {
        this.first = first;
        this.second = second;
    }
}
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

public class P112_Top_View_of_Binary_Tree {

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
    
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        // Used TreeMap to put the keys in ascending order
        TreeMap<Integer, Integer> topNode = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        
        q.add(new pair(root, 0));
        
        while(!q.isEmpty()){
            pair temp = q.poll();
            
            Node frontNode = temp.first;
            int hd = temp.second;
            
            // If one value is present for a Horizontal distance then do nothing
            if(topNode.containsKey(hd) == false){
                topNode.put(hd, frontNode.data);
            }
            
            if(frontNode.left != null){
                q.add(new pair(frontNode.left, hd-1));
            }
            if(frontNode.right != null){
                q.add(new pair(frontNode.right, hd+1));
            }
        }

        for(int i : topNode.values()){
            ans.add(i);
        }
        
        return ans;
    }
    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);
        System.out.println(topView(root));
    }
}
