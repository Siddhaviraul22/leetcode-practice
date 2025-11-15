// Problem: Daily Temperatures
// Link: https://leetcode.com/problems/daily-temperatures/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int idx = st.pop();
                result[idx] = i - idx;   // days until warmer temperature
            }
            st.push(i);
        }

        return result;
    }
}