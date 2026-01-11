// Problem: Evaluate Reverse Polish Notation
// Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {
                
                int b = stack.pop();
                int a = stack.pop();
                
                int result;
                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    default: // "/"
                        result = a / b; // truncates toward zero
                }
                
                stack.push(result);
            } else {
                // token is a number
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}
