package GreedyAlgorithm;

public class LCSgreedy {
    static String lcs(String X, String Y) {
        String lcs = "";
        int lastIndex = -1;
        int count = 0;

        for (int i = 0; i < X.length(); i++) {
            char x = X.charAt(i);

            for (int j = lastIndex + 1; j < Y.length(); j++) {
                if (Y.charAt(j) == x) {
                    lcs += x;
                    count++;
                    lastIndex = j;
                    break;
                }
            }
        }
        System.out.println("Length of LCS: " + count);

        return lcs;
    }

    public static void main(String[] args) {
        String X = "GGTGB";
        String Y = "GXTXAYB";

        String approxLCS = lcs(X, Y);
        System.out.println("Approximated LCS: " + approxLCS);
    }
}
