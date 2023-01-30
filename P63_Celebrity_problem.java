import java.util.Stack;

public class P63_Celebrity_problem {

    public static int findCelebrity(int arr[][], int n){
        // Time complexity O(n) || Space complexity O(n)
        Stack<Integer> s = new Stack<>();

        // Push all elements into the stack
        for(int i=0; i<n; i++){
            s.push(i);
        }

        // Get two elements and compare them
        while(s.size() > 1){
            int a = s.pop();
            int b = s.pop();

            // If a knows b, then push b into the stack
            if(arr[a][b] == 1){
                s.push(b);
            }
            // If b knows a, then push a into the stack
            else if(arr[b][a] == 1){
                s.push(a);
            }
        }

        // Single element in stack is the potential celebrity
        int potentialCelebrity = s.pop();

        // Check the celebrity row
        boolean rowCheck = false;

        for(int i=0; i<n; i++){
            if(arr[potentialCelebrity][i] == 1){
                return -1;
            }
        }  

        // Check the column of celebrity
        for(int i=0; i<n; i++){
            if(arr[i][potentialCelebrity] == 0 && i != potentialCelebrity){
                return -1;
            }
        }

        return potentialCelebrity;
    }
    
    public static void main(String[] args) {
        int arr[][] = {{0,1,0},
                       {0,0,0},
                       {0,1,0}};

        System.out.println(findCelebrity(arr, 3));
    }
}
