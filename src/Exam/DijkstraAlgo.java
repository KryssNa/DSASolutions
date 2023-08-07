package Exam;

import java.util.LinkedList;
import java.util.List;

public class DijkstraAlgo {
    public static int vertices;

    //2 ta xa jun sajilo lagxa tei garne
    public void dijakstra(int matrix[][],int source, int destination){
        int dist[]=new int[vertices];
        int prevpath[]=new int[vertices];
        boolean visited[]=new boolean[vertices];

        for(int i=0;i<vertices;i++){
            dist[i]=Integer.MAX_VALUE;
            prevpath[i]=-1;
        }

        dist[source]=0;
        for(int i=0;i<vertices;i++){
            int minvertex=findMinVertex(dist, visited);
            System.out.println("this is minVertex:"+minvertex);
            visited[minvertex]=true;
            for(int j=0; j<vertices;j++){
                if(matrix[minvertex][j]!=0){
                    if(!visited[j] &&(dist[minvertex]+matrix[minvertex][j]<dist[j])){
                        dist[j]= dist[minvertex]+matrix[minvertex][j];
                        prevpath[j]=minvertex;
                    }
                }
            }
        }
        System.out.println("distance from source="+source+" to destination="+destination+" is " +dist[destination]);
        //brackward crawl from destination using prev path array

        List<Integer> path = new LinkedList<>();
        int crawl = destination;
        path.add(crawl);
        while (prevpath[crawl] != -1) {
            path.add(prevpath[crawl]);
            crawl = prevpath[crawl];
        }
        // Print path
        System.out.print("Path is :");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    private int findMinVertex(int[] dist, boolean[] visited) {
        int minvetex=-1;
        for(int i=0;i<vertices;i++){
            if(!visited[i] && (minvetex==-1 || dist[i]<dist[minvetex])){
                minvetex=i;
            }
        }
        return minvetex;
    }

    // A Java program for Dijkstra's single source shortest path
// algorithm. The program is for adjacency matrix
// representation of the graph

    static class ShortestPath {
        // A utility function to find the vertex with minimum
        // distance value, from the set of vertices not yet
        // included in shortest path tree
        static final int V = 9;
        int minDistance(int dist[], Boolean sptSet[])
        {
            // Initialize min value
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < V; v++)
                if (sptSet[v] == false && dist[v] <= min) {
                    min = dist[v];
                    min_index = v;
                }

            return min_index;
        }

        // A utility function to print the constructed distance
        // array
        void printSolution(int dist[])
        {
            System.out.println(
                    "Vertex \t\t Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + " \t\t " + dist[i]);
        }

        // Function that implements Dijkstra's single source
        // shortest path algorithm for a graph represented using
        // adjacency matrix representation
        void dijkstra(int[][] graph, int src)
        {
            int[] dist = new int[V]; // The output array.
            // dist[i] will hold
            // the shortest distance from src to i

            // sptSet[i] will true if vertex i is included in
            // shortest path tr
            // ee or shortest distance from src
            // to i is finalized
            Boolean visited[] = new Boolean[V];

            int prevPath[]=new int[vertices];

            // Initialize all distances as INFINITE and stpSet[]
            // as false
            for (int i = 0; i < V; i++) {
                dist[i] = Integer.MAX_VALUE;
                prevPath[i]=-1;
            }

            // Distance of source vertex from itself is always 0
            dist[src] = 0;

            // Find shortest path for all vertices
            for (int count = 0; count < V - 1; count++) {   //
                // Pick the minimum distance vertex from the set
                // of vertices not yet processed. u is always
                // equal to src in first iteration.
                int u = minDistance(dist, visited);

                // Mark the picked vertex as processed
                visited[u] = true;

                // Update dist value of the adjacent vertices of
                // the picked vertex.
                for (int v = 0; v < V; v++)

                    // Update dist[v] only if is not in sptSet,
                    // there is an edge from u to v, and total
                    // weight of path from src to v through u is
                    // smaller than current value of dist[v]
                    if (!visited[v] && graph[u][v] != 0
                            && dist[u] != Integer.MAX_VALUE
                            && dist[u] + graph[u][v] < dist[v]){

                        dist[v] = dist[u] + graph[u][v];
                        prevPath[v]=u;}
            }

            // print the constructed distance array
            printSolution(dist);
        }

        // Driver's code
        public void main(String[] args)
        {
            /* Let us create the example graph discussed above
             */
            int graph[][]
                    = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                    { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                    { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
            ShortestPath t = new ShortestPath();

            // Function call
            t.dijkstra(graph, 0);
        }}

}
