// Problem: Maximum Average Subarray I
// Link: https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75

class Solution(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """

        window_sum=sum(nums[:k])
        max_sum=window_sum

        for i in range(k,len(nums)):
            window_sum+=nums[i]-nums[i-k]
            max_sum=max(max_sum,window_sum)

        return float(max_sum)/k
        
