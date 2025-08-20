// Problem: Greatest Common Divisor of Strings
// Link: https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        //check if concatenation works both ways
        if(!(str1+str2).equals(str2+str1)){
            return"";
        }

        //find gcd of lengths
        int gcdLength=gcd(str1.length(),str2.length());

        return str1.substring(0,gcdLength);

    }
    //helper function to compute gcd of two integers
    private int gcd(int a, int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    
}
