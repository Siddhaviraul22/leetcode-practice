// Problem: Kids with greatest number of candies
// Link: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //find the maximum number of candies among all kids
        int max=0;
        for(int c: candies){
            if(c>max){
                max=c;
            }
        }
        
        List<Boolean>result=new ArrayList<>();
        for(int c:candies){
            result.add(c+extraCandies>=max);
        }
        return result;
    }
}