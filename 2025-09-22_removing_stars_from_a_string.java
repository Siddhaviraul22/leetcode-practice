// Problem: Removing stars from a String
// Link:https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String removeStars(String s) {
        StringBuilder sb=new StringBuilder();

        for(char c: s.toCharArray()){
            if(c=='*'){
                sb.deleteCharAt(sb.length()-1);//remove the last character
            }
            else{
                sb.append(c);//push character
            }
        }
        return sb.toString();
    }
}