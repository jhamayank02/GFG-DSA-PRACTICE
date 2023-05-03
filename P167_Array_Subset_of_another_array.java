import java.util.HashMap;

class P167_Array_Subset_of_another_array{

    // Time complexity O(n) || Space complexity O(n)
    public static String isSubset(long a1[], long a2[], long n, long m) {
        HashMap<Long, Integer> map = new HashMap<>();
        
        for(int i=0; i<m; i++){
            if(map.containsKey(a2[i])){
                map.put(a2[i], map.get(a2[i])+1);
            }
            else{
                 map.put(a2[i], 1);  
            }
        }
        
        for(int i=0; i<n && !map.isEmpty(); i++){
            if(map.containsKey(a1[i])){
                if(map.get(a1[i]) == 1){
                    map.remove(a1[i]);
                }
                else{
                    map.put(a1[i], map.get(a1[i])-1);
                }
            }
        }
        
        if(map.isEmpty()){
            return "Yes";
        }
        return "No";
    }

    public static void main(String args[]){

    }
}