import java.util.*;

class P177_Detect_cycle_in_an_undirected_graph{

    public boolean isCyclicDFS(int node, boolean visited[], boolean dfsVisited[], ArrayList<ArrayList<Integer>> adj){
            visited[node] = true;
            dfsVisited[node] = true;
            
            for(Integer neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    boolean cycleDetected = isCyclicDFS(neighbour, visited, dfsVisited, adj);
                    if(cycleDetected == true){
                        return true;
                    }
                }
                else if(visited[neighbour] == true && dfsVisited[neighbour] == true){
                    // Cycle found;
                    return true;
                }
            }
            
            dfsVisited[node] = false;
            return false;
    }
    
    // Function to detect cycle in a directed graph.
    // Time complexity O(N+E) || Space complexity O(N)
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        // boolean visited[] = new boolean[V];
        // Arrays.fill(visited, false);
        
        // boolean dfsVisited[] = new boolean[V];
        // Arrays.fill(dfsVisited, false);
        
        // // To handle disconnected components
        // for(int i=0; i<V; i++){
        //     if(!visited[i]){
        //         boolean cycleFound = isCyclicDFS(i, visited, dfsVisited, adj);
                
        //         if(cycleFound == true){
        //             return true;
        //         }
        //     }
        // }
        
        // return false;




        // Using Kahn's algorithm
        // Time complexity O(N+E) || Space complexity O(N)
        
        // Find indegree of all the node
        int indegree[] = new int[V];
        
        for(ArrayList<Integer> i : adj){
            for(Integer j : i){
                indegree[j]++;
            }
        }
        
        // Find all nodes with 0 indegree and push into the queue
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        // Do BFS
        int count = 0;
        
        while(!q.isEmpty()){
            int front = q.poll();
            
            count++;
            
            // Neighbour indegree update
            for(Integer neighbour : adj.get(front)){
                indegree[neighbour]--;
                
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        
        // Cycle is not present
        if(count == V){
            return false;
        }
        // Cycle is present
        else{
            return true;
        }
    }

    public static void main(String[] args){

    }

}