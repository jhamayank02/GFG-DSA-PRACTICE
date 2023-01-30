import java.util.ArrayList;
import java.util.Stack;

public class P62_Largest_rectangle_in_histogram {

    public static int[] nextSmallerElement(ArrayList<Integer> arr, int n){
        int ans[] = new int[n];

        Stack<Integer> s = new Stack<>();
        s.push(-1);

        for(int i=arr.size()-1; i>=0; i--){

            while(s.peek() != -1 && arr.get(s.peek()) >= arr.get(i)){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);

        }
    
        return ans;
    }

    public static int[] prevSmallerElement(ArrayList<Integer> arr, int n){
        int ans[] = new int[n];

        Stack<Integer> s = new Stack<>();
        s.push(-1);

        for(int i=0; i<n; i++){

            while(s.peek() != -1 && arr.get(s.peek()) >= arr.get(i)){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);

        }
    
        return ans;
    }
    
    // Time complexity O(n) || Space complexity O(n)
    public static int largestRectangularArea(ArrayList<Integer> heights){

        int n = heights.size();

        int[] next = new int[n];
        next = nextSmallerElement(heights, n);

        int[] prev = new int[n];
        prev = prevSmallerElement(heights, n);

        int area = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int length = heights.get(i);
            
            if(next[i] == -1){
                next[i] = n;
            }
            
            int breadth = next[i] - prev[i] - 1;

            int newArea = length * breadth;
            area = Math.max(newArea, area);
        }

        return area;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(5);
        arr.add(6);
        arr.add(2);
        arr.add(3);

        System.out.println(largestRectangularArea(arr));
    }
}
