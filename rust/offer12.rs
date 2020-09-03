impl Solution {
    pub fn exist(mut board: Vec<Vec<char>>, word: String) -> bool {
        if board.len() == 0 || board[0].len() == 0 { return false; }
        let word = word.chars().collect::<Vec<char>>();

        for y in 0..board.len() {
            for x in 0..board[0].len() {
                if board[y][x] != word[0] { continue; }

                if helper(x as i32, y as i32, &mut board, &word, 1) {
                    return true;
                }
                board[y][x] = word[0];
            }
        }

        false
    }
}

const dir: [[i32; 4]; 2] = [[0, 1, 0, -1], [1, 0, -1, 0]];
fn helper(x: i32, y: i32, board: &mut Vec<Vec<char>>, word: &Vec<char>, idx: usize) -> bool {
    board[y as usize][x as usize] = ' ';
    if idx == word.len() {
        return true;
    }

    for i in 0..4 {
        let (xx, yy) = (x + dir[0][i], y + dir[1][i]);

        if xx < 0 || yy < 0 || xx >= board[0].len() as i32 || yy >= board.len() as i32 { continue; }
        if board[yy as usize][xx as usize] != word[idx] { continue; }

        if helper(xx, yy, board, word, idx+1) {
            return true;
        }
        board[yy as usize][xx as usize] = word[idx];
    }

    false
}
