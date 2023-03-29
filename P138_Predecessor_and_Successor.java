class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
    }
}

class Res{
    Node pre = null;
    Node succ = null;
}

public class P138_Predecessor_and_Successor {

    // Time complexity O(n) || Space complexity O(1)
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
        if(root == null){
            p.pre = null;
            s.succ = null;
        }
        
       // Find key
       Node temp = root;
       Node pred = null;
       Node suc = null;
       
       while(temp != null && temp.data != key){
           if(temp.data > key){
               // Possible successor
               suc = temp;
               temp = temp.left;
           }
           else{
               // Possible predecessor
               pred = temp;
               temp = temp.right;
           }
       }
       
       // Pred and Suc
       if(temp == null){
           p.pre = pred;
           s.succ = suc;
           
           return;
       }
       
       Node leftTree = temp.left;
       while(leftTree != null){
           pred = leftTree;
           leftTree = leftTree.right;
       }
       
       Node rightTree = temp.right;
       if(rightTree != null){
        suc = rightTree;
       }
       
       p.pre = pred;
       s.succ = suc;
    }

    public static void main(String[] args) {
        
    }
}