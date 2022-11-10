import java.util.Arrays;
import java.util.Collections;

public class P03_Two_numbers_with_odd_occurrences {
    
    public static int[] twoOddNum(int Arr[], int N)
    {
        // code here
        int ans[] = new int[2];

        Arrays.sort(Arr);

        int occurenceCounter = 0; // Counts the occurence of the elements
        int ansArrIndex = 0; // Tracks the index of ans array
        int prevNum = Arr[0]; // Stores the previous element
        occurenceCounter++;

        for(int i = 1; i < N; i++){
            
            // If previous element and current elements is equal than increase the occurence by 1
            if(prevNum == Arr[i]){
                occurenceCounter++;
            }

            // If previous element and current elements is not equal than check the occurence if it is even do nothing and if it is odd add it to the ans array
            else{
                if(occurenceCounter%2 != 0){
                    ans[ansArrIndex] = prevNum;
                    ansArrIndex++;
                }

                // Now reset the previous numbet to the current element
                prevNum = Arr[i];
                occurenceCounter = 1;
            }
        }

        // Check the occurence of the last element of the array whether it is even or odd
        if(occurenceCounter%2 != 0){
            ans[ansArrIndex] = prevNum;
            ansArrIndex++;
        }

        // Sort the array in descending order
        int temp = ans[0];
        ans[0] = ans[1];
        ans[1] = temp;

        return ans;
    }

    public static void main(String[] args) {
        int n = 8;
        int arr[] = {4, 2, 4, 5, 2, 3, 3, 1};
        // After Sorting :- {1,2,2,3,3,4,4,5}

        int ans[] = twoOddNum(arr, n);

        System.out.println("Printing the array:-");
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
