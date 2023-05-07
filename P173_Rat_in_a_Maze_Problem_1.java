import java.util.ArrayList;

class P173_Rat_in_a_Maze_Problem_1{

    public static boolean isSafe(int newx, int newy, boolean visited[][], int arr[][], int n){
        if((newx >= 0 && newx < n) && (newy >= 0 && newy < n) && visited[newx][newy] == false && arr[newx][newy] == 1){
            return true;
        }
        return false;
    }
    
    public static void solve(int x, int y, int arr[][], int n, ArrayList<String> ans, boolean visited[][], String path){
        // Base case
        // Destination Reached
        if(x == n-1 && y == n-1){
            ans.add(path);
            return;
        }
        
        // 4 movements
        // D, L, R, U -> Lexicographical order
        
        // Down
        if(isSafe(x+1, y, visited, arr, n)){
            visited[x][y] = true;
            solve(x+1, y, arr, n, ans, visited, path+'D');
            visited[x][y] = false;
        }
        
        
        // Left
        if(isSafe(x, y-1, visited, arr, n)){
            visited[x][y] = true;
            solve(x, y-1, arr, n, ans, visited, path+'L');
            visited[x][y] = false;
        }
        
        
        // Right
        if(isSafe(x, y+1, visited, arr, n)){
            visited[x][y] = true;
            solve(x, y+1, arr, n, ans, visited, path+'R');
            visited[x][y] = false;
        }
        
        
        // up
        if(isSafe(x-1, y, visited, arr, n)){
            visited[x][y] = true;
            solve(x-1, y, arr, n, ans, visited, path+'U');
            visited[x][y] = false;
        }
    }
    
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Time complexity O(4^n^2) || Space complexity O(n*n)
        
        ArrayList<String> ans = new ArrayList<>();
        boolean visited[][] = new boolean[n][n];
        String path = "";
        
        if(m[0][0] == 0){
            return ans;
        }
        
        solve(0, 0, m, n, ans, visited, path);
        
        
        return ans; 
    }

    public static void main(String[] args) {
    
    }
}