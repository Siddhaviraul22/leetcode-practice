// Problem: Unique Number of Occurrences
// Link:https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //count frequency of each number
        Map<Integer,Integer>freqMap=new HashMap<>();
        for(int num:arr){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        //check if all frequencies are unique
        Set<Integer>freqSet=new HashSet<>(freqMap.values());

        //if set size==map values size, then all numbers are unique
        return freqSet.size()==freqMap.size();
    }
}