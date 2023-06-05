import java.util.*;

class Pair{
    int first;
    int second;

    Pair(int a, int b){
        first = a;
        second = b;
    }
}

class P181_Prims_MST{

    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        // Create adjacency list
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();

        for(int i=0; i<g.size(); i++){
            int u = g.get(i).get(0);
            int v = g.get(i).get(1);
            int w = g.get(i).get(2);

            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(new Pair(v,w));
            
            if(!adj.containsKey(v)){
                adj.put(v, new ArrayList<>());
            }    
            adj.get(v).add(new Pair(u,w));
        }

        // n+1 as the graph has nodes starting from 1 and we are taking indices as nodes
        int key[] = new int[n+1];
        int parent[] = new int[n+1];
        boolean mst[] = new boolean[n+1];

        for(int i=0; i<n+1; i++){
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mst[i] = false;
        }

        // Let's start the algo
        key[1] = 0;
        parent[1] = -1;

        for(int i=1; i<n+1; i++){
            int mini = Integer.MAX_VALUE;
            int u = -1;

            // Find the min value
            for(int v=1; v<n+1; v++){
                if(mst[v] == false && key[v] < mini){
                    u = v;
                    mini = key[v];
                }
            }

            // Mark the min node as true
            mst[u] = true;

            // Check its adjacent nodes
            for(Pair neighbour : adj.get(u)){
                int node = neighbour.first;
                int weight = neighbour.second;
                
                if(mst[node] == false && weight < key[node]){
                    parent[node] = u;
                    key[node] = weight;
                } 

            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=2; i<n+1; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(parent[i]);
            temp.add(i);
            temp.add(key[i]);

            result.add(temp);
        }

        return result;
    }

    public static void main(String args[]){

    }

}