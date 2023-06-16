import java.util.*;

class Pair{
    int node, dist;
    
    Pair(int a, int b){
        node = a;
        dist = b;
    }
}

class P187_Dijkstras_algorithm{

    // Using Priority Queue
    // Time complexity O(ElogV) || Space complexity O(E+V)
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int distance[] = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        // <node, distance>
        pq.add(new Pair(S, distance[S]));
        
        while(!pq.isEmpty()){
            
            Pair current = pq.poll();
            int currNode = current.node;
            int currDist = current.dist;
            
            for(ArrayList<Integer> nbr : adj.get(currNode)){
                int nbrNode = nbr.get(0);
                int nbrDistance = nbr.get(1);
                
                if(currDist + nbrDistance < distance[nbrNode]){
                    distance[nbrNode] = currDist + nbrDistance;
                    pq.add(new Pair(nbrNode, distance[nbrNode]));
                }
            }
        }
        
        return distance;
    }

    public static void main(Strint args[]){

    }
}