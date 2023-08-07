package Graph.HW;

import Graph.Queues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AdjMatrix {
    static int vertices;
    public static int[][] matrix;

    public AdjMatrix(int vertices){
        this.vertices=vertices;
        matrix=new int[vertices][vertices];
    }

    public static List<Integer> getAdjNodes(int i){
        ArrayList<Integer> list=new ArrayList<>();

        for(int j=0;j<vertices;j++){
            if(matrix[i][j]!=0){

                list.add(j);
            }
        }
        return list;
    }

    public void BFS(int rootnode){
        Queues q=new Queues(vertices);
        boolean  visited[]=new boolean[vertices];
        q.enqueue(rootnode);
        visited[rootnode]=true;
        while (!q.isEmpty()){
            int x=q.dequeue();
            System.out.println(x);
//            List<Integer> list=getAdjNodes(x);
//            for(int i=0;i<list.size();i++){
//                int val=list.get(i);
//            }
            Iterator<Integer> iterator =getAdjNodes(x).iterator();
            while (iterator.hasNext()){
                int val=iterator.next();
                if(!visited[val]){
                    q.enqueue(val);
                    visited[val]=true;
                }
            }

        }
    }
    public  void DFSbyIterative(int rootnode){
        Stacks stacks =new Stacks(vertices);
        boolean isvisited[]=new boolean[vertices];
        stacks.push(rootnode);
        isvisited[rootnode]=true;
        while (!stacks.isEmpty()){
            int x=stacks.pop();
            System.out.println(x);
            Iterator<Integer> iterator=getAdjNodes(x).iterator();
            while (iterator.hasNext()){
                int val=iterator.next();
                if(!isvisited[val]){
                    stacks.push(val);
                    isvisited[val]=true;
                }
            }
        }


    }

    public void depthFirstSearch(int rootnode){
        boolean visited[]=new boolean[vertices];
        dfs(rootnode,visited);
    }
    void dfs(int rootnode, boolean [] visited){
        visited[rootnode]=true;
        System.out.println(rootnode);
        Iterator<Integer> iterator= getAdjNodes(rootnode).iterator();
        while (iterator.hasNext()){
            int val=iterator.next();
            if(!visited[val]){
                dfs(val,visited);
            }
        }

    }

    public void dijkstra(int Edges[][], int source){
        int dist[]=new int[vertices];
        boolean visited[]=new boolean[vertices];
        int prevpath[]=new int[vertices];
        for(int i=0;i<vertices;i++){
            dist[i]=Integer.MAX_VALUE;
            visited[i]=false;
            prevpath[i]=-1;
        }
        dist[source]=0;
        for(int i=0;i<vertices-1;i++){
            int u=minDistance(dist,visited);
            visited[u]=true;
            for(int j=0;j<Edges.length;j++){
                int v=Edges[j][1];
                int weight=Edges[j][2];
                if(!visited[v] && dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]){
                    dist[v]=dist[u]+weight;
                    prevpath[v]=u;
                }
            }
        }
        System.out.println("distance from source="+source);
        for(int i=0;i<vertices;i++){
            System.out.println("to vertex="+i+" is "+dist[i]);
        }
    }

    public int minDistance(int dist[], boolean visited[]){
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for(int i=0;i<vertices;i++){
            if(visited[i]==false && dist[i]<=min){
                min=dist[i];
                min_index=i;
            }
        }
        return min_index;
    }

    public void bellmanFord(int Edges[][], int source){
        int dist[]=new int[vertices];
        int prevpath[]=new int[vertices];

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

    public  void flayodWarshall(int [][] matrix){
        int dist[][]=new int[vertices][vertices];
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                dist[i][j]=matrix[i][j];
            }
        }
        for(int k=0;k<vertices;k++){
            for(int i=0;i<vertices;i++){
                for(int j=0;j<vertices;j++){
                    if(dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = (int)1e9;
                }
                if(i==j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int via = 0; via < n; via++) {
            for(int i = 0; i< n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == (int)1e9) {
                    matrix[i][j] = -1;
                }
                if(i==j) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public void dijakstra(int source, int destination){
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

        List <Integer> path = new LinkedList<>();
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

    int findMinVertex(int [] dist, boolean [] visited){
        int minvetex=-1;
       for(int i=0;i<vertices;i++){
           if(!visited[i] && (minvetex==-1 || dist[i]<dist[minvetex])){
               minvetex=i;
           }
       }
       return  minvetex;
    }

    public void addEdges(int source, int destination,int weight){
        matrix[source][destination]=weight;
        matrix[destination][source]=weight;
    }

    public void  printGraph(){
        for(int i=0;i<vertices;i++){
            System.out.print(i+" is connected to ");
            for(int j=0;j<vertices;j++){
                if(matrix[i][j]!=0){
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }
    }

        public int shortestDistance( int source, int destination) {

            Queues queue = new Queues(vertices);
            queue.enqueue(source);

            int[] distances = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                distances[i] = Integer.MAX_VALUE;
            }
            distances[source] = 0;

            while (!queue.isEmpty()) {
                int vertex = queue.dequeue();

                if (vertex == destination) {
                    return distances[vertex];
                }

                for (int neighbor = 0; neighbor < vertices; neighbor++) {
                    if (matrix[vertex][neighbor] == 1 && distances[neighbor] == Integer.MAX_VALUE) {
                        distances[neighbor] = distances[vertex] + 1;
                        queue.enqueue(neighbor);
                    }
                }
            }

            // If end vertex is not reachable from the start vertex
            return -1;
        }


    public static void main(String[] args) {

        //implement flayod warshall
        AdjMatrix g=new AdjMatrix(4);
        g.addEdges(0,1,5);
        g.addEdges(0,3,10);

        g.addEdges(1,2,3);
        g.addEdges(2,3,1);
        g.addEdges(3,1,4);
        g.printGraph();
        g.shortest_distance(g.matrix);

//        AdjMatrix g=new AdjMatrix(5);
//        g.addEdges(0,1,5);
//        g.addEdges(0,2,1);
//        g.addEdges(0,4,10);
//        g.addEdges(1,2,2);
//        g.addEdges(1,3,3);
//        g.addEdges(2,4,8);
//        g.addEdges(3,4,2);
//
//        g.printGraph();
//
//        System.out.println(g.getAdjNodes(0));
////        g.depthFirstSearch(0);
//        g.dijakstra(0,4);

    }
}
