import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class P190_Clone_a_graph{

    public static void dfs(Node node, HashMap<Node, Node> map){
        for(Node nbr : node.neighbors){
            if(!map.containsKey(nbr)){
                map.put(nbr, new Node(nbr.val));
                dfs(nbr, map);
            }
            map.get(node).neighbors.add(map.get(nbr));
        }
    }

    public Node cloneGraph(Node node) {
        // Using BFS
        // T.C O(N+E) || S.C O(N)
        // if(node == null){
        //     return null;
        // }

        // HashMap<Node, Node> map = new HashMap<>();
        // Queue<Node> q = new LinkedList<>();

        // q.add(node);
        // map.put(node, new Node(node.val));

        // while(!q.isEmpty()){
        //     Node front = q.poll();

        //     for(Node nbr : front.neighbors){
        //         if(!map.containsKey(nbr)){
        //             map.put(nbr, new Node(nbr.val));
        //             q.add(nbr);
        //         }
        //         map.get(front).neighbors.add(map.get(nbr));
        //     }
        // }

        // return map.get(node);



        // Using DFS
        // T.C O(N+E) || S.C O(N)
        HashMap<Node, Node> map = new HashMap<>();

        if(node == null){
            return null;
        }

        map.put(node, new Node(node.val));
        dfs(node, map);

        return map.get(node);
    }

    public static void main(String[] args){

    }
}