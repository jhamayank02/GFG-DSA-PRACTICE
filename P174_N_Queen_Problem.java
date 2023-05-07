import java.util.ArrayList;

class P174_N_Queen_Problem{

public static void addSolution(int board[][], ArrayList<ArrayList<Integer>> ans, int n){
        ArrayList<Integer> temp = new ArrayList<>();
        
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         if(board[i][j] == 1)
        //         temp.add(j+1);
        //     }
        // }
        
        for(int col=0; col<n; col++){
            for(int row=0; row<n; row++){
                if(board[row][col] == 1)
                temp.add(row+1);
            }
        }
        
        ans.add(temp);
    }
    
    public static boolean isSafe(int row, int col, int board[][], int n){
        
        int x = row;
        int y = col;
        
        // Check for same row
        while(y >= 0){
            if(board[x][y] == 1){
                return false;
            }
            y--;
        }
        
        // No need to check for same column as we are placing only 1 queen in a column
        
        // Check for diagonal
        x = row;
        y = col;
        while(x >=0 && y>= 0){
            if(board[x][y] == 1){
                return false;
            }
            
            x--;
            y--;
        }
        
        x = row;
        y = col;
        while(x < n && y >= 0){
            if(board[x][y] == 1){
                return false;
            }
            
            x++;
            y--;
        }
        
        return true;
    }
    
    public static void solve(int col, ArrayList<ArrayList<Integer>> ans, int board[][], int n){
        
        // Base case
        if(col == n){
            addSolution(board, ans, n);
            return;
        }
        
        // Solve 1 case and rest Recursion will take care
        
        for(int row=0; row<n; row++){
            if(isSafe(row, col, board, n)){
                // If placing queen is safe
                board[row][col] = 1;
                solve(col+1, ans, board, n);
                // Backtrack
                board[row][col] = 0;
            }
        }
        
    }
    
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        
        // Queen - 1
        // Space - 0
        
        int board[][] = new int[n][n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        solve(0, ans, board, n);
        
        
        
        return ans;
    }

    public static void main(String[] args) {
            
    }
}