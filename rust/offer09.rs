#[derive(Default)]
struct CQueue {
    head: Vec<i32>,
    tail: Vec<i32>,
}


/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl CQueue {

    fn new() -> Self {
        Default::default()
    }
    
    fn append_tail(&mut self, value: i32) {
        self.head.push(value);
    }
    
    fn delete_head(&mut self) -> i32 {
        if self.tail.len() == 0 {
            self.head.reverse();
            self.tail.append(&mut self.head);       // consum content
            self.head.clear();
        }

        self.tail.pop().unwrap_or(-1)
    }
}

