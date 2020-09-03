impl Solution {
    pub fn my_pow(x: f64, n: i32) -> f64 {
        if x == 1.0 { return 1.0; }
        if x == -1.0 { return (1-2*(n%2)) as f64; }
        if (n as f64)*x.log10() < -10.0 { return 0.0; }
        if (n as f64)*x.log2() > 1024.0 { return f64::MAX; }

        if n < 0 {
            pow(1.0/x, -n)
        } else {
            pow(x, n)
        }
    }
}

fn pow(x: f64, n: i32) -> f64 {
    let mut i = 1;
    let (mut ans, mut tmp) = (1.0, x);

    while i <= n {
        if i & n != 0 { ans *= tmp; }
        tmp *= tmp;
        i <<= 1;
    }

    ans
}
