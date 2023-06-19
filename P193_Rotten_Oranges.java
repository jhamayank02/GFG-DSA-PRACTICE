import java.util.*;

class Info{
    int row, col, time;
    
    Info(int r, int c, int t){
        row = r;
        col = c;
        time = t;
    }
}

class P193_Rotten_Oranges{

    public static boolean isValid(int x, int y, int n, int m, int visited[][], int grid[][]){
        // Return true, if the row and col is inside the matrix, not visited yet and contains a fresh orange
        if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1 && visited[x][y]!=2 ){
            return true;
        }
        return false;
    }
    
    //Function to find minimum time required to rot all oranges. 
    // Using BFS
    // Time complexity O(N*M) || Space complexity O(N*M)
    public int orangesRotting(int[][] grid)
    {
        int n = grid.length; // Row
        int m = grid[0].length; // Column
        
        int visited[][] = new int[n][m];
        Queue<Info> q = new LinkedList<>();
        
        // Possible directions
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        
        // To track the no. of fresh oranges
        int freshCnt = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // If oranges are rotten, push them in the queue and mark them as visited
                if(grid[i][j] == 2){
                    visited[i][j] = 2;
                    q.add(new Info(i, j, 0));
                }
                // Else mark them as unvisited
                else{
                    visited[i][j] = 0;
                }
                
                // If there is fresh orange, increment the freshCnt
                if(grid[i][j] == 1){
                    freshCnt++;
                }
            }
        }
        
        // To track the no. of oranges we have rotten
        int cnt = 0;
        // Time required to rotten the oranges
        int time = 0;
        
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.poll();
            
            time = Math.max(time, t);
            
            for(int i=0; i<4; i++){
                int nx = r + dx[i];
                int ny = c + dy[i];
                
                if(isValid(nx, ny, n, m, visited, grid)){
                    q.add(new Info(nx, ny, t+1));
                    visited[nx][ny] = 2;
                    cnt++;
                }
            }
        }
        
        // If all the fresh oranges have not been rotten then return -1 as there are some fresh oranges which are not reachable
        if(cnt != freshCnt){
            return -1;
        }
        
        return time;
    }

    public static void main(String args[]){

    }
}