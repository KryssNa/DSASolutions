package DyanamicProgramming;

import java.util.LinkedList;
import java.util.List;

public class LCS {
    int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        List<String> soln = new LinkedList<>();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int op1 = dp[i - 1][j];
                    int op2 = dp[i][j - 1];
                    dp[i][j] = Math.max(op1, op2);
                }
            }
        }

        for (int i = dp.length - 1, j = dp[0].length - 1; i >= 1 && j >= 1; ) {
            if (dp[i][j] == (dp[i - 1][j - 1] + 1)) {
                soln.add(s1.charAt(i - 1) + " ");
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                break;
            }
        }

        System.out.println(soln);


        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println(lcs.lcs(s1, s2));
    }
}
