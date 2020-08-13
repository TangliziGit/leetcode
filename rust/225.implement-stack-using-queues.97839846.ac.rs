use std::collections::VecDeque;

struct MyStack {
    que1: VecDeque<i32>,
    que2: VecDeque<i32>,
}


/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MyStack {

    /** Initialize your data structure here. */
    fn new() -> Self {
        MyStack {
            que1: VecDeque::new(),
            que2: VecDeque::new(),
        }
    }
    
    /** Push element x onto stack. */
    fn push(&mut self, x: i32) {
        self.que1.push_back(x);
    }
    
    fn rearrange(&mut self) {
        while self.que1.len() > 1 {
            self.que2.push_back(self.que1.pop_front().unwrap());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    fn pop(&mut self) -> i32 {
        self.rearrange();
        std::mem::swap(&mut self.que1, &mut self.que2);

        self.que2.pop_front().unwrap()
    }
    
    /** Get the top element. */
    fn top(&mut self) -> i32 {
        self.rearrange();

        // deref is necessary.
        let res = *self.que1.front().unwrap();
        self.que2.push_back(self.que1.pop_front().unwrap());

        std::mem::swap(&mut self.que1, &mut self.que2);

        res
    }
    
    /** Returns whether the stack is empty. */
    fn empty(&self) -> bool {
        self.que1.len() == 0
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * let obj = MyStack::new();
 * obj.push(x);
 * let ret_2: i32 = obj.pop();
 * let ret_3: i32 = obj.top();
 * let ret_4: bool = obj.empty();
 */
