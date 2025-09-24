// Problem: Decode String
// Link:https://leetcode.com/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String decodeString(String s) {
        Stack<Integer>countStack=new Stack<>();
        Stack<StringBuilder>stringStack=new Stack<>();
        StringBuilder current=new StringBuilder();
        int k=0;

        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                k=k*10+(c-'0');//handle multi-digit numbers
            }
            else if(c=='['){
                countStack.push(k);
                stringStack.push(current);
                current=new StringBuilder();
                k=0;
            }
            else if(c==']'){
                int repeatTimes=countStack.pop();
                StringBuilder decoded=stringStack.pop();
                for(int i=0;i<repeatTimes;i++){
                    decoded.append(current);
                }
                current=decoded;
            }
            else{
                current.append(c);
            }
        }
        return current.toString();
    }
}