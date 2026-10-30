class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        int max_length = 0;
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max_length = Math.max(max_length, right - left + 1);
            right++;
        }
        return max_length;
    }
}
