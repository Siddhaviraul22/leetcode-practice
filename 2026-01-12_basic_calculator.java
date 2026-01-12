// Problem: Basic Calculator-
// Link: https://leetcode.com/problems/basic-calculator/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;   // 1 means '+', -1 means '-'
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } 
            else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } 
            else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } 
            else if (ch == '(') {
                // save current state
                stack.push(result);
                stack.push(sign);
                
                // reset for new expression
                result = 0;
                sign = 1;
            } 
            else if (ch == ')') {
                result += sign * num;
                num = 0;
                
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                
                result = prevResult + prevSign * result;
            }
        }
        
        // add last number if exists
        result += sign * num;
        return result;
    }
}
