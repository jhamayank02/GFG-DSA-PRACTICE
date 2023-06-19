import java.util.*;

class Pair{
    int row, col;
    
    Pair(int r, int c){
        row = r;
        col = c;
    }
}

class P194_Find_whether_path_exist{

    public static boolean dfs(int x, int y, int destRow, int destCol, int n, int visited[][], int grid[][]){
    visited[x][y] = 1;
    
    int dx[] = {0,1,0,-1};
    int dy[] = {1,0,-1,0};
    
    for(int i=0; i<4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        
        // Reached the destination
        if(nx == destRow && ny == destCol){
            return true;
        }
        
        if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 3 && visited[nx][ny] == 0){
            boolean exists = dfs(nx, ny, destRow, destCol, n, visited, grid);
            if(exists == true){
                return true;
            }
        }
    }
    
    return false;
}
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        int n = grid.length;    
        int[][] visited = new int[n][n];
        
        int srcRow = -1;
        int srcCol = -1;
        int destRow = -1;
        int destCol = -1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                visited[i][j] = 0;
                
                // Source found
                if(grid[i][j] == 1){
                    srcRow = i;
                    srcCol = j;
                }
                // Destination found
                if(grid[i][j] == 2){
                    destRow = i;
                    destCol = j;
                }
            }
        }
        
        // Using BFS
        // Time complexity O(n^2) || Space complexity O(n^2)

        // Queue<Pair> q = new LinkedList<>();
        // q.add(new Pair(srcRow, srcCol));
        
        // int dx[] = {0,1,0,-1};
        // int dy[] = {1,0,-1,0};
        
        // while(!q.isEmpty()){
        //     int r = q.peek().row;
        //     int c = q.peek().col;
        //     q.poll();
            
        //     for(int i=0; i<4; i++){
        //         int nx = r + dx[i];
        //         int ny = c + dy[i];
                
        //         // Reached the destination
        //         if(nx == destRow && ny == destCol){
        //             return true;
        //         }
                
        //         if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 3 && visited[nx][ny] == 0){
        //             q.add(new Pair(nx, ny));
        //             visited[nx][ny] = 1;
        //         }
        //     }
        // }
        
        // return false;
        
        
        // Using DFS
        // Time complexity O(n^2) || Space complexity O(n^2)
        return dfs(srcRow, srcCol, destRow, destCol, n, visited, grid);
    }

    public static void main(String args[]){

    }
}