import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P79_Smallest_number_on_left {
    static List<Integer> leftSmaller(int n, int a[])
    {
        // Time complexity O(n) || Space complexity O(n)
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        st.push(-1);

        for(int i=0; i<n; i++){

            if(st.size() == 1){
                ans.add(st.peek());
                st.push(a[0]);
            }
            else{
                while(st.size()>1 && a[i]<=st.peek()){
                    st.pop();
                }
                ans.add(st.peek());
                st.push(a[i]);
            }
        }

        
        return ans;
    }

    public static void main(String[] args) {
        // int a[] = {1, 5, 0, 3, 4, 5};
        // int a[] = {1, 6, 2};
        int a[] = {19, 19, 19, 19, 19, 19, 19};

        System.out.println(leftSmaller(a.length, a));
    }
}
