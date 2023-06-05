import java.util.*;

class P176_Detect_cycle_in_an_undirected_graph{
    
    public static boolean isCyclicBFS(int src, boolean visited[], ArrayList<ArrayList<Integer>> adj){
        
        HashMap<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        
        parent.put(1, -1);
        visited[src] = true;
        q.add(src);
        
        while(!q.isEmpty()){
            int front = q.poll();
            
            for(Integer neighbour : adj.get(front)){
                if(visited[neighbour] == true && neighbour != parent.get(front)){
                    return true;
                }
                else if(!visited[neighbour]){
                    q.add(neighbour);
                    visited[neighbour] = true;
                    parent.put(neighbour, front);
                }
            }
        }
        
        return false;
        
    }
    
    public static boolean isCyclicDFS(int node, int parent, boolean visited[], ArrayList<ArrayList<Integer>> adj){
        
        visited[node] = true;
        
        for(Integer neighbour : adj.get(node)){
            
            if(visited[neighbour] == false){
                boolean cycleDetected = isCyclicDFS(neighbour, node, visited, adj);
                
                if(cycleDetected == true){
                    return true;
                }
            }
            else if(neighbour != parent){
                // cycle present
                return true;
            }
        }
        return false;
    }
    
    // Function to detect cycle in an undirected graph.
    // Time complexity O(V+E) || Space complexity O(V)
    // V -> Vertices || E -> Edges
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean visited[] = new boolean[V];
        
        // Intiliaze visited array
        for(int i=0; i<V; i++){
            visited[i] = false;
        }
        
        // To handle disconnected components
        for(int i=0; i<V; i++){
            if(!visited[i]){
                boolean ans = isCyclicBFS(i, visited, adj);
                // boolean ans = isCyclicDFS(i, -1, visited, adj);
                if(ans == true){
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void main(String args[]){
        int V = 5, E = 5;
        int adj[][] = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
    }
}