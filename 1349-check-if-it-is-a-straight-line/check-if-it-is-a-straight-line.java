class Solution {
    public boolean checkStraightLine(int[][] coord) {
        int x0 = coord[0][0];
        int y0 = coord[0][1];
        int x1 = coord[1][0];
        int y1 = coord[1][1];

        for (int i = 2; i < coord.length; i++) {
            int x = coord[i][0];
            int y = coord[i][1];
            if ((x - x0) * (y1 - y0) != (y - y0) * (x1 - x0)) {
                return false;
            }
        }

        return true;
    }
}