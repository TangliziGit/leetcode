impl Solution {
    pub fn min_array(nums: Vec<i32>) -> i32 {
        let mut ans = nums[0];

        for i in 1..nums.len() {
            let i = i as usize;

            if nums[i-1] > nums[i] {
                ans = nums[i];
                break;
            }
        }

        ans
    }
}
