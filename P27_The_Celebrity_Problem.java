public class P27_The_Celebrity_Problem {
    
    public static int celebrity(int M[][], int n)
    {
    	// code here

        //  Approach 1 -> Time Complexity - O(N^2)
        // Rules - There should be only one celebrity in the party else return -1

        // In our approach we are trying to find the array which doesn't contain 1
        int celebrity = -1;


        for(int i=0; i<n; i++){

            for(int j=0; j < M[i].length; j++){

                // If array contains 1 jump to the next array
                if(M[i][j] == 1){
                    break;
                }

                // If it's the last element of array(element of 2d array) then check if the last element is not 1 then i is the celebrity
                else if(M[i].length-1 == j){
                    if(M[i][j] == 0){

                        // If celebrity is not -1 then it means there exists another celebrity or we can say there are more than one array which doesn't contains 1 so return -1
                        if(celebrity != -1){
                            return -1;
                        }
                        celebrity = i;
                    }
                }

            }

        }

        return celebrity;

    }

    public static void main(String[] args) {
        // int N = 3;
        // int M[][] = {{0, 1, 0},
        //              {0, 0, 0}, 
        //              {0, 1, 0}};
        int N = 3;
        int M[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        

        // int N = 2;
        // int M[][] = {{0, 1},
        //              {1, 0}};

        System.out.println(celebrity(M, N));
    }
}
