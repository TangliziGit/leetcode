impl Solution {
    pub fn replace_space(s: String) -> String {
        s.chars()           // !!! 
            .map(|x| match x {
                ' ' => "%20".to_string(),
                ch => ch.to_string(),
            })
            .collect::<String>()
    }
}

// L03. chars底层使用 FFI&const fn 将 &str 转化为 [u8]
// 可用 with_capacity 优化
