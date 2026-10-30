class Solution {
    public int trap(int[] height) {
        int sum = 0;
        for(int i=1;i<height.length-1;i++){
            int leftMax=0;
            int rightMax=0;
            for(int left=0;left<i;left++){
                if(height[left]>leftMax)
                    leftMax=height[left];
            }
            for(int right=i+1;right<height.length;right++){
                if(height[right]>rightMax)
                    rightMax=height[right];
            }
            int storage = Math.min(leftMax,rightMax)-height[i];
            if(storage>0){
                sum+=storage;
            }
        }
        return sum;
    }
}
