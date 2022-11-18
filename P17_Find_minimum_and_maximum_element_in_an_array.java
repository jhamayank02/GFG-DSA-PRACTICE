public class P17_Find_minimum_and_maximum_element_in_an_array {
    
    public static pair getMinMax(long a[], long n)  
    {
        //Write your code here
        
        int i = 0;
        int j = (int) (n-1);
        
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        while(i<=j){

            if(a[i] < a[j]){
                if(a[i] < min){
                    min = a[i];
                }
                if(a[j] > max){
                    max = a[j];
                }
            }
            else{
                if(a[j] < min){
                    min = a[j];
                }
                if(a[i] > max){
                    max = a[i];
                }
            }
            
            
            i++;
            j--;
        }
        
        pair ans = new pair(min, max);

        return ans;
    }

    public static void main(String[] args) {
        long N = 6;
        long A[] = {3, 2, 1, 56, 10000, 167};

        pair a = getMinMax(A, N);
        a.printPair();
    }
}
