// Problem: Valid Palindrome
// Link: https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // move left pointer until alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // move right pointer until alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // compare lowercased characters
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
