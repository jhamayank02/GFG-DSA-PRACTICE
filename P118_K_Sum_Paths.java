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

public class P118_K_Sum_Paths {

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

    // Time complexity O(n*h) || Space complexity O(h)
    public static int solve(Node root, int k, int count, ArrayList<Integer> path){
        // Base case
        if(root == null){
            return count;
        }
        
        path.add(root.data);
        
        // Left call
        count = solve(root.left, k, count, path);
        // Right call
        count = solve(root.right, k, count, path);
        
        // Check for k sum
        int size = path.size();
        int sum = 0;
         for (int i = size-1; i>=0; i--){
            sum += path.get(i);
            if(sum == k){
                count++;
            }
        }
        
        path.remove(size-1);
        return count;
    }

    // Time complexity O(n) || Space complexity O(height)
    public static int solve2(Node root, HashMap<Integer, Integer> map, int count, int target, int currSum){

        if(root == null){
            return count;
        }

        currSum += root.data;
        
        if(map.containsKey(currSum - target)){
            count += map.get(currSum-target);
        }
        
        if(map.containsKey(currSum)){
            map.put(currSum, map.get(currSum) + 1);
        }
        else{
            map.put(currSum, 1);
        }

        count = solve2(root.left, map, count, target, currSum);
        count = solve2(root.right, map, count, target, currSum);
        
        if(map.get(currSum) > 1){
            map.put(currSum, map.get(currSum) - 1);
        }
        else{
            map.remove(currSum, 1);
        }
        
        currSum -= root.data;

        return count;
    }
    
    public static int sumK(Node root,int k)
    {
        // ArrayList<Integer> path = new ArrayList<>();
        // int count = 0;
        // count = solve(root, k, count, path);
        // return count;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        count = solve2(root, map, count, k, 0);
        return count;
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        System.out.println(sumK(root, 3));
    }
}
