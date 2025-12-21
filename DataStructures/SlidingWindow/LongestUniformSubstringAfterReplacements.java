package SlidingWindow;

public class LongestUniformSubstringAfterReplacements {

    public static int longestUniformSubstring(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxCount = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'a']);

            while (right - left + 1 - maxCount > k) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
