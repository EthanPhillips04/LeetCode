class NumArray {

    int[] tree;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = nums;
        tree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            updateTree(i + 1, nums[i]);
        }
    }

    private void updateTree(int i, int val) {
        while (i <= n) {
            tree[i] += val;
            i += i & (-i);
        }
    }

    private int prefixSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateTree(index + 1, diff);
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left); 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */