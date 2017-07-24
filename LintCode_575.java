public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        Stack<Object> stack = new Stack<>();
        int number = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                number = number * 10 + c - '0';
            }else if(c == '['){
                stack.push(Integer.valueOf(number));
                number = 0;
            }else if(c == ']'){
                String newStr = pop(stack);
                Integer count = (Integer)stack.pop();
                for(int i = 0; i < count; i++){
                    stack.push(String.valueOf(newStr));
                }
            }else{
                stack.push(String.valueOf(c));
            }
        }
        return pop(stack);
    }
    
    private String pop(Stack<Object> stack1){
        Stack<Object> stack2 = new Stack<>();
        while(!stack1.empty() && (stack1.peek() instanceof String)){
            stack2.push(stack1.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!stack2.empty()){
            sb.append(stack2.pop());
        }
        return sb.toString();
    }
}