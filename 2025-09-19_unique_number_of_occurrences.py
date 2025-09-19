// Problem: Unique Number of Occurrences
// Link:https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75

class Solution(object):
    def uniqueOccurrences(self, arr):
        """
        :type arr: List[int]
        :rtype: bool
        """
        #count frequencies
        freq={}
        for num in arr:
         freq[num]=freq.get(num,0)+1
        
        #check if frequencies are unique
        return len(freq.values())==len(set(freq.values()))