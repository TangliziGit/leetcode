// 1. notice initialize
// 2. once substract operation appear, notice if Integer overflow

class MinStack {

    private Stack<Long> stack;
    private long min;
    
    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(long x) {
        if (!stack.isEmpty()) {
            stack.push(x-min);
            min=Math.min(min, x);
        } else {
            min = x;
            stack.push(0L);
        }
    }
    
    public void pop() {
        if (stack.peek() < 0) min -= stack.pop();
        else stack.pop();
    }
    
    public int top() {
        if (stack.peek() < 0) return (int)min;
        else return (int)(stack.peek() + min);
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
