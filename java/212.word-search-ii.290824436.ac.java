class Solution {
    
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private Trie root = new Trie(null);
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();
        
        root.build(words);
        
        for (int y=0; y<board.length; y++)
            for (int x=0; x<board[0].length; x++) {
                char ch = board[y][x];
                Trie trie = root.getChlids()[ch - 'a'];
                if (null == trie) continue;
                
                board[y][x] = '#';
                ans.addAll(trie.search(x, y, board));
                board[y][x] = ch;
            }
        return new LinkedList<String>(ans);
    }
    
    class Trie {
    
        private String stop;
        private Trie[] chlids;
        
        public Trie(String stop) {
            this.stop = stop;
            this.chlids = new Trie[26];
        }
        
        public void build(String[] words) {
            for (String word: words) {
                Trie trie = this;
                for (char ch: word.toCharArray()) {
                    ch -= 'a';
                    if (null == trie.chlids[ch])
                        trie.chlids[ch] = new Trie(null);
                    trie = trie.chlids[ch];
                }
                trie.stop = word;
            }
        }
        
        public String toString() {
            return stop;
        }
        
        public Set<String> search(int x, int y, char[][] map) {
            Set<String> ans = new HashSet<>();
            if (null != stop) ans.add(stop);
            
            for (int i = 0; i < 4; i++) {
                int xx = x + Solution.dirs[i][0], yy = y + Solution.dirs[i][1];

                if (xx < 0 || yy < 0 || xx >= map[0].length || yy >= map.length)
                    continue;
                if (map[yy][xx] == '#') continue;
                if (null == chlids[map[yy][xx] - 'a']) continue;

                char ch = map[yy][xx];
                map[yy][xx] = '#';
                ans.addAll(chlids[ch - 'a'].search(xx, yy, map));
                map[yy][xx] = ch;
            }
            return ans;
        }
        
        public Trie[] getChlids() {
            return chlids;
        }
    }
}
