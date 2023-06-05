import java.util.*;

class P183_Strongly_Connected_Components_Kosarajus_Algo{

    public static void dfs(int node, boolean visited[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        
        visited[node] = true;
        
        for(Integer nbr : adj.get(node)){
            if(!visited[nbr]){
               dfs(nbr, visited, st, adj);
           }
        }
        
        st.add(node);
    }
    
    public static void revDfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adjTranspose){
        visited[node] = true;
        
        for(Integer nbr : adjTranspose.get(node)){
            if(!visited[nbr]){
               revDfs(nbr, visited, adjTranspose);
           }
        }
    }
    
    //Function to find number of strongly connected components in the graph.
    // Time complexity O(N+E) || Space complexity O(N+E)
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
       // Step 1: Topological sort
       Stack<Integer> st = new Stack<>();
       boolean visited[] = new boolean[V];
       Arrays.fill(visited, false);
       
       for(int i=0; i<V; i++){
           if(!visited[i]){
               dfs(i, visited, st, adj);
           }
       }
       
       
       // Step 2: Create a transpose graph
       
       ArrayList<ArrayList<Integer>> adjTranspose = new ArrayList<>();
       
       for(int i=0; i<V; i++){
           adjTranspose.add(new ArrayList<Integer>());
       }
       
       for(int i=0; i<V; i++){
           
           visited[i] = false;
           
           for(Integer nbr : adj.get(i)){
                adjTranspose.get(nbr).add(i);
           }
       }
       
       // Step 3: DFS calling using the above ordering
       int count = 0;
       
       while(!st.isEmpty()){
           int top = st.pop();
           
           if(!visited[top]){
               count++;
               revDfs(top, visited, adjTranspose);
           }
           
       }
       
       return count;
    }
    
    public static void main(String[] args){

    }
}