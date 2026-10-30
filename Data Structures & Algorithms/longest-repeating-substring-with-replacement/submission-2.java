class Solution {
    
    public int characterReplacement(String s, int k) {
       HashMap<Character, Integer> map = new HashMap<>();
        int highest_freq = 0;
        int max_window = 0;
        int right = 0;
        int left = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            highest_freq = Math.max(highest_freq, map.get(c));
            int window_size = right - left + 1;
            if (window_size - highest_freq > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            } else {
                max_window = Math.max(max_window, window_size);
            }
            right++;
        }
        return max_window;
    }
}
