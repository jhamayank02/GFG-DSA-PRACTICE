class P168_Zero_Sum_Subarrays{
    
    // Time complexity O(n) || Space complexity O(n)
    public static long findSubarray(long[] arr ,int n) 
    {
        HashMap<Long, Integer> map = new HashMap<>();
        
        map.put(0l, 1);
        
        long count = 0;
        long sum = 0;
        
        for(int i=0; i<n; i++){
            sum += arr[i];
            
            if(map.containsKey(sum)){
                count += map.get(sum);
                map.put(sum, map.get(sum)+1);
            }
            else{
                map.put(sum, 1);
            }
        }
        
        return count;
    }

    public static void main(String[] args){

    }
}