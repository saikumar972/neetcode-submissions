class Solution {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int slow = n;
        int fast = n;
        while (true) {
            slow = nextSumNumber(slow);
            fast = nextSumNumber(nextSumNumber(fast));
            if (fast == 1) {
                return true;
            } else if (fast == slow) {
                return false;
            }
        }
    }

    private static int nextSumNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            sum += digit * digit;
        }
        return sum;
    }
}
