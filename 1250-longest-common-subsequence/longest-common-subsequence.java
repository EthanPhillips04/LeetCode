class Solution {
    private static Integer[][] memo;

    static int longestCommonSubsequence(String s1, String s2) {
        memo = new Integer[s1.length()][s2.length()];
        return solve(s1, s2, s1.length()-1, s2.length()-1);
    }

    private static int solve(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (memo[i][j] != null) return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return memo[i][j] = 1 + solve(s1, s2, i-1, j-1);

        return memo[i][j] =
            Math.max(solve(s1, s2, i-1, j),
                     solve(s1, s2, i, j-1));
    }
}