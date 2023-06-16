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

    public static void dfs(int r, int c, boolean visited[][], ArrayList<String> ans, int m[][], int n, String path){
        
        // Check if the row and col denotes a valid index
        if(r < 0 || r >= n || c < 0 || c >= n){
            return;
        }
        
        // Check if there is a path or not and if the block is visited
        if(m[r][c] == 0 || visited[r][c] == true){
            return;
        }
        
        // Mark the row and col visited
        visited[r][c] = true;
        
        // Check if the rat reached the destination then add the path in the ans
        if(r == n-1 && c == n-1){
            ans.add(path);
        }
        
        // Find paths in the alphabetical order D,L,R,U so that we don't have to sort them later
        dfs(r+1, c, visited, ans, m, n, path+'D');
        dfs(r, c-1, visited, ans, m, n, path+'L');
        dfs(r, c+1, visited, ans, m, n, path+'R');
        dfs(r-1, c, visited, ans, m, n, path+'U');
        
        // Mark the row and col not visited
        visited[r][c] = false;
    }
    
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Time complexity O(4^n^2) || Space complexity O(n*n)
        
        // ArrayList<String> ans = new ArrayList<>();
        // boolean visited[][] = new boolean[n][n];
        // String path = "";
        
        // if(m[0][0] == 0){
        //     return ans;
        // }
        
        // solve(0, 0, m, n, ans, visited, path);
        
        
        // return ans; 






        // Using DFS
        // T.C O((n^2)^4) || S.C O(No. of the paths * length of the paths)
        boolean visited[][] = new boolean[n][n];
        
        // T.C O(n^2)
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                visited[i][j] = false;
            }
        }
        
        ArrayList<String> ans = new ArrayList<>();
        
        dfs(0, 0, visited, ans, m, n, "");
        
        return ans;
    }

    public static void main(String[] args) {
    
    }
}