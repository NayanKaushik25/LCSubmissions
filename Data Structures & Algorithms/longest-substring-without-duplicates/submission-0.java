class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxlen = 0;
        while (right < s.length()) {
            if (hs.contains(s.charAt(right))) {
                hs.remove(s.charAt(left));
                left++;
            } else {
                hs.add(s.charAt(right));
                maxlen = Math.max(maxlen, right - left + 1);
                right++;
            }
        }
        return maxlen;
    }
}
