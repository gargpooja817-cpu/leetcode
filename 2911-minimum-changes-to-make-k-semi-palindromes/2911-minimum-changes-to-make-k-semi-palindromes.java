class Solution {
    public int minimumChanges(String s, int k) {

        int n = s.length();
        int[][] cost = new int[n][n];

        // Step 1: Precompute substring costs
        for (int l = 0; l < n; l++) {

            for (int r = l + 1; r < n; r++) {

                int len = r - l + 1;
                int minCost = Integer.MAX_VALUE;

                // Check all proper divisors
                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Check each group
                    for (int start = 0; start < d; start++) {

                        int left = start;
                        int right = start + ((len - 1 - start) / d) * d;

                        while (left < right) {

                            if (s.charAt(l + left) !=
                                s.charAt(l + right)) {

                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    minCost = Math.min(minCost, changes);
                }

                cost[l][r] = minCost;
            }
        }

        // Step 2: Dynamic Programming
        int INF = 1000000;

        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int j = 1; j <= k; j++) {

            for (int i = 2 * j; i <= n; i++) {

                for (int p = 2 * (j - 1); p <= i - 2; p++) {

                    if (dp[p][j - 1] == INF) {
                        continue;
                    }

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[p][j - 1] + cost[p][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}