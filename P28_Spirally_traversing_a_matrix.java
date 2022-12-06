import java.util.ArrayList;

public class P28_Spirally_traversing_a_matrix {
    
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();

        int firstRow = 0;
        int firstCol = 0;
        int lastRow = r-1;
        int lastCol = c-1;

        while(firstRow <= lastRow && firstCol <= lastCol){
            // For first row
            for(int i=firstCol; i<=lastCol; i++){
                ans.add(matrix[firstRow][i]);
            }
            firstRow++;

            // For last column
            for(int j=firstRow; j<=lastRow; j++){
                ans.add(matrix[j][lastCol]);
            }
            lastCol--;

            // For last row
            if(firstRow <= lastRow){
                for(int i=lastCol; i>=firstCol; i--){
                    ans.add(matrix[lastRow][i]);
                }
                lastRow--;
            }

            // For first column
            if(firstCol <= lastCol){
                for(int j=lastRow; j>=firstRow; j--){
                ans.add(matrix[j][firstCol]);
                }
                firstCol++;
            }
            
        }

        return ans;
    }

    public static void main(String[] args) {
        // int r = 4, c = 4;
        // int matrix[][] = {{1, 2, 3, 4},
        //                   {5, 6, 7, 8},
        //                   {9, 10, 11, 12},
        //                   {13, 14, 15,16}};
        int r = 3, c = 4;
        int matrix[][] = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9, 10, 11, 12}};

        System.out.println(spirallyTraverse(matrix, r, c));


    }
}
