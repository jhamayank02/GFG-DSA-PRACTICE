import java.util.*;

class P185_BFS{

    public static void main(String[] args){

        // Iterative code
        // Time complexity O(N+E) || Space complexity O(N)
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()){
            int front = q.poll();
            
            ans.add(front);
            
            for(Integer neighbour : adj.get(front)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        
        return ans;
    }
}