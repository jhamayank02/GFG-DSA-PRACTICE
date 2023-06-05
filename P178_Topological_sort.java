import java.util.*;

class P178_Topological_sort{
    public static void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        visited[node] = true;
        
        for(Integer neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, adj, st);
            }
        }
        st.push(node);
    }
    
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // Using DFS
        // Time complexity O(N+E)  || Space complexity O(N)

        // boolean visited[] = new boolean[V];
        // Arrays.fill(visited, false);
        
        // Stack<Integer> st = new Stack<>();
        
        // for(int i=0; i<V; i++){
        //     if(!visited[i]){
        //         dfs(i, visited,adj, st);
        //     }
        // }
        
        // int topologicalSort[] = new int[st.size()];
        // for(int i=0; i<V; i++){
        //     topologicalSort[i] = st.pop();
        // }
        
        // return topologicalSort;





        // Using Kahn's algorithm
        // Time complexity O(N+E)  || Space complexity O(N)
        
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
        int ans[] = new int[V];
        int index = 0;
        
        while(!q.isEmpty()){
            int front = q.poll();
            
            // Store the ans
            ans[index] = front;
            index++;
            
            // Neighbour indegree update
            for(Integer neighbour : adj.get(front)){
                indegree[neighbour]--;
                
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        
        return ans;
    }
    }

    public static void main(String[] args){

    }
}