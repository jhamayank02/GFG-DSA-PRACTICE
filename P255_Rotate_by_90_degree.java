class P255_Rotate_by_90_degree{

        public static void swap(int r1, int c1, int r2, int c2, int arr[][]){
        int temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }
    
    //Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][], int n) 
    { 
        // Bruteforce approach (Using extra space)
        // T.C O(n^2) || S.C O(n^2)
        // int ans[][] = new int[n][n];
        
        // for(int i=0; i<n; i++){
        //     for(int j=n-1; j>=0; j--){
                
        //         ans[i][j] = matrix[j][n-1-i];
                
        //     }
        // }
        
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
                
        //         matrix[i][j] = ans[i][j];
                
        //     }
        // }

        
        
        // Optimal approach (without using extra space)
        // T.C O(n^2) || S.C O(1)
        // Find Transpose
        for(int r=0; r<n-1; r++){
            for(int c=r+1; c<n; c++){
                swap(r, c, c, r, matrix);
            }
        }
        
        // Reverse the order of the rows
        int top = 0;
        int bottom = n-1;
        
        while(top<bottom){
            for(int col=0; col<n; col++){
                swap(top, col, bottom, col, matrix);
            }
            
            top++;
            bottom--;
        }
        
    }

    public static void main(String args[]){

    }
}