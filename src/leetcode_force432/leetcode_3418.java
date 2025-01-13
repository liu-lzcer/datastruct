package leetcode_force432;

public class leetcode_3418 {
    public static void main(String[] args) {
        int[][] coins = {
                {-3, -10, 11, -16},
                {-13, 19, -2, 2},
                {-16, -11, 5, 13},
                {-5, 13, -20, -6}
        };
        Solution s = new Solution();
        int result = s.maximumAmount(coins);
        System.out.println("Maximum amount of coins: " + result); // 输出 32
    }
}

class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        // Initialize dp array with Integer.MIN_VALUE
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // Initialize the starting point
        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;  // 感化第一个强盗
        }

        // Fill the first row
        for (int j = 1; j < n; j++) {
            for (int k = 0; k <= 2; k++) {
                if (dp[0][j - 1][k] != Integer.MIN_VALUE) {

                    if (coins[0][j] >= 0) {
                        dp[0][j][k] = Math.max(dp[0][j][k], dp[0][j - 1][k] + coins[0][j]);
                    } else {
                        // 不感化
                        dp[0][j][k] = Math.max(dp[0][j][k], dp[0][j - 1][k] + coins[0][j]);
                        // 感化
                        if (k < 2) {
                            dp[0][j][k + 1] = Math.max(dp[0][j][k + 1], dp[0][j - 1][k]);
                        }
                    }
                    System.out.println("j: " + j + "," + dp[0][j][k]);
                }
            }
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            for (int k = 0; k <= 2; k++) {
                if (dp[i - 1][0][k] != Integer.MIN_VALUE) {

                    if (coins[i][0] >= 0) {
                        dp[i][0][k] = Math.max(dp[i][0][k], dp[i - 1][0][k] + coins[i][0]);
                    } else {
                        // 不感化
                        dp[i][0][k] = Math.max(dp[i][0][k], dp[i - 1][0][k] + coins[i][0]);
                        // 感化
                        if (k < 2) {
                            dp[i][0][k + 1] = Math.max(dp[i][0][k + 1], dp[i - 1][0][k]);
                        }
                    }
                    System.out.println("i: " + i + "," + dp[0][i][k]);
                }
            }
        }


        System.out.println("\nting!");

        // Fill the rest with the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 0; k <= 2; k++) {
                    // 从上方来
                    if (dp[i - 1][j][k] != Integer.MIN_VALUE) {

                        if (coins[i][j] >= 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k] + coins[i][j]);
                        } else {
                            // 不感化
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k] + coins[i][j]);
                            // 感化
                            if (k < 2) {
                                dp[i][j][k + 1] = Math.max(dp[i][j][k + 1], dp[i - 1][j][k]);
                            }
                        }
                    }
                    // 从左方来
                    if (dp[i][j - 1][k] != Integer.MIN_VALUE) {

                        if (coins[i][j] >= 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k] + coins[i][j]);
                        } else {
                            // 不感化
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k] + coins[i][j]);
                            // 感化
                            if (k < 2) {
                                dp[i][j][k + 1] = Math.max(dp[i][j][k + 1], dp[i][j - 1][k]);
                            }
                        }
                    }
                }
            }
        }

        // Find the maximum value in the last cell
        int maxCoins = Integer.MIN_VALUE;
        for (int k = 0; k <= 2; k++) {
            maxCoins = Math.max(maxCoins, dp[m - 1][n - 1][k]);
        }

        return maxCoins;
    }
}