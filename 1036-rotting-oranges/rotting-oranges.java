class Pair {
    private int x;
    private int y;
    private int time;

    public Pair (int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getTime(){
        return this.time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == 0) continue;
                else if (grid[i][j] == 1) count++;
                else q.add(new Pair(i, j, 0));
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int k = q.size();
            for(int i = 0; i < k; i++) {
                Pair temp = q.poll();
                int x = temp.getX();
                int y = temp.getY();
                int time = temp.getTime();

                ans = Math.max(ans, time);
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        count--;
                        q.add(new Pair(newX, newY, time + 1));
                    }
                }
            }
        }

        if(count != 0) return -1;
        return ans;
    }
}