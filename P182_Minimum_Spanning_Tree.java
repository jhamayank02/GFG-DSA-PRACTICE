import java.util.*;

class P182_Minimum_Spanning_Tree{

    static void makeSet(int parent[], int rank[], int V){
        // Initialization
        for(int i=0; i<V; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    static int findParent(int parent[], int node){
        if(parent[node] == node){
            return node;
        }
        
        return parent[node] = findParent(parent, parent[node]);
    }
    
    static void unionSet(int u, int v, int parent[], int rank[]){
        u = findParent(parent, u);
        v = findParent(parent, v);
        
        if(rank[u] < rank[v]){
            parent[u] = v;
            rank[v]++;
        }
        else if(rank[v] < rank[u]){
            parent[v] = u;
            rank[u]++;
        }
        else{
            parent[v] = u;
            rank[u]++;
        }
    }
    
	static int spanningTree(int V, int E, int edges[][]){
	    // Using Kruskal's Algorithm
        // Time complexity O(mlogm) || Space complexity O(n)
	    Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2])); 
	    
	    int parent[] = new int[V];
	    int rank[] = new int[V];
	    makeSet(parent, rank, V);
	    
	    int minWeight = 0;
	
	    
	    for(int i=0; i<edges.length; i++){
	        int u = findParent(parent, edges[i][0]);
	        int v = findParent(parent, edges[i][1]);
	        int wt = edges[i][2];
	        
	        if(u != v){
	            minWeight += wt;
	            unionSet(u, v, parent, rank);
	        }
	    }
	    
	    return minWeight;
	}

    public static void main(String[] args){

    }
}