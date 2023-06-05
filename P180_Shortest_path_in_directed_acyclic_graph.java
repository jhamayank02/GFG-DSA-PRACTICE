import java.util.*;

class Pair{
    int first;
    int second;

    Pair(int a, int b){
        first = a;
        second = b;
    }
}

class Graph{
    HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();

    public void addEdge(int u, int v, int weight){

        Pair p = new Pair(v, weight);
        
        if(!adj.containsKey(u)){
            adj.put(u, new ArrayList<>());
        }
        adj.get(u).add(p);
    }

    public void printAdj(){
        adj.forEach((key, value) -> {
                System.out.print(key + " -> ");
                for(Pair p : value){
                    System.out.print("[" + p.first + " " + p.second + "] ");
                }

                System.out.println();
            });
    }

    public void dfs(int node, boolean visited[], Stack<Integer> st){
        visited[node] = true;


        if(adj.containsKey(node)){
            for(Pair neighbour : adj.get(node)){
                if(!visited[neighbour.first]){
                    dfs(neighbour.first, visited, st);
                }
            }
        }

        st.add(node);
    }

    // Time complexity O(N+E) || Space complexity O(N)
    public void getShortestPath(int src, int distance[], Stack<Integer> st){

        distance[src] = 0;

        while(!st.isEmpty()){
            int top = st.pop();

            if(distance[top] != Integer.MAX_VALUE){
                if(adj.containsKey(top)){
                    for(Pair neighbour : adj.get(top)){
                        if(distance[top] + neighbour.second < distance[neighbour.first]){
                            distance[neighbour.first] = distance[top] + neighbour.second;
                        }
                    }
                }
            }

        }

    }
}

class P180_Shortest_path_in_directed_acyclic_graph{

    public static void main(String[] args){
        Graph g = new Graph();
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 6);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        g.printAdj();


        // Topological sort
        int nodes = 6;
        boolean visited[] = new boolean[nodes];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<nodes; i++){
            if(!visited[i]){
                g.dfs(i, visited, st);
            }
        }

        int src = 1;
        int distance[] = new int[nodes];

        for(int i=0; i<nodes; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        g.getShortestPath(1, distance, st);
        
        System.out.print("Shortest path -> ");
        for(int i=0; i<nodes; i++){
            System.out.print(distance[i] + " ");
        }
        System.out.println();

    }
}