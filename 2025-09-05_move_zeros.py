// Problem: Move Zeros
// Link: https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75

class Solution(object):
    def moveZeroes(self, nums):
        insert_pos=0

        #First pass move non zero numbers to front
        for num in nums:
            if num!=0:
                nums[insert_pos]=num
                insert_pos+=1

        #second pass fill the rest with zeros
        while insert_pos<len(nums):
            nums[insert_pos]=0
            insert_pos+=1
        