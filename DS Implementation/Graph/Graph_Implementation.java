import java.util.*;

class Graph{
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();

    // iDirected - 0 -> Undirected graph
    // isDirected - 1 -> Directed graph
    // Time Complexity O(1) || Space Complexity O(1)
    void addEdge(int u, int v, boolean isDirected){

        // Create an edge b/w u and v
        // System.out.println(adjList.get(u).size() + " Printed ");

        if(!adjList.containsKey(u)){
            adjList.put(u, new ArrayList<Integer>());
        }

        adjList.get(u).add(v);

        if(isDirected == false){

            if(!adjList.containsKey(v)){
                adjList.put(v, new ArrayList<Integer>());
            }
            adjList.get(v).add(u);

        }

    }

    // u - no. of nodes || v - no. of edges
    // Time Complexity O(u*v) || Space Complexity O(1)
    void printAdjList(){
        adjList.forEach((key, value) -> {
                System.out.print(key + " -> ");
                for(Integer i : value){
                    System.out.print(i + " ");
                }
                System.out.println();
            });
        }

    // Time complexity O(nodes+edges) || Space complexity O(nodes)
    public void BFS(int nodes){
        HashMap<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<nodes; i++){
            visited.put(i, false);
        }

        queue.add(0);

        while(queue.size() > 0){

            if(visited.get(queue.peek()) == false){
                System.out.print(queue.peek() + " ");
                visited.put(queue.peek(), true);
            }

            ArrayList<Integer> temp = adjList.get(queue.poll());

            for(Integer i : temp){
                if(visited.get(i) == false){
                    queue.add(i);
                }
            }
        }

        System.out.println();
    }

    int []visitedDFS;
    // Time complexity O(V+E) || Space complexity O(V)
    public void DFS(int startVertex){
        if(visitedDFS[startVertex]==0){
            System.out.print(startVertex + " ");
            visitedDFS[startVertex] = 1;
        }

        ArrayList<Integer> temp = adjList.get(startVertex);
        for(Integer node : temp){
            if(visitedDFS[node] == 0){
                DFS(node);
            }
        }
    }
}


class Graph_Implementation{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("\nEnter the number of nodes : ");
        n = sc.nextInt();

        int m;
        System.out.print("\nEnter the number of edges : ");
        m = sc.nextInt();

        Graph g = new Graph();
        for(int i = 0; i < m; i++){
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();

            g.addEdge(u, v, false);
        }

        sc.close();
        g.printAdjList();
        g.BFS(n);

        g.visitedDFS = new int[n];
        for(int i=0; i<n; i++){
            g.visitedDFS[i] = 0;
        }
        g.DFS(0);
    }
}