class Solution {

    private int posiOfLastElementInSortedArray(int[] nums, int left, int right) {

        int pivotLoc = left;
        int pivotIndex = (left+right)/2;
        int pivot = nums[pivotIndex];

        // send pivot to end
        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[right];
        nums[right] = temp;

        for(int i=left;i<=right;i++) {
            if(nums[i] < pivot) {
                // swap i and pivotLoc
                temp = nums[i];
                nums[i] = nums[pivotLoc];
                nums[pivotLoc++] = temp;
            }
        }

        // swap right and pivotLoc
        temp = nums[right];
        nums[right] = nums[pivotLoc];
        nums[pivotLoc] = temp;

        return pivotLoc;
    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        k = nums.length - k;

        while(left < right) {
            int pivotLoc = posiOfLastElementInSortedArray(nums, left, right);
            if(pivotLoc == k)
                return nums[k];
            else if(pivotLoc < k)
                left = pivotLoc+1;
            else
                right = pivotLoc-1;
        }
        return nums[left];
    }
}