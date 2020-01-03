class WordDictionary {
    
    private Trie root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return root.search(word);
    }
    
    static class Trie {
        private boolean stop = false;
        private Trie[] chlids;
        
        public Trie() {
            this.chlids = new Trie[26];
        }
        
        public void insert(String word) {
            if (word.length() == 0) {
                this.stop = true;
            } else {
                char ch = head(word);
                if (null == chlids[ch]) 
                    chlids[ch] = new Trie();
                chlids[ch].insert(tail(word));
            }
        }
        
        public boolean search(String word) {
            if (word.length() == 0)
                return this.stop;
            
            char ch = head(word);
            if (ch == '.') {
                String tail = tail(word);
                for (Trie trie: chlids)
                    if (null != trie && trie.search(tail))
                        return true;
                return false;
            } else {
                if (null == chlids[ch])
                    return false;
                return chlids[ch].search(tail(word));
            }
        }
        
        private static char head(String string) {
            if (string.charAt(0) == '.')
                return '.';
            return (char)(string.charAt(0) - 'a');
        }
        
        private static String tail(String string) {
            return string.substring(1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
