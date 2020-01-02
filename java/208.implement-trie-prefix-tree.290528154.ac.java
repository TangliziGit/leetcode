class Trie {

    private Trie[] chlids;
    private boolean stop;
    
    public Trie() {
        this(false);
    }
    
    public Trie(boolean stop) {
        this.chlids = new Trie[26];
        this.stop = stop;
    }
    
    public void insert(String word) {
        if (word.length() == 0) {
            setStop();
            return;
        }
        
        char ch = (char) (word.charAt(0) - 'a');
        if (null == chlids[ch]) 
            chlids[ch] = new Trie(word.length() == 1);
        chlids[ch].insert(word.substring(1));
    }
    
    public boolean search(String word) {
        if (word.length() == 0)
            return this.stop;
        
        char ch = (char) (word.charAt(0) - 'a');
        if (null == chlids[ch])
            return false;
        return chlids[ch].search(word.substring(1));
    }
    
    public boolean startsWith(String word) {
        if (word.length() == 0)
            return true;
        
        char ch = (char) (word.charAt(0) - 'a');
        if (null == chlids[ch])
            return false;
        return chlids[ch].startsWith(word.substring(1));
    }
    
    private void setStop() {
        this.stop = true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
