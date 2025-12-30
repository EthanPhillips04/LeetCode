class Solution {

    public void generate(List<List<Integer>> res, List<Integer> subset, int arr[], int size, int target, int idx,int sum){
        if(subset.size() == size){
            if(sum == target){
                res.add(new ArrayList<>(subset));
            }
            return;
        }
        if(sum > target){
            return;
        }

        if(idx == arr.length){
            return;
        }

        subset.add(arr[idx]);
        generate(res,subset,arr,size,target,idx+1,sum+arr[idx]);

        subset.remove(subset.size() - 1);
        generate(res,subset,arr,size,target,idx+1,sum);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int arr[] = {1,2,3,4,5,6,7,8,9};
        generate(res,subset,arr,k,n,0,0);
        return res;
    }
}