public class P24_Find_Missing_And_Repeating {
    public static int[] findTwoElement(int arr[], int n) {
        // code here
        int ans[] = new int[2];

        // For repeating element
        // Use absolute value of elements as index to traverse the array and mark them negative and if  the the value at particular index is already negative then it means that element is repeating
        for(int i=0; i<n; i++){

            if( arr[Math.abs(arr[i])-1] < 0 ){
                ans[0] = Math.abs(arr[i]); // Store the repeating element
            }
            else{
                arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
            }

        }

        // For missing element
        // At which index the value is positive the index+1 is the missing element
        for(int i=0; i<n; i++){
            if(arr[i]>0){
                ans[1] = i+1; // Store the missing element
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int N = 3;
        int Arr[] = {1, 3, 3};

        int ans[] = new int[2];
        ans = findTwoElement(Arr, N);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
