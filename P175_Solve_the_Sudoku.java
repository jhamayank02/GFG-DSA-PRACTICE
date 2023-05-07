import java.util.ArrayList;

class P175_Solve_the_Sudoku{

     public static boolean isSafe(int row, int col, int grid[][], int val){
        
        for(int i=0; i<grid.length; i++){
            
            // row check
            if(grid[row][i] == val){
                return false;
            }
            
            // col check
            if(grid[i][col] == val){
                return false;
            }
            
            // 3*3 matrix check
            if(grid[3*(row/3) + i/3][3*(col/3) + i%3] == val){
                return false;
            }
        }
        
        return true;
    }
    
    // Time complexity O(9^m) m-> no. of empty cells  || Space complexity O(81)-> O(1) As there can be maximum 9*9 = 81 recursive calls
    static boolean SolveSudoku(int grid[][])
    {
        
        int n = grid.length;
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                
                // Is cell empty?
                if(grid[row][col] == 0){
                    
                    for(int val = 1; val <= 9; val++){
                        if(isSafe(row, col, grid, val)){
                            grid[row][col] = val;
                            
                            // Recursive call
                            boolean solutionPossibleAhead = SolveSudoku(grid);
                            
                            if(solutionPossibleAhead == true){
                                return true;
                            }
                            else{
                                // Backtrack
                                grid[row][col] = 0;
                            }
                        }
                        
                    }
                    return false;
                    
                }
                
            }
        }
        
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid.length; col++){
                
                System.out.print(grid[row][col] + " ");
                
            }
        }
    }

    public static void main(String[] args){

    }
}