// Problem: H-Index
// Link: https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int papersWithAtLeastThis = n - i; 
            if (citations[i] >= papersWithAtLeastThis) {
                h = papersWithAtLeastThis;
                break;
            }
        }

        return h;
    }
}
