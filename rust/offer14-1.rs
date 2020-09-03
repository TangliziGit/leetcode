impl Solution {
    pub fn cutting_rope(n: i32) -> i32 {
        let mut ans = 1;

        for m in 2..n {
            ans = ans.max(mul(n, m));
        }

        ans
    }
}

fn mul(n: i32, m: i32) -> i32 {
    let avg = n / m;
    let rest = n - avg * m;

    (avg+1).pow(rest as u32) * avg.pow((m - rest) as u32)
}
