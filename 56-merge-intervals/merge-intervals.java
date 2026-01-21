class Solution {
    public int[][] merge(int[][] inter) {
        Arrays.sort(inter, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = inter[0];

        for (int i = 1; i < inter.length; i++) {
            int[] interval = inter[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }

        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }
}