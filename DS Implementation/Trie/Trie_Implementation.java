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
        int index = word.charAt(0) - 'A';
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

    public boolean searchUtil(TrieNode root, String word){
        // Base case
        if(word.length() == 0){
            return root.isTerminal;
        }

        int index = word.charAt(0) - 'A';
        TrieNode child;

        // Present
        if(root.children[index] != null){
            child = root.children[index];
        }
        // Absent
        else{
            return false;
        }

        return searchUtil(child, word.substring(1, word.length()));
    }

    // Time complexity -> O(length of word)
    public boolean search(String word){
        return searchUtil(root, word);
    }

    // Time complexity -> O(length of word)
    public void removeUtil(TrieNode root, String word){
        if(word.length() == 0){

        }
        
        int index = word.charAt(0) - 'A';
        TrieNode child;

        // Present
        if(root.children[index] != null){
            child = root.children[index];
        }
        // Absent
        else{
            return;
        }
    }

    public static boolean deleteUtil(TrieNode root, String word){
        if(word.length() ==0){
            return true;
        }

        int index = word.charAt(0) - 'A';
        TrieNode child = root.children[index];

        if(deleteUtil(child, word.substring(1, word.length()){
            root.children[index] = null;
        }
        boolean otherChild
        if(child.isTerminal == true)
    }

    public static void deleteWord(String word){
        if(search(word)){
            deleteUtil(root, word);
        }
    }
}

class Trie_Implementation{
    public static void main(String[] args){
        Trie t = new Trie();

        t.insertWord("TIME");
        t.insertWord("DO");
        t.insertWord("ARM");

        System.out.println("TIME is present or not -> " + t.search("TIME"));
        System.out.println("TIM is present or not -> " + t.search("TIM"));
    }
}