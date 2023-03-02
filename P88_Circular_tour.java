public class P88_Circular_tour {
    static int tour(int petrol[], int distance[])
    {
        //  Time complexity O(n) || Space complexity O(1)
        int size = petrol.length;
        
        int balance = 0;
        int deficit = 0;
        int start = 0;

        for(int i=0; i<size; i++){
            balance += petrol[i] - distance[i];

            if(balance < 0){
                deficit += balance;
                balance = 0;
                start = i+1;
            }
        }

        if(deficit + balance >= 0){
            return start;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int N = 4;
        int Petrol[] = {4, 6, 7, 4};
        int Distance[] = {6, 5, 3, 5};

        System.out.println(tour(Petrol, Distance));
    }
}
