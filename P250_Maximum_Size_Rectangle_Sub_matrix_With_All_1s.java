import java.util.*;

class P250_Maximum_Size_Rectangle_Sub_matrix_With_All_1s{

    public static int largestRectangularArea(int heights[], int n){
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && (i == n || heights[i] <= heights[st.peek()])){
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i - st.peek() - 1;
                }
                int area = height * width;

                maxArea = Math.max(area, maxArea);
            }

            st.push(i);
        }
        
        return maxArea;
    }

    // Tabulation
    // Time complexity O(n * (m+n)) || Space complexity O(m)
	public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
		
		int heights[] = new int[m];
		int maxArea = 0;

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){

				if(mat[i][j] == 1){
					heights[j]++;
				}
				else{
					heights[j] = 0;
				}

			}
			int area = largestRectangularArea(heights, m);
			maxArea = Math.max(area, maxArea);
		}

		return maxArea;
	}	

    public static void main(String args[]){

    }
}