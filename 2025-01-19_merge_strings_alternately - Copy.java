// Problem: Merge strings alternately
// Link: https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75



class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb= new StringBuilder();
        int i=0;
        int j=0;

        //iterate while both strings have characters
        while(i<word1.length() && j<word2.length()){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;

        }
        //append remaing part of word1(if any)

        while(i<word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }

        //apend remaining part of word2(if any)

        while(j<word2.length()){
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}