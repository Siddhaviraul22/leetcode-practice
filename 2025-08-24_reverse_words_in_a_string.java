// Problem: Reverse words in a string
// Link: https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String reverseWords(String s) {
        //trin leading/trailing spaces
        s=s.trim();

        //split on one or more spaces
        String[]words=s.split("\\s+");

        //reverse the words
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            if(i!=0){
                sb.append(" ");
            }
        }
        
        //return the result
        return sb.toString();
    }
}