import java.util.Stack;
import java.util.ArrayList;

public class P64_Max_rectangle_in_binary_matrix_with_all_ones {
    public static int[] nextSmallerElement(int arr[], int n){
        int ans[] = new int[n];

        Stack<Integer> s = new Stack<>();
        s.push(-1);

        for(int i=n-1; i>=0; i--){

            while(s.peek() != -1 && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);

        }
    
        return ans;
    }

    public static int[] prevSmallerElement(int arr[], int n){
        int ans[] = new int[n];

        Stack<Integer> s = new Stack<>();
        s.push(-1);

        for(int i=0; i<n; i++){

            while(s.peek() != -1 && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);

        }
    
        return ans;
    }
    
    public static int largestRectangularArea(int heights[], int n){

        int[] next = new int[n];
        next = nextSmallerElement(heights, n);

        int[] prev = new int[n];
        prev = prevSmallerElement(heights, n);

        int area = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int length = heights[i];
            
            if(next[i] == -1){
                next[i] = n;
            }
            
            int breadth = next[i] - prev[i] - 1;

            int newArea = length * breadth;
            area = Math.max(newArea, area);
        }

        return area;
    }

    // Time complexity O(n*m) || Space complexity O(m) || n -> no. of rows || m -> no. of columns
    public static int maxArea(int M[][], int n, int m){

        // Compute area for first row
        int area = largestRectangularArea(M[0], m);

        // For remaining rows
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){

                // Row update : By adding previous row values
                if(M[i][j] != 0){
                    M[i][j] = M[i][j] + M[i-1][j];
                }
                else{
                    M[i][j] = 0;
                }
            }

            // Entire row is updated now
            area = Math.max(area, largestRectangularArea(M[i], n));
        }

        return area;
    }
    
    public static void main(String[] args) {
        int arr[][] = {{0,1,1,0},
                        {1,1,1,1},
                        {1,1,1,1},
                        {1,1,0,0}};
        System.out.println(maxArea(arr, 4, 4));
    }
}
