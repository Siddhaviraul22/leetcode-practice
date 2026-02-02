// Problem: Happy Number
// Link: https://leetcode.com/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150


class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n)) {
                return false; // cycle detected
            }
            seen.add(n);
            n = next(n);
        }
        return true;
    }

    private int next(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
