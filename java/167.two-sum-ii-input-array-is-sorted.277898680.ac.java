class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> vis = new HashMap<>();
        
        for (int i = numbers.length-1; i>=0; i--){
            if (numbers[i] < target/2) break;
            if (vis.containsKey(numbers[i])) continue;
            vis.put(numbers[i], i);
        }
        
        for (int i = 0; i<numbers.length; i++)
            if (vis.containsKey(target - numbers[i]))
                return new int[]{i+1, vis.get(target - numbers[i])+1};
        
        return null;
    }
}
