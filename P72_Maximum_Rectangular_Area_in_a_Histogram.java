import java.util.Stack;

public class P72_Maximum_Rectangular_Area_in_a_Histogram {

    public static int[] nextSmallerElem(long arr[], int n){
        int ans[] = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        
        for(int i=n-1; i>=0; i--){

            long current = arr[i];
            
            while(s.peek() != -1 && arr[s.peek()] >= current){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        
        return ans;
    }
    
    public static int[] prevSmallerElem(long arr[], int n){
        int ans[] = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        
        for(int i=0; i<n; i++){

            long current = arr[i];
            
            while(s.peek() != -1 && arr[s.peek()] >= current){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        
        return ans;
    }
    
    public static long getMaxArea(long hist[], long n) 
    {
        // Approach 1: Bruteforce approach (Using 2 loops) || Time Complexity O(n^2) || Space Complexity O(1)
        // long maxArea = 0;
        
        // for(int i=0; i<n; i++){
            
        //     long breadth = 1;
        //     long length = hist[i];

        //     // Check if we can extend the bar in left
        //     for(int j=i-1; j>=0; j--){
        //         if(hist[j] < hist[i]){
        //             break;
        //         }
        //         else{
        //             breadth++;
        //         }
        //     }


        //     // Check if we can extend the bar in right
        //     for(int k=i+1; k<n; k++){
        //         if(hist[k] < hist[i]){
        //             break;
        //         }
        //         else{
        //             breadth++;
        //         }
        //     }

        //     long area = length * breadth;
        //     maxArea = Math.max(area, maxArea);
        // }


        // return maxArea;




        // Approach 2: Using stack || Time Complexity O(n) || Space Complexity O(n)
        long maxArea = 0;

        int next[] = new int[(int) n];
        next = nextSmallerElem(hist, (int)n);

        
        int prev[] = new int[(int) n];
        prev = prevSmallerElem(hist, (int)n);        
        
        for(int i=0; i<n; i++){

            // Eg -> for array - [2,2,2,2,2]
            if(next[i] == -1){
                next[i] = (int) n;
            }

            long length = hist[i];
            long breadth = next[i] - prev[i] - 1;

            long area = length * breadth;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // long N = 7;
        // long arr[] = {6,2,5,4,5,1,6};
        long N = 8;
        long arr[] = {7, 2, 8, 9, 1, 3, 6, 5};

        System.out.println(getMaxArea(arr, N));
    }
}
