class Solution {
    
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max_window = 0;
        int right = 0;
        int left = 0;
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            int highest_freq = map.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null).getValue();
            int window_size = right - left + 1;
            if (window_size - highest_freq > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            else{
                max_window = Math.max(max_window, window_size);
            }
            right++;
        }
        return max_window;
    }
}
