import java.util.ArrayList;

class TrieNode{
    char data;
    TrieNode[] children = new TrieNode[26];
    boolean isTerminal;

    TrieNode(char ch){
        this.data =ch;
        for(int i=0; i<26; i++) {
            this.children[i] = null;
        }
        this.isTerminal = false;
    }
}

class Trie{

    TrieNode root;

    Trie(){
        root = new TrieNode('\0');
    }

    public void insertUtil(TrieNode root, String word){
        // Base case
        if(word.length() == 0){
            root.isTerminal = true;
            return;
        }

        // Assumption -> Words will be CAPS
        int index = word.charAt(0) - 'a';
        TrieNode child;

        // Present
        if(root.children[index] != null){
            child = root.children[index];
        }
        // Absent
        else{
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }

        insertUtil(child, word.substring(1, word.length()));
    }

    // Time complexity -> O(length of word)
    public void insertWord(String word){
        insertUtil(root, word);
    }
}

class P172_Phone_directory{

    public static ArrayList<ArrayList<String>> getSuggestions(TrieNode root, String queryStr){
        
        TrieNode prev = root;
        String prefix = "";
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        
        int i=0;
        for(; i<queryStr.length(); i++){
            char lastChar = queryStr.charAt(i);
            prefix += lastChar;
            
            // Check for last char
            TrieNode curr = prev.children[lastChar - 'a'];
            
            // If not found
            if(curr == null){
                break;
            }
            // Found
            ArrayList<String> temp = new ArrayList<>();
            printSuggestions(curr, temp, prefix);
            output.add(temp);
            prev = curr;
        }
        
        // Add "0" for the remaining string if no suggestion exists
        while(i<queryStr.length()){
            ArrayList<String> temp = new ArrayList<>();
            temp.add("0");
            output.add(temp);
            i++;
        }
        
        return output;
    }
    
    public static void printSuggestions(TrieNode curr, ArrayList<String> temp, String prefix){
        if(curr.isTerminal == true){
            temp.add(prefix);
        }
        
        for(char ch = 'a'; ch <= 'z'; ch++){
            TrieNode next = curr.children[ch - 'a'];
            
            if(next != null){
                prefix += ch;
                printSuggestions(next, temp, prefix);
                prefix = prefix.substring(0, prefix.length()-1);
            }
            
        }
    }
    
    // Time complexity O(m^2*n) || Space complexity O(m*n)
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // Creation of trie
        Trie t = new Trie();
        
        // Insert all contacts in trie
        for(int i=0; i<n; i++){
            t.insertWord(contact[i]);
        }
        
        return getSuggestions(t.root, s);
    }

    public static void main(String[] args){
        String ip[] = {"coding", "ninjas"};

        System.out.println(displayContacts(ip.length, ip, "ninjas"));
    }
}