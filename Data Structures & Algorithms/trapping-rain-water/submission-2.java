class Solution {
    public int trap(int[] arr) {
        int sum2 =0;
        int left = 0;
        int right = arr.length-1;
        int leftMax = 0;
        int rightMax = 0;
        while(left<right) {
            leftMax = Math.max(arr[left],leftMax);
            rightMax = Math.max(arr[right],rightMax);
            if(leftMax<rightMax) {
                sum2 += Math.max(0, leftMax - arr[left]);
                left++;
            }else {
                sum2 += Math.max(0, rightMax - arr[right]);
                right--;
            }
        }
        return sum2;
    }
}
