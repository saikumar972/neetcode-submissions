class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        char[] c = s1.toCharArray();
        int left = 0;
        int right = c.length-1;
        while(left<right){
            if (!Character.isLetterOrDigit(c[left]))
                left++;
            else if (!Character.isLetterOrDigit(c[right]))
                right--;
            else if (c[left]!=c[right]){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
