class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int n = nums.length;
        double current = 0;

        for (int i = 0; i < k; i++) {
            current += nums[i];
        }
            double maximum = current;
            for (int i = k; i < n; i++) {
                current += nums[i] - nums[i - k];
                if(current > maximum) {
                    maximum = current;
                }
            }
            return (double)maximum / k;
    }
}