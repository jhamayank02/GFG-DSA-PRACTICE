public class P04_Peak_Element {
    
    public static int peakElement(int[] arr,int n){

        int s = 0;
        int e = n-1;
        int mid = s + (e-s)/2;

        while(s<e){

            if(arr[mid] < arr[mid+1]){
                s = mid + 1;
                mid = s + (e-s)/2;
            }

            else{
                e = mid;
            }

            mid = s + (e-s)/2;

        }

        return s;
    }

    public static void main(String[] args) {
        
        int n = 3;
        int arr[] = {1,2,3};

        System.out.println(peakElement(arr, n));
    }
}
