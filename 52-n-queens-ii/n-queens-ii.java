

class Solution {
    static boolean isSafe(int n,int c, int r,  char [][] board){
       for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q')
                return false;
        }

        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

 
        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
    
    return true;
    }
    public static int solve(int n, char [][] board ,int r){
if(r==n){


   
    return 1;
}
int count=0;
        for(int i=0; i<n; i++){
if(isSafe(n,i,r,board)){
    board[r][i]='Q';
    
    count +=solve(n,board,r+1);
    board[r][i]='.';
    
}
        }
        return count;
    }
    public  int totalNQueens(int n) {
           char [][] board =  new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }

         return solve(n,board,0);
        
    }
}