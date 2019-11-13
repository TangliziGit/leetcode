class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            int sum = 0;
            for (int x: nums)
                if ((x >> i & 1) == 1)
                    sum++;
            sum %= 3;
            res |= sum << i;
        }
        return res;
    }
}
