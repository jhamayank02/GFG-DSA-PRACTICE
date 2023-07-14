import java.util.*;

class P252_Two_sum{

    public int[] twoSum(int[] nums, int target) {
        // Using HashMap
        // Time complexity O(n) || Space complexity O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];

        int n = nums.length;

        for(int i=0; i<n; i++){
            int req = target - nums[i];

            if(map.containsKey(req)){
                ans[0] = i;
                ans[1] = map.get(req);

                return ans;
            }
            else{
                map.put(nums[i], i);
            }
        }

        return ans;


        // Using sorting and two pointer approach
        // Time complexity O(nlogn) || Space complexity O(1)

        // Arrays.sort(nums);
        // int ans[] = new int[2];
        // int n = nums.length;
        // int i = 0;
        // int j = n-1;

        // while(i<j){
        //     int sum = nums[i] + nums[j];

        //     if(sum == target){
        //         ans[0] = nums[i];
        //         ans[1] = nums[j];
        //         return ans;
        //     }
        //     else if(sum > target){
        //         j--;
        //     }
        //     else{
        //         i++;
        //     }
        // }

        // return ans;
    }

    public static void main(String args[]){

    }
}