import java.util.Arrays;

public class P101_Min_sum_formed_by_digits {
    
    public static long minSum(int arr[], int n)
    {
        // Time complexity O(nlogn) || Space complexity O(1)
        Arrays.sort(arr);
        String num1 = "", num2 = "";

        for(int i=0; i<n; i++){
            if(i%2 == 0){
                num1 += arr[i];
            }
            else{
                num2 += arr[i];
            }
        }
        
        String sum = "";
        int carry = 0;

        while(num1.length() > 0 || num2.length() > 0 || carry != 0){
            int val1 = 0;
            if(num1.length() > 0){
                val1 = num1.charAt(num1.length()-1) - '0';
                num1 = num1.substring(0, num1.length()-1);
            }

            int val2 = 0;
            if(num2.length() > 0){
                val2 = num2.charAt(num2.length()-1) - '0';
                num2 = num2.substring(0, num2.length()-1);
            }

            int temp = carry + val1 + val2;
            carry = temp / 10;
            sum = (temp % 10) + sum;
        }

        return Long.parseLong(sum);
    }

    public static void main(String[] args) {
        int N = 6;
        int arr[] = {6, 8, 4, 5, 2, 3};

        System.out.println(minSum(arr, N));
    }
}
