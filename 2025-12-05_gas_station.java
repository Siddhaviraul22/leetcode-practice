// Problem: Gas Station
// Link: https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;   // total net gas over all stations
        int tank = 0;    // current gas in tank while scanning
        int start = 0;   // candidate starting index

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            // If we can't reach the next station from current start
            if (tank < 0) {
                // next station becomes new candidate start
                start = i + 1;
                tank = 0;
            }
        }

        // If total gas is less than total cost, no solution
        if (total < 0) return -1;
        return start;
    }
}
