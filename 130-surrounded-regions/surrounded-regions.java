class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q= new ArrayDeque<>();

        //i) Traversing 0th column and last column then if it is 'O' then adding in Queue and marking visited
        for (int i = 0; i < m; i++) {
            if(board[i][0]=='O'){
               q.add(new int[]{i,0});
               visited[i][0]=true;
            }
            if(board[i][n-1]=='O'){
                q.add(new int[]{i,n-1});
                visited[i][n-1]=true;
            }
        }

        //ii)Traversing 0th row and last row then if it is 'O' then adding in Queue and marking visited
        for(int i=1;i<n-1;i++){
            if(board[0][i]=='O'){
               q.add(new int[]{0,i});
               visited[0][i]=true;
            }
            if(board[m-1][i]=='O'){
                q.add(new int[]{m-1,i});
                visited[m-1][i]=true;
            }
        }

        //iii)Iterating through queue and adding adjacent 'O' cell in queue then marking them visited
        while(!q.isEmpty()){
            int []arr=q.remove();
            for (int k = 0; k < 4; k++) {
            int r = arr[0] + dir[k][0];
            int c = arr[1] + dir[k][1];

            if (r >= 0 && r < m && c >= 0 && c < n &&
                board[r][c] == 'O' && !visited[r][c]) {
                    q.add(new int[]{r,c});
                    visited[r][c]=true;
                }
            }
        }

        //iv)Converting all 'O' which are not visited(not reachable from boundary) to 'X'
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j]='X';
                }
            }
        }
    
    }
}