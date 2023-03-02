import java.util.Stack;

public class P77_Get_min_at_pop {
    static Stack<Integer> s = new Stack<>();
    static int min = -1;
    
    public static Stack<Integer> _push(int arr[],int n)
    {
    
        if(s.empty()){
            min = arr[0];
            s.push(arr[0]);
        }
        
        for(int i=1; i<n; i++){
            int current = arr[i];

            if(current > min){
                s.push(current);
            }
            else{
                int val = (2*current) - min;
                min = current;
                s.push(val);
            }
        }
        
        return s;
    }
    
    //Function to print minimum value in stack each time while popping.
    static void _getMinAtPop(Stack<Integer>s)
    {   
        if(!s.empty()){
            int top = s.pop();
            if(min > top){
                min = 2*min - top;
            }

            System.out.print(min + " ");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        
        int arr[] = {1,2,3,4,5};

        s = _push(arr, arr.length);

        _getMinAtPop(s);
        _getMinAtPop(s);
        _getMinAtPop(s);
        _getMinAtPop(s);
        _getMinAtPop(s);
    }
}
