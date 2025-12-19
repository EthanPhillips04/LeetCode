class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        Map<String, Integer> rowMap = new HashMap<>();

        for (int row[] : grid) {
            String rowStart = Arrays.toString(row);
            rowMap.put(rowStart, rowMap.getOrDefault(rowStart, 0) + 1);
        }
        int col [] = new int[n];

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                col[j] = grid[j][i];
            }
            String colStart = Arrays.toString(col);
            if (rowMap.containsKey(colStart)) {
                count += rowMap.get(colStart);
            }
        }
            return count;
    }
}