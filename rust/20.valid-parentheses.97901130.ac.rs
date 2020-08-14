use std::collections::HashMap;

impl Solution {
    pub fn is_valid(s: String) -> bool {
        let begins = ['(', '[', '{'];
        let map = {
            let mut map = HashMap::new();
            map.insert('(', ')');
            map.insert('[', ']');
            map.insert('{', '}');
            map
        };

        let mut stack = Vec::new();

        for ch in s.chars() {
            if begins.contains(&ch) {
                stack.push(ch);
            } else {
                let prev = stack.pop()
                    .and_then(|x| map.get(&x))
                    .map(|x| *x == ch);
 
                if let Some(false) | None = prev {
                    return false;
                }
            }
        }

        stack.len() == 0
    }
}
