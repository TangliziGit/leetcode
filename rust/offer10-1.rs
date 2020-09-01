#[derive(Clone, Debug)]                            // ! Clone impl
struct Matrix(Vec<Vec<u64>>, u64);                // ! semicolon

impl Matrix {
    fn new(data: Vec<Vec<u64>>, m: u64) -> Matrix {
        Matrix(data, m)
    }

    fn clear(&mut self) {
        for i in 0..self.0.len() {
            for j in 0..self.0.len() {
                self.0[i][j] = 0;
            }
        }
    }

    fn eye(&mut self) {
        for i in 0..self.0.len() {
            for j in 0..self.0.len() {
                self.0[i][j] = if i == j { 1 } else { 0 };
            }
        }
    }

    fn pow(mut self, n: i32) -> Self {
        let mut tmp = self.clone();
        let mut i = 1;
        (&mut self).eye();

        while i <= n {
            println!("{}: {:?} {}", i, self, n & i);
            if n & i != 0 {
                self = self.mul(tmp.clone());
            }
            i <<= 1;
            tmp = tmp.mul(tmp.clone());
            println!("tmp: {:?}", tmp);
        }
        println!("res: {:?}", self);
        self
    }

    fn mul(&self, rhs: Self) -> Self {
        let mut res = self.clone();
        res.clear();

        for i in 0..self.0.len() {
            for j in 0..self.0.len() {
                for k in 0..self.0.len() {
                    res.0[i][j] = (res.0[i][j] + (self.0[i][k] * rhs.0[k][j])%res.1)%res.1;
                }
            }
        }

        res
    }
}

impl Solution {
    pub fn fib(n: i32) -> i32 {
        let mut matrix = Matrix::new(vec![
            vec![0, 1],
            vec![1, 1],
        ], 1000000007);

        matrix.pow(n).0[0][1] as i32
    }
}


