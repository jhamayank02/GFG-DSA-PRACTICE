import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P99_Generate_Binary_Numbers {

    // Time complexity O(n) || Space complexity O(n)
    static ArrayList<String> generate(int N)
    {
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("1");

        while(N != 0){
            String temp = q.poll();
            ans.add(temp);

            q.add(temp + '0');
            q.add(temp + '1');

            N--;
        }

        return ans;
    }

    public static void main(String[] args) {
        // int N = 2;
        // System.out.println(generate(N));
        int N = 5;
        System.out.println(generate(N));
    }
}
