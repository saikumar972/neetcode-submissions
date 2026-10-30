class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) { 
            return false;
        }
            int[] subStringfreq = new int[26];
            int[] windowFreq = new int[26];
            for (char ch : s1.toCharArray()) {
                subStringfreq[ch - 'a'] += 1;
            }

            int left = 0;
            int right = 0;

            while (right < s2.length()) {
                windowFreq[s2.charAt(right) - 'a'] += 1;
                if (right - left + 1 == s1.length()) {
                    if (Arrays.equals(subStringfreq, windowFreq)) {
                        return true;
                    }
                    windowFreq[s2.charAt(left) - 'a'] -= 1;
                    left++;
                }
                right++;
            }
        return false;
        }
}
