class P256_Summed_Matrix{

    static long sumMatrix(long n, long q) {
        // T.C O(1) || S.C O(1)
        if(q < 2 || q > 2 * n){
            return 0;
        }
        else if(n < q){
            return n-(q-n)+1;
        }
        else{
            return q-1;
        }
    }

    public static void main(String args[]){

    }
}