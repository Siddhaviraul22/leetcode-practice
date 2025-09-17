// Problem: Find Pivot Index
// Link: https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75

class Solution(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        total_sum=sum(nums)
        left_sum=0

        for i, num in enumerate(nums):
            #right sum==total-left-current
            if left_sum==total_sum-left_sum-num:
                return i
            left_sum+=num

        return -1