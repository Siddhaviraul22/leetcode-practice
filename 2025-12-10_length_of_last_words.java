// Problem: Length of Last Word
// Link: https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        
        // skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        int length = 0;
        // count the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }
}
