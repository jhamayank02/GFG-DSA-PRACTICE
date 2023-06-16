import java.util.*;

class P188_Kruskals_algo{

    // T.C O(V)
    public static void makeSet(int V, int parent[], int rank[]){
        Arrays.fill(rank, 0);

        for(int i=0; i<V; i++){
            parent[i] = i;
        }
    }

    // T.C O(V) || S.C O(V)
    public static int findParent(int node, int parent[]){
        if(parent[node] == node){
            return node;
        }

        return findParent(parent[node]);
    }


    // T.C O(1) || S.C O(1)
    public static void makeUnion(int n1, int n2, int parent[], int rank[]){
        int u = n1;
        int v = n2;

        if(rank[u] < rank[v]){
            parent[u] = v;
            rank[v]++;
        }
        else if(rank[u] > rank[v]){
            parent[v] = u;
            rank[u]++;
        }
        else{
            parent[u] = v;
            rank[v]++;
        }
    }

    // T.C O(E*V) || S.C O(V)
    public static int minSpanningTree(int V, int E, int edges[][]){
        // Sorted Array
        int parent[] = new int[V];
        int rank[] = new int[V];

        makeSet(V, parent, rank);

        // T.C O(ElogE)
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        int minWeight = 0;

        // T.C O(E * V)
        for(int i=0; i<edges.length; i++) {

            int n1 = edges[i][0];
            int n2 = edges[i][1];
            int wt = edges[i][2];

            int u = findParent(n1, parent);
            int v = findParent(n2, parent);

            if(u != v){
                makeUnion(u, v, parent, rank);
                minWeight += wt;
            }
        }

        return minWeight;
    }

    public static void main(String args[]){

    }
}