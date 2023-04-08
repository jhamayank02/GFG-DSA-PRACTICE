class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d;
    }
}

class P154_Check_whether_BST_contains_Dead_End{

    public static boolean solve(Node root, int min, int max){
        if(root == null){
            return false;
        }
        if(min == max){
            return true;
        }
        
        boolean left = solve(root.left, min, root.data-1);
        boolean right = solve(root.right, root.data+1, max);
        
        return left || right;
    }
    
    public static boolean isDeadEnd(Node root)
    {
        boolean deadEnd = solve(root, 1, Integer.MAX_VALUE);
        
        return deadEnd;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(9);

        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.left.left.left = new Node(1);

        System.out.println(isDeadEnd(root));
    }
}