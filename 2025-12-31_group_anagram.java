// Problem: Group Anagrams
// Link: https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // build a unique key from frequency array
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append('#').append(count[i]);
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
