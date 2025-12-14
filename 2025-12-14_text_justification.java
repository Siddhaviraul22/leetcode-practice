// Problem: Text Justification
// Link: https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;

            // Pack as many words as possible in this line
            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }

            int wordCount = j - i;  
            int totalChars = 0;
            for (int k = i; k < j; k++) totalChars += words[k].length();

            int spaces = maxWidth - totalChars;           
            StringBuilder sb = new StringBuilder();

            // Case 1: last line OR single-word line → left justify
            if (j == words.length || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } 
            // Case 2: fully justify
            else {
                int gaps = wordCount - 1;
                int baseSpaces = spaces / gaps;
                int extra = spaces % gaps; // these go to leftmost gaps

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) { 
                        int spacesToInsert = baseSpaces + ((k - i) < extra ? 1 : 0);
                        while (spacesToInsert-- > 0) sb.append(" ");
                    }
                }
            }

            result.add(sb.toString());
            i = j;  // move to next line
        }

        return result;
    }
}
