// Problem: Find the difference of two arrays
// Link:https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75

class Solution(object):
    def findDifference(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[List[int]]
        """
        set1, set2=set(nums1), set(nums2)

        diff1=list(set1-set2)#elements in nums1 not in nums2
        diff2=list(set2-set1)#elements in nums2 not in nums1

        return[diff1,diff2]