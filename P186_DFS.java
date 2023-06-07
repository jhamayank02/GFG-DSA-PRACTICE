import java.util.*;

class P186_DFS{

    public static void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
        
        visited[node] = true;
        ans.add(node);
        
        for(Integer neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, adj, ans);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        // Recursive approach
        // Time complexity O(N+E) || Space complexity O(N)
        ArrayList<Integer> ans = new ArrayList<>();
        
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(i, visited, adj, ans);
            }
        }
        
        return ans;
    }

    public static void main(String[] args){

    }
}