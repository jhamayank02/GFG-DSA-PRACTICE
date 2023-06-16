#include<bits/stdc++.h>
using namespace std;

class Solution{
    public:
	// Using Set
    // Time complexity O(ElogV) || Space complexity O(E+V)
    vector <int> dijkstra(int V, vector<vector<int>> adj[], int S)
    {
        set<pair<int, int>> st;
        vector<int> distance(V, 1e9);
        
        st.insert({0, S});
        distance[S] = 0;
        
        while(!st.empty()){
            auto it = *(st.begin());
            int node = it.second;
            int dis = it.first;
            st.erase(it);
            
            for(auto it : adj[node]){
                int adjNode = it[0];
                int edgWt = it[1];
                
                if(dis + edgWt < distance[adjNode]){
                    // Erase if it existed
                    if(distance[adjNode] != 1e9){
                        st.erase({distance[adjNode], adjNode});
                    }
                    
                    distance[adjNode] = dis + edgWt;
                    st.insert({distance[adjNode], adjNode});
                }
            }
        }
        
        return distance;
    }
    };