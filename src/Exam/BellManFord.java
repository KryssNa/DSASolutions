package Exam;


public class BellManFord {
    static int vertices=5;
    public void bellmanFord(int Edges[][], int source){

//
        int dist[]=new int[vertices]; //distance from source to each vertex
        int prevpath[]=new int[vertices]; //previous vertex of each vertex

        // Step 1: Initialize distances from src to all
        // other vertices as INFINITE and pevpath to -1
        for(int i=0;i<vertices;i++){

            dist[i]=Integer.MAX_VALUE;
            prevpath[i]=-1;
        }
        dist[source]=0;

        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for(int i=0;i<vertices-1;i++){
            for(int j=0;j<Edges.length;j++){
                int u=Edges[j][0];
                int v=Edges[j][1];
                int weight=Edges[j][2];
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]){
                    dist[v]=dist[u]+weight;
                    prevpath[v]=u;
                }
            }
        }
        // Step 3: check for negative-weight cycles. The
        // above step guarantees shortest distances if graph
        // doesn't contain negative weight cycle. If we get
        // a shorter path, then there is a cycle.
        for(int i=0;i<Edges.length;i++){
            int u=Edges[i][0];
            int v=Edges[i][1];
            int weight=Edges[i][2];
            if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]){
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
//        print the distance and path of each vertex
        System.out.println("distance from source="+source);
        for(int i=0;i<vertices;i++){
            System.out.println("to vertex="+i+" is "+dist[i]);
        }
    }
}