import java.util.*;

class P184_Distance_from_the_Source_Bellman_Ford_Algorithm{

    // Time complexity O(N*E) || Space complexity O(N)
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int distance[] = new int[V];
        Arrays.fill(distance, (int)1e8);
        
        distance[S] = 0;
        
        for(int i=0; i<V-1; i++){
            // Traverse edge list
            for(int j=0; j<edges.size(); j++){
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);
                
                if(distance[u] != 1e8 && (distance[u] + wt < distance[v])){
                    distance[v] = distance[u] + wt;
                }
            }
        }
        
        // Check for negative cycle
        boolean flag = false;
        
        for(int i=0; i<edges.size(); i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int wt = edges.get(i).get(2);
            
            if(distance[u] != 1e8 && (distance[u] + wt < distance[v])){
                distance[v] = distance[u] + wt;
                flag = true;
            }
        }
        
        if(flag == false){
            return distance;
        }
        else{
            int ans[] = {-1};
            return ans;
        }
    }

    public static void main(String args[]){

    }
}