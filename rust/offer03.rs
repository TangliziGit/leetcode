impl Solution {
    pub fn find_repeat_number(mut nums: Vec<i32>) -> i32 {
        for i in 0..nums.len() {                    // 底层是replace
            if nums[i] != i as i32 {                // ! usize
                let x = nums[i];

                if nums[x as usize] == x {
                    return x;
                }

                nums.swap(x as usize, i);           // ! mut
            }
        }

        return 0;
    }
}

// L03. Range 实现了 Iterator，其 next 返回了所有权。
//      注意for-loop只是一个loop-match语法糖
// L11. swap 底层是llvm, 涉及block optimization, 不转移所有权的read， 不drop的write

