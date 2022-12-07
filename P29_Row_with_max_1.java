public class P29_Row_with_max_1 {
    
    public static int rowWithMax1s(int arr[][], int n, int m) {
        // code here

        // Approach 1 --> Time Complexity - O(n*m) - O(n) [m is constant]
        int result = -1;
        int no_of_1 = 0;

        for (int i = 0; i < arr.length; i++) {
            for(int j =0; j<arr[i].length; j++){
                if(arr[i][j] == 1){
                    if(no_of_1 < m-j){
                        result = i;
                        no_of_1 = m-j;
                    }
                    break;
                }
            }
        }


        return result;

    }

    public static void main(String[] args) {
        int N = 4 , M = 4;
        int Arr[][] = {{0, 1, 1, 1},
                       {0, 0, 1, 1},
                       {1, 1, 1, 1},
                       {0, 0, 0, 0}};

        // int N = 2, M = 2;
        // int Arr[][] = {{0, 0}, {1, 1}};

        // int N = 3, M = 9;
        // int Arr[][] = {{0, 0, 0, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1, 1}};

        System.out.println(rowWithMax1s(Arr, N, M));
    }
}
