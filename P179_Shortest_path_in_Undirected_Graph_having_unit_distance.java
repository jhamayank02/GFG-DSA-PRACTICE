class P179_Shortest_path_in_Undirected_Graph_having_unit_distance{

    // Using BFS
    // Time complexity O() || Space complexity O(N)
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        // Create a adjacency list
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        
        for(int i=0; i<edges.length; i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(!adjList.containsKey(u)){
                adjList.put(u, new ArrayList<Integer>());
            }
            adjList.get(u).add(v);
            
            if(!adjList.containsKey(v)){
                adjList.put(v, new ArrayList<Integer>());
            }
            adjList.get(v).add(u);
        }
        
        
        // Do BFS
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited.put(src, true);
        parent.put(src, -1);
        
        while(!q.isEmpty()){
            int front = q.poll();
            
            if(adjList.get(front) != null){
                for(Integer neighbour : adjList.get(front)){
                    
                    // If the neighbour is not visited
                    if(!visited.containsKey(neighbour)){
                        visited.put(neighbour, true);
                        parent.put(neighbour, front);
                        q.add(neighbour);
                    }
                    
                }
            }
            
            
        }
        
        // Prepare shortest path
        int distance[] = new int[n];
        
        outer: for(int i=0; i<n; i++){
            
            int dist = 0;
            int dest = i;
            
            while(dest != src){
                dist++;
                if(parent.get(dest) == null){
                    distance[i] = -1;
                    continue outer;
                }
                dest = parent.get(dest);
            }
            
            distance[i] = dist;
        }
        
        
        return distance;
    }

    public static void main(String[] args){

    }

}