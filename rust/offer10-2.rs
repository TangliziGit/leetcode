impl Solution {
    pub fn num_ways(n: i32) -> i32 {
        let m = 1000000007;
        let mut dp = [0u32; 120];

        dp[0] = 1;
        dp[1] = 1;
        for i in 2..=n {
            let i = i as usize;
            dp[i] = (dp[i-1] + dp[i-2]) % m;
        }

        dp[n as usize] as i32
    }
}
