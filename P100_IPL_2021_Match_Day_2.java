import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class P100_IPL_2021_Match_Day_2 {
    
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        
        // Time complexity O(n*k) || Space complexity O(1)
        // ArrayList<Integer> ans = new ArrayList<>();

        // for(int i=0; i<n; i++){
        //     int max = Integer.MIN_VALUE;
        //     for(int j=i; j<i+k; j++){
        //         if(arr[j] > max){
        //             max = arr[j];
        //         }
        //     }
        //     ans.add(max);

        //     if(i+k == n){
        //         break;
        //     }
        // }

        // return ans;



        // Time complexity O(n) || Space complextity O(k)
        // Approach -> Using priority queue
        // ArrayList<Integer> ans = new ArrayList<>();
        // Deque<Integer> q = new LinkedList<>();

        // for(int i=0; i<n; i++){

        //     while(q.size()>0 && i-q.peek()>=k){
        //         q.removeFirst();
        //     }

        //     while(q.size()>0 && arr[q.getLast()]<=arr[i]){
        //         q.removeLast();
        //     }

        //     q.addLast(i);
        //     if(i>=k-1){
        //         ans.add(arr[q.peek()]);
        //     }
        // }


        // return ans;


        // Using Deque
        // Time complexity O(n*k) || Space compelexity O(k)
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            
            // Remove the index from front which is not in the current window
            // T.C O(1) || S.C O(1)
            if(dq.size() > 0 && dq.getFirst() <= i-k){
                dq.removeFirst();
            }
            
            // Remove the index from last whose element is less than or equal to the current element
            // T.C O(k-1) || S.C O(1)
            while(dq.size() > 0 && arr[i] >= arr[dq.getLast()]){
                dq.removeLast();
            }
            
            // Add the current index
            dq.addLast(i);
            
            // Add element in the ans list
            if(i >= k-1){
                ans.add(arr[dq.peek()]);
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int N = 9, K = 3;
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        
        // int N = 186, K = 110;
        // int arr[] = {1488,1282,1455,1734,1114,1701,1316,1671,1786,1263,1313,1355,1185,1053,1912,1808,1832,1945,1313,1756,1321,1558,1646,1982,1481,1144,1196,1222,1129,1161,1535,1450,1173,1466,1044,1659,1292,1439,1253,1024,1154,1510,1745,1649,1186,1313,1474,1022,1168,1018,1787,1905,1958,1391,1202,1625,1477,1414,1314,1824,1334,1874,1372,1159,1833,1070,1487,1297,1518,1177,1773,1270,1763,1668,1192,1985,1102,1480,1213,1627,1802,1099,1527,1625,1543,1924,1023,1972,1061,1181,1003,1432,1505,1593,1725,1031,1492,1142,1222,1286,1064,1900,1187,1360,1413,1974,1270,1170,1235,1833,1711,1760,1896,1667,1285,1550,1140,1694,1695,1624,1019,1125,1576,1694,1658,1302,1371,1466,1678,1593,1851,1484,1018,1464,1119,1152,1800,1087,1060,1926,1010,1757,1170,1315,1576,1227,1043,1758,1164,1109,1882,1086,1565,1487,1577,1474,1625,1627,1629,1928,1423,1520,1902,1962,1123,1596,1737,1261,1195,1525,1264,1260,1202,1116,1030,1326,1011,1771,1411,1547,1153,1520,1790,1924,1188,1763};

        System.out.println(max_of_subarrays(arr, N, K));
    }
}
