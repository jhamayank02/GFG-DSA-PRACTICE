// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.HashMap;

import java.util.*;

public class P19_First_Repeating_Element {
    
    public static int firstRepeated(int[] arr, int n) {
        // Your code here

        // Approach - 1  --> Time Complexity O(n)  Space Complexity --> O(n)
        // int firstRepeated = Integer.MAX_VALUE;

        // ArrayList<Integer> ansArr = new ArrayList<>();


        // for(int i=0; i<n; i++){
        //     ansArr.add(arr[i]);
        // }

        // for(int i=0; i<n; i++){
        //     if(ansArr.indexOf(arr[i]) == ansArr.lastIndexOf(arr[i])){

        //     }
        //     else{
        //         if(firstRepeated > ansArr.indexOf(arr[i])){
        //             firstRepeated = ansArr.indexOf(arr[i]);
        //         }
        //     }
        // }

        // if(firstRepeated > n){
        //     firstRepeated = -1;
        //     return firstRepeated;
        // }

        // return (firstRepeated+1);



        // Approach 2: --> Time Complexity O(n)  Space Complexity --> O(n)
        HashMap<Integer,Integer> map = new HashMap<>();

        // Store all the elements of the array in the map
        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
        }

        // Now check from starting of the array which first element has iteration more than 1
        for(int i=0; i<n; i++){
            int key = arr[i];

            int iteration = map.get(arr[i]);

            if(iteration > 1){
                return (i+1);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 7;
        int arr[] = {1, 5, 3, 4, 3, 5, 6};

        System.out.println(firstRepeated(arr, n));
    }
}
