class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        boolean[][] dp = new boolean[n][n];
        int result = 0;
        int start = 0;
        for(int i = 0 ; i < n ; i++) {
            dp[i][i] = true;
        }
        for(int i = 0; i < n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
            }
        }
        for(int len = 3; len <= n ; len++) {
            for(int  i = 0 ; i <= n-len; i++) {
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
            }
        }
        result = n;
        for(int i = 0 ; i < n ; i++) {
            for(int j = i+1 ; j < n; j++) {
                if(dp[i][j]) result++;
            }
        }
        return result;
    }
}
