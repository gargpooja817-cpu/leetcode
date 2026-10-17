class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;

        int[] lastSeen = new int[128];
        java.util.Arrays.fill(lastSeen, -1);

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (lastSeen[ch] >= left) {
                left = lastSeen[ch] + 1;
            }

            lastSeen[ch] = right;

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}