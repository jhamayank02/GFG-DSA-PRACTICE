import java.util.Stack;

public class P54_Delete_middle_element_of_stack {

    public static void deleteMid(Stack s, int count, int size){
        // Base case
        if(count == size/2){
            s.pop();
            return;
        }

        int preserveVal = (Integer)s.pop();

        deleteMid(s, count+1, size);

        s.push(preserveVal);
    }

    public static void solve(Stack<Integer> s, int mid, int count){
        // Base case
        if(mid == count){
           s.pop();
           return;
        }
 
        int val = s.pop();
 
        solve(s, mid, count+1);
 
        s.push(val);
     }
 
     // Time complexity O(n) || Space complexity O(n)
     public static void deleteMid2(Stack<Integer>s,int sizeOfStack){
         // code here
         if(s.size() > 0){
             int mid = 0;
 
             if(s.size() % 2 != 0){
                 mid = (s.size()/2) + 1;
             }
             else{
                 mid = s.size() / 2;
             }
 
             solve(s, mid, 0);
         }
     }
    
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        System.out.println(stack);

        // deleteMid(stack, 0, stack.size());
        deleteMid2(stack, stack.size());

        System.out.println(stack);
    }
}
