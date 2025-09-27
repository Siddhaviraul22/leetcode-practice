// Problem: Dota2 Senate
// Link:https://leetcode.com/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String predictPartyVictory(String senate) {
       int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Populate the queues with indices
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        // Simulate the process
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();

            // Whoever has the smaller index bans the other
            if (r < d) {
                radiant.add(r + n); // Radiant survives to next round
            } else {
                dire.add(d + n);    // Dire survives to next round
            }
        }

        // Whichever queue still has members is the winner
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}