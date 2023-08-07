package Exam;

import java.util.Arrays;

public class
TSp {

    // Dynamic programming with memoization
    private static int tsp(int[][] graph, int currentCity, boolean[] visited, Integer[][] memo) {
        // Base case: All cities visited, return cost to return to the starting city
        boolean allVisited = true;
        for (boolean v : visited) {
            if (!v) {
                allVisited = false;
                break;
            }
        }
        if (allVisited) {
            return graph[currentCity][0];
        }

        // If the result is already memoized, return it
        if (memo[currentCity][toVisitedIndex(visited)] != null) {
            return memo[currentCity][toVisitedIndex(visited)];
        }

        int minCost = Integer.MAX_VALUE;
        for (int nextCity = 0; nextCity < graph.length; nextCity++) {
            // Check if nextCity is unvisited and not the current city
            if (!visited[nextCity] && nextCity != currentCity) {
                visited[nextCity] = true;
                int cost = graph[currentCity][nextCity] + tsp(graph, nextCity, visited, memo);
                minCost = Math.min(minCost, cost);
                visited[nextCity] = false;
            }
        }

        // Memoize the result
        memo[currentCity][toVisitedIndex(visited)] = minCost;
        return minCost;
    }

    // Helper method to convert visited array to an integer index
    private static int toVisitedIndex(boolean[] visited) {
        int index = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                index |= (1 << i);
            }
        }
        return index;
    }

    public static int solveTSP(int[][] graph) {
        int numCities = graph.length;
        // Create the memoization table
        Integer[][] memo = new Integer[numCities][1 << numCities];

        // Start the recursion from the starting city (city 0) with all other cities unvisited
        boolean[] visited = new boolean[numCities];
        visited[0] = true;

        return tsp(graph, 0, visited, memo);
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
