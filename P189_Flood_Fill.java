import java.util.*;

class P189_Flood_Fill{

    public static boolean isValid(int x, int y, int m, int n, int targetColor, boolean visited[][], int image[][]){
        if(x>=0 && x<m && y>=0 && y<n && visited[x][y] == false && image[x][y] == targetColor){
            return true;
        }
        return false;
    }

    public static void dfs(int sr, int sc, int m, int n, int targetColor, int color, boolean visited[][], int ans[][], int image[][]){
        
        // Fill the color and mark the block as visited
        ans[sr][sc] = color;
        visited[sr][sc] = true;

        // Possible positions
        int newX[] = {-1,0,1,0};
        int newY[] = {0,1,0,-1};

        // Check all the positions if they are valid(inside the box and have the target colour which we want to remove)
        for(int i=0; i<4; i++){
            int nx = sr + newX[i];
            int ny = sc + newY[i];

            if(isValid(nx, ny, m, n, targetColor, visited, image)){
                dfs(nx, ny, m, n, targetColor, color, visited, ans, image);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Using DFS
        // T.C O(m*n) || S.C O(m*n)
        // int m = image.length;
        // int n = image[0].length;
        // int ans[][] = new int[m][n];
        // boolean visited[][] = new boolean[m][n];

        // // Intialize the ans array
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         ans[i][j] = image[i][j];
        //         visited[i][j] = false;
        //     }
        // }

        // dfs(sr, sc, m, n, image[sr][sc], color, visited, ans, image);
        
        // return ans;



        // Using BFS
        // T.C O(m*n) || S.C O(m*n)
        int m = image.length;
        int n = image[0].length;
        int targetColor = image[sr][sc];
        int ans[][] = new int[m][n];
        boolean visited[][] = new boolean[m][n];
        Queue<Cell> q = new LinkedList<>();

        // Intialize the ans array
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans[i][j] = image[i][j];
                visited[i][j] = false;
            }
        }

        int newX[] = {-1,0,1,0};
        int newY[] = {0,1,0,-1};

        if(isValid(sr, sc, m, n, targetColor, visited, image)){
            q.add(new Cell(sr, sc));
            ans[sr][sc] = color;
            visited[sr][sc] = true;
        }

        while(!q.isEmpty()){
            Cell curr = q.poll();
            int currX = curr.x;
            int currY = curr.y;

            ans[currX][currY] = color;

            for(int i=0; i<4; i++){

                int nx = currX + newX[i];
                int ny = currY + newY[i];

                if(isValid(nx, ny, m, n, targetColor, visited, image)){
                    visited[nx][ny] = true;
                    q.add(new Cell(nx, ny));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){

    }
}