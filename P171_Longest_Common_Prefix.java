class TrieNode{
    char data;
    boolean isTerminal;
    int childCount;
    TrieNode children[];

    TrieNode(char ch){
        data = ch;
        isTerminal = false;
        childCount = 0;
        children = new TrieNode[26];
        for(int i=0; i<26; i++){
            children[i] = null;
        }
    }
}

class Trie{
    TrieNode root;

    public Trie(char ch){
        root = new TrieNode(ch);
    }

    public void insertUtil(TrieNode root, String word){
        // Base case
        if(word.length() == 0){
            root.isTerminal = true;
            return;
        }

        // Assumption -> Words will be CAPS
        int index = word.charAt(0) - 'A';
        TrieNode child;

        // Present
        if(root.children[index] != null){
            child = root.children[index];
        }
        // Absent
        else{
            child = new TrieNode(word.charAt(0));
            root.childCount++;
            root.children[index] = child;
        }

        insertUtil(child, word.substring(1, word.length()));
    }

    // Time complexity -> O(length of word)
    public void insertWord(String word){
        insertUtil(root, word);
    }

    public String lcp(String word, String ans){
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(root.childCount == 1){
                ans += ch;

                int index = ch -'A';
                root = root.children[index];
            }
            else{
                break;
            }

            if(root.isTerminal){
                break;
            }
        }

        return ans;
    }
}

class P171_Longest_Common_Prefix{

    public static String longestCommonPrefix(String[] strs) {
        // Approach 1: Using two loops || Time complexity O(m*n) || Space complexity O(1)
        // m -> Length of first string || n -> no. of strings
        // if(strs.length == 0){
        //     return "";
        // }

        // String ans = "";

        // for(int i=0; i<strs.length; i++) {
        //     char ch = strs[0].charAt(i);
        //     boolean match = true;

        //     for(int j=1; j<strs.length; j++) {
        //         if(ch != strs[j].charAt(i)) {
        //             match = false;
        //             break;
        //         }
        //     }

        //     if(match == true) {
        //         ans += ch;
        //     }
        //     else{
        //         break;
        //     }
        // }
        // return ans; 




        // Approach 2 : Using Trie
        Trie trie = new Trie('\0');

        // Insert all words into trie
        for(String str : strs) {
            trie.insertWord(str);
        }

        String first = strs[0];
        String ans = "";

        ans = trie.lcp(first, ans);

        return ans;
    }

    public static void main(String[] args){
        String arr[] = {"CODING", "CODEHELP", "CODER", "CODEWITHHARRY"};

        System.out.println(longestCommonPrefix(arr));
    }
}