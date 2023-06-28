import java.util.*;

class P208_Partition_A_Set_Into_Two_Subsets_With_Minimum_Absolute_Sum_Difference{
    

    public static int minSubsetSumDifference(int[] arr, int n) {
		int totalSum = 0;
		for(int i=0; i<n; i++){
			totalSum += arr[i];
		}

		// Tabulation
        // Time complexity O(n * totalSum) || Space complexity O(n * totalSum)

        // boolean dp[][] = new boolean[n][totalSum+1];

        // for(int i=0; i<n; i++){
        //     dp[i][0] = true;
        // }

        // if(arr[0] <= totalSum){
        //     dp[0][arr[0]] = true;
        // }

        // for(int ind=1; ind<n; ind++){
        //     for(int target=1; target<=totalSum; target++){

        //         boolean not_take = dp[ind-1][target];

        //         boolean take = false;
        //         if(target >= arr[ind]){
        //             take = dp[ind-1][target-arr[ind]];
        //         }

        //         dp[ind][target] = not_take||take;

        //     }
        // }


		// int mini = (int)1e9;

		// for(int i=0; i<=totalSum/2; i++){
		// 	if(dp[n-1][i] == true){
		// 		int s1 = totalSum - i;
		// 		int s2 = totalSum - s1;

		// 		mini = Math.min(Math.abs(s1-s2), mini);
		// 	}
		// }

		// return mini;




        // Tabulation(Space optimized)
        // Time complexity O(n * totalSum) || Space complexity O(totalSum)
        boolean prev[] = new boolean[totalSum+1];

        prev[0] = true;

        if(arr[0] <= totalSum){
            prev[arr[0]] = true;
        }

        for(int ind=1; ind<n; ind++){
            boolean current[] = new boolean[totalSum+1];
            current[0] = true;

            for(int target=1; target<=totalSum; target++){

                boolean not_take = prev[target];

                boolean take = false;
                if(target >= arr[ind]){
                    take = prev[target-arr[ind]];
                }

                current[target] = not_take||take;

            }

            prev = current;
        }

		int mini = (int)1e9;

		for(int i=0; i<=totalSum/2; i++){
			if(prev[i] == true){
				int s1 = totalSum - i;
				int s2 = totalSum - s1;

				mini = Math.min(Math.abs(s1-s2), mini);
			}
		}

		return mini;

	}

    public static void main(String args[]){

    }
}