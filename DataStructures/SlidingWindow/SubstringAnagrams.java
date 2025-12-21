package SlidingWindow;

public class SubstringAnagrams {

    public static int countAnagrams(String s, String t) {
        if (s.length() < t.length()) return 0;

        int[] freq = new int[26];
        for (char c : t.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0, count = t.length(), result = 0;

        while (right < s.length()) {
            if (freq[s.charAt(right) - 'a']-- > 0) {
                count--;
            }
            right++;

            if (count == 0) result++;

            if (right - left == t.length()) {
                if (freq[s.charAt(left) - 'a']++ >= 0) {
                    count++;
                }
                left++;
            }
        }
        return result;
    }
}
