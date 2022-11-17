import java.util.HashMap;

public class P13_Intersection_of_two_arrays {
    
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        // Your code here
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // QUESTION is asking for distinct elements
        // Eg -> Intersection of {2,4,2,5,1} and {2,2,1} is {2,1} not {2,2,1}

        // Create map of the array which is smaller in size or if both are of same size create for any one (In this way map will take less space)

        if(n<m){
            // n is the size of array a
            // Store all the elements of the array in map
            for(int i=0; i<n; i++){
                if(map.get(a[i])==null){
                    map.put(a[i], 0);
                }

                map.put(a[i], map.get(a[i])+1);
            }

            // Now check which element of array b exists in map(means in array a as map contains the elements of array a)
            for(int i=0; i<m; i++){
                // If element not found then skip the iteration
                if(map.get(b[i])==null){
                    continue;
                }
                else{
                    // Increase the count by 1 and remove the element from the map so it will not be counted twice
                    map.remove(b[i]);
                    count++;
                }
            }
        }

        // if m < n or n == m create map of array b
        else{
            // m is the size of array b
            // Store all the elements of the array in map
            for(int i=0; i<m; i++){
                if(map.get(b[i])==null){
                    map.put(b[i], 0);
                }
                map.put(b[i], map.get(b[i])+1);
            }


            // Now check which element of array a exists in map(means in array b as map contains the elements of array b)
            for(int i=0; i<n; i++){
                // If element not found then skip the iteration
                if(map.get(a[i])==null){
                    continue;
                }
                else{
                    // Increase the count by 1 and remove the element from the map so it will not be counted twice
                    map.remove(a[i]);
                    count++;
                }
            }
        }


        return count;
    }

    public static void main(String[] args) {
        // int n = 5, m = 3;
        // int a[] = {89, 24, 75, 11, 23};
        // int b[] = {89, 2, 4};
        int n = 5, m = 3;
        int a[] = {89, 2, 5, 4, 6};
        int b[] = {89, 2, 4};

        System.out.println(NumberofElementsInIntersection(a, b, n, m));
    }
}
