import java.util.HashMap;

class P11_Check_if_two_arrays_are_equal_or_not{

    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here

        // USING MAP
        // Time Complexity --> O(n)
        // Space Complexity ~= O(n) (~= -> Approx)

        HashMap<Long, Integer> map = new HashMap<>();

        // Store the frequency of the elements of array A in the map
        for(int i=0; i<N; i++){
            if(map.get(A[i])==null){
                map.put(A[i], 0);
            }
            map.put(A[i], map.get(A[i])+1);
        }

        // Now check if all elements of array B is present in Map with same frequency as of array A
        for(int i=0; i<N; i++){
            if(map.get(B[i])==null || map.get(B[i])==0){ // If element is not present or frequency is 0 means array A and B are not equal
                return false;
            }
            map.put(B[i], map.get(B[i])-1); // Reduce the frequency by 1
        }

        return true;
    }

    public static void main(String[] args) {
        // int N = 5;
        // long A[] = {1,2,5,4,0};
        // long B[] = {2,4,5,0,1};

        int N = 3;
        long A[] = {1,2,5};
        long B[] = {2,4,15};

        System.out.println(check(A, B, N));
    }
}