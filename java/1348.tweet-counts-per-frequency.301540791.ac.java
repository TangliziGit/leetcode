class TweetCounts {
    
    private Map<String, LinkedList<Integer>> map = new HashMap<>();
    private static Map<String, Integer> interval = new HashMap<>();
    
    static {
        interval.put("minute", 60);
        interval.put("hour", 60*60);
        interval.put("day", 60*60*24);
    }

    public TweetCounts() {
        
    }
    
    public void recordTweet(String name, int time) {
        if (!map.containsKey(name)) 
            map.put(name, new LinkedList<>());
        LinkedList<Integer> list = map.get(name);
        list.add(time);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String name, int startTime, int endTime) {
        if (!map.containsKey(name)) return new LinkedList<>();
        if (!interval.containsKey(freq)) return new LinkedList<>();
        
        
        Integer it = interval.get(freq);
        System.out.println(it);
        LinkedList<Integer> list = map.get(name);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<(endTime - startTime)/it + 1; i++)
            ans.add(0);
        
        System.out.println(ans);
        for (Integer end: list) {
            if (end > endTime || end < startTime) continue;
            
            int idx = (end-startTime)/it;
            if (idx < 0 || idx >= ans.size()) continue;
            ans.set(idx, ans.get(idx)+1);
        }
        
        return ans;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
