// Problem: Reverse vowels of a string
// Link: https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String reverseVowels(String s) {
        char[]arr=s.toCharArray();
        int left=0,right=arr.length-1;

        while(left<right){
            while(left<right&&!isVowel(arr[left])){
                left++;
            }
            while(left<right&&!isVowel(arr[right])){
                right--;
            }

            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

            left++;
            right--;
        }
        return new String(arr);
    }

    private boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
}