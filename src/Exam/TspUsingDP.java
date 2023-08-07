package Exam;

import java.util.Arrays;

public class TspUsingDP {

    // Recursive function to solve TSP


    private static int tsp(int[][] graph, boolean[] visited, int currPos, int count, int cost, int[][] memo) {
        int n = graph.length;

        // Base case: All cities visited, return cost to return to the starting city
        if (count == n && graph[currPos][0] > 0) {
            return cost + graph[currPos][0];
        }

        // If the result is already memoized, return it
        if (memo[currPos][visitedIndex(visited)] != 0) {
            return memo[currPos][visitedIndex(visited)];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // Check if city i is unvisited and there is a path from currPos to i
            if (!visited[i] && graph[currPos][i] > 0) {
                visited[i] = true;
                int newCost = cost + graph[currPos][i];
                int temp = tsp(graph, visited, i, count + 1, newCost, memo);
                ans = Math.min(ans, temp);
                visited[i] = false; // why false here? => backtracking to try other paths
            }
        }

        // Memoize the result
        memo[currPos][visitedIndex(visited)] = ans;
        return ans;
    }

    // Helper method to convert visited array to an integer index
    private static int visitedIndex(boolean[] visited) {
        int index = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                index |= (1 << i);
            }
        }
        return index;
    }

    // Method to solve TSP
    public
    static int solveTSP(int[][] graph) {
        int n = graph.length;

        // Initialize visited array
        boolean[] visited = new boolean[n];
        visited[0] = true;

        // Create the memoization table
        int[][] memo = new int[n][1 << n];

        // Start the recursion from the starting city (city 0) with count 1 and cost 0
        return tsp(graph, visited, 0, 1, 0, memo);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        int minCost = solveTSP(graph);
        System.out.println("Minimum cost: " + minCost);
    }
}
