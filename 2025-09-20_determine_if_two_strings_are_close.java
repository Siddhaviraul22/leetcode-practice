// Problem: Determine if two strings are close
// Link:https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public boolean closeStrings(String word1, String word2) {
        //if lengths differ they can never be close
        if(word1.length()!=word2.length()){
            return false;
        }

        //Count frequencies
        int[]freq1=new int[26];
        int[]freq2=new int[26];

        for(char c:word1.toCharArray()){
            freq1[c-'a']++;
        }
        for(char c:word2.toCharArray()){
            freq2[c-'a']++;
        }

        //ensure they use the same set of characters
        for(int i=0;i<26;i++){
            if((freq1[i]==0 && freq2[i]!=0 || freq1[i]!=0 && freq2[i]==0)){
                return false;
            }
        }

        //compare frequency distributions
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1,freq2);
    }
}