package Exam;

public class SalesManProblem {
    //traveling a salesman problem using greedy algorithm

    static int tsp(int[][] graph, boolean[] v, int currPos, int n, int count, int cost, int ans) {
        if (count == n && graph[currPos][0] > 0) {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }
        for (int i = 0; i < n; i++) {
            if (!v[i] && graph[currPos][i] > 0) {
                v[i] = true;
                ans = tsp(graph, v, i, n, count + 1, cost + graph[currPos][i], ans);
                v[i] = false;
            }
        }
        return ans;
    }

    //traveling a salesman problem using dynamic programming algorithm

    static  int tsp(int[][] graph, boolean[] v, int currPos, int n, int count, int cost, int ans, int[][] memo) {

        if (count == n && graph[currPos][0] > 0) {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }
        if (memo[currPos][toVisitedIndex(v)] != 0) {
            return memo[currPos][toVisitedIndex(v)];
        }
        for (int i = 0; i < n; i++) {
            if (!v[i] && graph[currPos][i] > 0) {
                v[i] = true;
                ans = tsp(graph, v, i, n, count + 1, cost + graph[currPos][i], ans, memo);
                v[i] = false;
            }
        }
        memo[currPos][toVisitedIndex(v)] = ans;
        return ans;
    }

    static int solveTsp(int[][] graph, int n) {
        boolean[] v = new boolean[n];
        v[0] = true;
        int ans = Integer.MAX_VALUE;
        int[][] memo = new int[n][1 << n];
        ans = tsp(graph, v, 0, n, 1, 0, ans, memo);
        return ans;
    }

    static int toVisitedIndex(boolean[] v) {
        int index = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i]) {
                index += Math.pow(2, i);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] graph = { {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        boolean[] v = new boolean[n];
        v[0] = true;
        int ans = Integer.MAX_VALUE;
        ans = tsp(graph, v, 0, n, 1, 0, ans);
        System.out.println(ans);
        System.out.println("Minimum cost: "+solveTsp(graph, n));
    }
}
