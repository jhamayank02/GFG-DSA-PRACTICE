import java.util.Stack;

public class P67_Next_larger_element {
    
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        long ans[] = new long[n];
        Stack<Long> s = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            
            if(s.empty()){
                ans[i] = -1;
                s.push(arr[i]);
            }
            else{
                
                long current = arr[i];
                
                if(!s.empty() && s.peek()>current){
                    ans[i] = s.peek();
                    s.push(current);
                }
                else{
                    
                    while(!s.empty() && s.peek()<=current){
                        s.pop();
                    }
                    
                    if(s.empty()){
                        ans[i] = -1;
                        s.push(current);
                    }
                    else{
                        ans[i] = s.peek();
                        s.push(current);
                    }
                }
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        long arr[] = {1, 3, 2, 4};

        long ans[] = nextLargerElement(arr, 4);

        System.out.print("Output : ");
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
