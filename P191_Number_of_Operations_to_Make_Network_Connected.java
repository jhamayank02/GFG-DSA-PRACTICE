import java.util.*;

class P191_Number_of_Operations_to_Make_Network_Connected{

    public static void makeSet(int n, int parent[], int rank[]){
        for(int i=0; i<n; i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public static int findParent(int node, int parent[]){
        if(parent[node] == node){
            return parent[node];
        }

        return findParent(parent[node], parent);
    }

    public static void makeUnion(int u, int v, int parent[], int rank[]){
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

    public static int findDisconnectedComponents(int n, int parent[]){
        int discComp = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i){
                discComp++;
            }
        }
        return discComp;
    }

    // Using Disjoint Set
    // T.C O(N * E) || S.C O(N)
    public int makeConnected(int n, int[][] connections) {
        int parent[] = new int[n];
        int rank[] = new int[n];

        makeSet(n, parent, rank);

        int cLen = connections.length;
        int extra = 0; // No. of available extra wires

        // T.C O(N * E)
        for(int i=0; i<cLen; i++){
            int u = findParent(connections[i][0], parent);
            int v = findParent(connections[i][1], parent);

            if(u != v){
                makeUnion(u, v, parent, rank);
            }
            else{
                extra++; // Extra wire found
            }
        }

        // Find the no. of disconnected components
        // no. of disconnected components = no. of nodes whose parent are they themselves
        int discComp = findDisconnectedComponents(n, parent);

        // No. of min edges to connect n nodes are (n-1)
        // If available extra wires are enough to connect the disconnected components then return the the required edges
        int minReqWires = discComp - 1;

        if(minReqWires <= extra){
            return minReqWires;
        }
        return -1;

    }


    public static void main(String args[]){

    }
}