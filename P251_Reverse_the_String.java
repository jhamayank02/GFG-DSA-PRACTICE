import java.util.*;

class P251_Reverse_the_String{

    public static String reverseString(String str) {
        // Time complexity O(n) || Space complexity O(n)
		// String reversed = "";
		// int n = str.length();

		// for(int i=n-1; i>=0; i--){
		// 	reversed += str.charAt(i);
		// }

		// return reversed;

        // Time complexity O(n) || Space complexity O(n)
		StringBuilder rev = new StringBuilder(str);

		int n = str.length();
		int s = 0;
		int e = n-1;

		while(s<e){

			char temp = rev.charAt(s);
			rev.setCharAt(s, rev.charAt(e));
			rev.setCharAt(e, temp);

			s++;
			e--;
		}

		return rev.toString();
	}

    public static void main(String args[]){

    }
}