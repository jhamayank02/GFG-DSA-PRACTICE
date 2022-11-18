import java.util.HashMap;

public class P16_Key_Pair {
    
    public static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        boolean result = false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){

            int element = x - arr[i];

            if(map.containsKey(element)){
                result = true;
                return result;
            }
            else{
                map.put(arr[i], 1);
            }

        }



        return result;
    }

    public static void main(String[] args) {
        int N = 6, X = 16;
        int Arr[] = {1, 4, 45, 6, 10, 8};

        System.out.println(hasArrayTwoCandidates(Arr, N, X));
    }
}
