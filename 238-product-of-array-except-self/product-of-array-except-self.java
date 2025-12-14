class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        int extra[] = new int[n];
        prefix[0] = 1;
        extra[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            extra[i] = extra[i + 1] * nums[i + 1];
        }

        int answer[] = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = prefix[i] * extra[i];
        }
        return answer;
    }
}