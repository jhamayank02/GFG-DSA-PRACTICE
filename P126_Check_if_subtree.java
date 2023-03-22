class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class P126_Check_if_subtree {
        public static boolean isSame(Node T, Node S){
            // Base case
            if(S == null && T == null){
                return true;
            }
            if(T == null || S == null){
                return false;
            }
            
            return (T.data == S.data) && isSame(T.left, S.left) && isSame(T.right, S.right);
        }
        
        public static boolean isSubtree(Node T, Node S) {
            // add code here.
            if(T == null){
                return false;
            }
            if(S == null){
                return true;
            }
            
            if(isSame(T, S)){
                return true;
            }
            else{
                return isSubtree(T.left, S) || isSubtree(T.right, S);
            }
        }

    public static void main(String[] args) {
        Node T = new Node(1);
        T.left = new Node(2);
        T.right = new Node(3);
        T.right.left = new Node(4);

        Node S = new Node(3);
        S.left = new Node(4);

        System.out.println(isSubtree(T, S));
    }
}
