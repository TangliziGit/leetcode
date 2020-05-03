class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Map<Integer, Integer> count = new HashMap<>();
        Queue<Integer> maxQ = new PriorityQueue<>((x, y) -> y-x);
        Queue<Integer> minQ = new PriorityQueue<>();
        
        int tail = 0;
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            int max=0, min=0;
            while (tail < nums.length) {
                maxQ.add(nums[tail]);
                minQ.add(nums[tail]);
                count.put(nums[tail], count.getOrDefault(nums[tail], 0)+1);
                max = maxQ.peek();
                min = minQ.peek();
                
                tail++;
                if (max - min > limit) break;
            }
            
            ans = Math.max(ans, tail - i + ((max-min<=limit)?0:-1));
            count.put(nums[i], count.get(nums[i])-1);
            
            while (maxQ.size() != 0 && count.get(maxQ.peek()) == 0) maxQ.poll();
            while (minQ.size() != 0 && count.get(minQ.peek()) == 0) minQ.poll();
        }
        
        return ans;
    }
}
