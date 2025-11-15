// Problem: Search Suggestions System
// Link: https://leetcode.com/problems/search-suggestions-system/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);  // Sort lexicographically
        List<List<String>> result = new ArrayList<>();
        String prefix = "";

        for (char c : searchWord.toCharArray()) {
            prefix += c;
            int idx = binarySearch(products, prefix);
            List<String> suggestions = new ArrayList<>();

            // Add up to 3 lexicographically smallest suggestions
            for (int i = idx; i < products.length && suggestions.size() < 3; i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }

            result.add(suggestions);
        }
        return result;
    }

    // Find the first product >= prefix (using binary search)
    private int binarySearch(String[] products, String prefix) {
        int left = 0, right = products.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (products[mid].compareTo(prefix) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}