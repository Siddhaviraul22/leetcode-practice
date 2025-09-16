// Problem: Find the highest Altitude
// Link: https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75

class Solution(object):
    def largestAltitude(self, gain):
        """
        :type gain: List[int]
        :rtype: int
        """
        altitude=0
        maxAltitude=0

        for g in gain:
            altitude+=g
            maxAltitude=max(maxAltitude,altitude)
        
        return maxAltitude