import java.util.Arrays;

class P01_Missing_number_in_array{

    public static int MissingNumber(int array[], int n) {
        // Your Code Here
        
        Arrays.sort(array);
        
        int missingNum = 0;
        
        for(int i = 0; i<n-1; i++){
            
            missingNum = i+1;
            
            if(!(array[i] == (i+1))){
                return missingNum;
            }
            
        }
        
        return ++missingNum;
    }

    public static void main(String[] args) {
        int arr[] = {1};

        int ans = MissingNumber(arr, 2);
        System.out.println("Printing the result:-");
        System.out.println(ans);
    }

}