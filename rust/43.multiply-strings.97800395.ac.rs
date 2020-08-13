impl Solution {
    pub fn multiply(num1: String, num2: String) -> String {
        if num1 == "0" || num2 == "0" {
            return "0".to_string();
        }

        let (nx, ny) = (num1.len(), num2.len());
        let mut xs: Vec<char> = num1.chars().collect();
        let mut ys: Vec<char> = num2.chars().collect();
        let mut num = vec![0; nx + ny];

        for xi in (0..nx).rev() {
            for yi in (0..ny).rev() {
                let pos = nx-1-xi + ny-1-yi;
                let res = num[pos] + 
                    (xs[xi] as u8 - '0' as u8) *
                    (ys[yi] as u8 - '0' as u8);
                
                num[pos] = res % 10;
                num[pos+1] += res / 10;
            }
        }

        let mut res = String::new();
        let mut flag = false;
        for n in num.iter().rev() {
            if flag || *n != 0 {
                if !flag { flag = true; }
                res.push_str(&n.to_string());
            }
        }

        if res.len() == 0 { res.push('0'); }
        res.chars().collect::<String>()
    }
}
