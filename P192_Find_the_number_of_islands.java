import java.util.*;

class P192_Find_the_number_of_islands{

    public static boolean isValid(int r, int c, int n, int m, boolean visited[][], int grid[][]){
        if(r>=0 && r<n && c>=0 && c<m && visited[r][c]==false && grid[r][c]==1){
            return true;
        }
        return false;
    }
    
    public static void dfs(int x, int y, int row, int col, boolean visited[][], int grid[][]){
        visited[x][y] = true;
        
        int dx[] = {0,1,1,1,0,-1,-1,-1};
        int dy[] = {1,1,0,-1,-1,-1,0,1};
        
        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(isValid(nx, ny, row, col, visited, grid)){
                dfs(nx, ny, row, col, visited, grid);
            }
        }
    }

    public static void bfs(int x, int y, int row, int col, boolean visited[][], int grid[][]){
        visited[x][y] = true;
        
        int dx[] = {0,1,1,1,0,-1,-1,-1};
        int dy[] = {1,1,0,-1,-1,-1,0,1};
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        
        while(!q.isEmpty()){
            int currX = q.peek().row;
            int currY = q.peek().col;
            q.poll();
            
            for(int i=0; i<8; i++){
                int nx = currX + dx[i];
                int ny = currY + dy[i];
            
                if(isValid(nx, ny, row, col, visited, grid)){
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length; // Row
        int m = grid[0].length; // Column
        
        boolean visited[][] = new boolean[n][m];
        int gridInt[][] = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                gridInt[i][j] = Character.getNumericValue(grid[i][j]);
                visited[i][j] = false;
            }
        }
        
        int numIslands = 0;
        
        // T.C. O(N*M) || S.C O(N*M)
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isValid(i, j, n, m, visited, gridInt)){
                    numIslands++;

                    // Using DFS
                    dfs(i, j, n, m, visited, gridInt);

                    // Using BFS
                    bfs(i, j, n, m, visited, gridInt);
                }
            }
        }
        
        return numIslands;
    }

    public static void main(String args[]){

    }
}