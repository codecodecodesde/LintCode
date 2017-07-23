public class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minstack;
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minstack.isEmpty()) {
            minstack.push(number);
        } else {
            minstack.push(Math.min(number, minstack.peek()));
        }

    }

    public int pop() {
        // write your code here
        minstack.pop();
       return stack.pop();
    }

    public int min() {
        // write your code here
        return minstack.peek();
    }
}

public class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minstack;
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minstack.isEmpty()) {
            minstack.push(number);
        } else {
            if(minstack.peek() >= number){
                minstack.push(number);
            }
        }

    }

    public int pop() {
        // write your code here
        if(stack.peek().equals(minstack.peek()))
            minstack.pop();
       return stack.pop();
    }

    public int min() {
        // write your code here
        return minstack.peek();
    }
}