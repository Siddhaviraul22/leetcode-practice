// Problem: Zigzag Conversion
// Link: https://leetcode.com/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int rows = Math.min(numRows, s.length());
        StringBuilder[] sb = new StringBuilder[rows];
        for (int i = 0; i < rows; i++) sb[i] = new StringBuilder();

        int cur = 0;
        int step = 1; // 1 = moving down, -1 = moving up

        for (char c : s.toCharArray()) {
            sb[cur].append(c);
            if (cur == 0) step = 1;
            else if (cur == rows - 1) step = -1;
            cur += step;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder part : sb) result.append(part);
        return result.toString();
    }
}
