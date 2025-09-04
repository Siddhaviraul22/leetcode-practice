// Problem: String Compression
// Link: https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int compress(char[] chars) {
        int write=0; //postion to write result
        int read=0; //postion to scan input

        while(read<chars.length){
            char currentChar=chars[read];
            int count=0;

            //count consecutive chars
            while(read<chars.length&&chars[read]==currentChar){
                read++;
                count++;
            }
            
            //write the char
            chars[write]=currentChar;
            write++;

            //write count if>1
            if(count>1){
                String countStr=String.valueOf(count);
                for(char c:countStr.toCharArray()){
                    chars[write]=c;
                    write++;
                }
            }
        }
        return write;
    }
}