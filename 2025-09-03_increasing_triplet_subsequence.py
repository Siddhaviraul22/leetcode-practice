// Problem: Increasing Triplet Subsequence
// Link: https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75

class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        first = float('inf')
        second = float('inf')

        for num in nums:
            if num <= first:
                first = num   # new smallest
            elif num <= second:
                second = num  # new middle
            else:
                # found num > second with first < second earlier
                return True

        return False
        