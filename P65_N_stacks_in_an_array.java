public class P65_N_stacks_in_an_array {

    // Time complexity O(1) || Space complexity O(s+n)

    static int arr[];
    static int top[];
    static int next[];

    static int n, s;

    static int freespot;
    
    P65_N_stacks_in_an_array(int N, int S){
        n = N;
        s = S;
        arr = new int[s];
        top = new int[n];
        next = new int[s];
        
        // top initialize
        for(int i=0; i<n; i++){
            top[i] = -1;
        }

        // next initailize
        for(int i=0; i<s; i++){
            next[i] = i+1;
        }
        // update last index value to -1
        next[s-1] = -1;
        
        freespot = 0;
    }

    public static boolean push(int x, int m){
        // check for overflow
        if(freespot == -1){
            return false;
        }

        // find index
        int index = freespot;

        // update freespot
        freespot = next[index];

        // insert element into array
        arr[index] = x;

        // update next
        top[m-1] = index;

        return true;
    }

    public static int pop(int m){
        // check underflow
        if(top[m-1] == -1){
            return -1;
        }

        int index = top[m-1];

        top[m-1] = next[index];

        next[index] = freespot;

        return arr[index];
    }
    public static void main(String[] args) {
        P65_N_stacks_in_an_array s = new P65_N_stacks_in_an_array(6, 3);

        System.out.println(push(10,1));
        System.out.println(push(20,2));
        System.out.println(pop(3));
    }
}
