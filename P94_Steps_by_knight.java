import java.util.LinkedList;
import java.util.Queue;

// import javafx.util.Pair;


public class P94_Steps_by_knight {
    static class Cell{
        int x, y;
    
        Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean isValid(int nx, int ny, int N, boolean visited[][]){
        if(nx < N && ny < N && nx >=0 && ny >= 0 && visited[nx][ny] != true){
            return true;
        }
        return false;
    }

    static public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int ans = 0;

        // Convert 1-based indexing to 0-based indexing
        int kx = KnightPos[0]-1;
        int ky = KnightPos[1]-1;

        int tx = TargetPos[0]-1;
        int ty = TargetPos[1]-1;

        boolean visited[][] = new boolean[N][N];
        Queue<Cell> q = new LinkedList<>();

        // x and y direction, where a knight can move
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

        // Push starting position of the knight in the queue
        q.add(new Cell(kx, ky));
        // Mark the starting position as visited
        visited[kx][ky] = true;

        // Check if already on the target position
        if(kx == tx && ky == ty){
            return ans;
        }

        while(!q.isEmpty()){
            int size = q.size();
            ans++;

            while(size != 0){
                Cell c = q.peek();
                q.remove();

                int xx = c.x;
                int yy = c.y;

                for(int i=0; i<8; i++){
                    int nx = xx + dx[i];
                    int ny = yy + dy[i];

                    if(nx == tx && ny == ty){
                        return ans;
                    }

                    if(isValid(nx, ny, N, visited)){
                        q.add(new Cell(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
                size--;
            }
        }


        return ans;
    }
    public static void main(String[] args) {
        int N=6;
        int knightPos[] = {4, 5};
        int targetPos[] = {1, 1};

        System.out.println(minStepToReachTarget(knightPos, targetPos, N));
    }
}
