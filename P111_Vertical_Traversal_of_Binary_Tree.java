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
    Node first;
    int second;

    public pair(Node first, int second){
        this.first = first;
        this.second = second;
    }
}

public class P111_Vertical_Traversal_of_Binary_Tree {
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
    
    // Time complexity O(n) || Time complexity O(n)
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<pair> q = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> nodes = new TreeMap<>();
        int hd = 0;
        q.add(new pair(root, hd));

        while(!q.isEmpty()){

            pair temp = q.poll();
            Node tempNode = temp.first;
            int tempHd = temp.second;

            if(nodes.containsKey(tempHd)){
                ArrayList<Integer> tempAns = nodes.get(tempHd);
                tempAns.add(tempNode.data);
                nodes.put(tempHd, tempAns);
            }
            else{
                ArrayList<Integer> tempAns = new ArrayList<>();
                tempAns.add(tempNode.data);
                nodes.put(tempHd, tempAns);
            }

            if(tempNode.left != null){
                q.add(new pair(tempNode.left, tempHd-1));
            }
            if(tempNode.right != null){
                q.add(new pair(tempNode.right, tempHd+1));
            }

        }

        for(ArrayList<Integer> arr : nodes.values()){
            for(int i : arr){
                ans.add(i);
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(verticalOrder(root));
    }
}
