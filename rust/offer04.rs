impl Solution {
    pub fn find_number_in2_d_array(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        if matrix.len() == 0 || matrix[0].len() == 0 {
            return false;
        }

        let (ymax, xmax) = (matrix.len(), matrix[0].len());
        let (mut y, mut x) = (0, xmax-1);

        while matrix[y][x] != target {
            let cur = matrix[y][x];

            if target < cur {
                if (x == 0 ) { return false; }
                x -= 1;             // ! usize
            } else {
                y += 1;
            }

            if x < 0 || y >= ymax {
                return false;
            }
        }

        true
    }
}

// 注意特例
