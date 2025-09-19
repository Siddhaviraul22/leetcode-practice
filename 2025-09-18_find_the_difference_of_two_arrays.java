// Problem: Find the difference of two arrays
// Link:https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //convert arrays to sets to remove duplicates
        Set<Integer>set1=new HashSet<>();
        Set<Integer>set2=new HashSet<>();

        for(int num:nums1)set1.add(num);
        for(int num:nums2)set2.add(num);

        //Find elements in set1 but not in set2
        Set<Integer>diff1=new HashSet<>(set1);
        diff1.removeAll(set2);

        //Find elements in set2 but not in set1
        Set<Integer>diff2=new HashSet<>(set2);
        diff2.removeAll(set1);

        //prepare result
        List<List<Integer>>result=new ArrayList<>();
        result.add(new ArrayList<>(diff1));
        result.add(new ArrayList<>(diff2));

        return result;
    }
}