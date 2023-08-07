package Graph;
import Graph.HW.Stacks;

import java.util.*;

public class AdjMatrix {

    public static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;
        Edge(int u, int v, int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }

        @Override
        public int compareTo(Edge o) {
            if(o==null){
                return Integer.MAX_VALUE;
            }
            return this.w-o.w;
        }
    }
    public static int vertices;
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
    
    public void prims(int matrix[][],int source){
        int dist[]=new int[vertices];
        int parent[]=new int[vertices];
        boolean visited[]=new boolean[vertices];

        for(int i=0;i<vertices;i++){
            dist[i]=Integer.MAX_VALUE;
            parent[i]=-1;
        }

        dist[source]=0;
        for(int i=1;i<vertices;i++){
            int minvertex=findMinVertex(dist, visited);
            visited[minvertex]=true;
            for(int j=0; j<vertices;j++){
                if(matrix[minvertex][j]!=0){
                    if(!visited[j] &&(matrix[minvertex][j]<dist[j])){
                        dist[j]= matrix[minvertex][j];
                        parent[j]=minvertex;

                    }
                }
            }
        }

    }

    void topoSort(){
        int indegree[]= new int[vertices];
        Queues q=new Queues(vertices);
        //calcualte indegree
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                if(matrix[i][j]!=0){
                    indegree[j]++;
                }
                }
            }
        //place vertext with 0 indegree in queue
        for(int i=0; i<vertices;i++){
            if(indegree[i]==0){
                q.enqueue(i);
            }
        }
        int cnt=0;
        while (!q.isEmpty()){
            cnt++;
            int val=q.dequeue();
            System.out.println(val);
            for(int j=0;j<vertices;j++){
                if(matrix[val][j]!=0){
                    indegree[j]--;
                    if(indegree[j]==0){
                        q.enqueue(j);
                    }

                }
            }
        }

        if(cnt!=vertices){
            System.out.println("cycle detected");
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

    Edge edgelist[]=new Edge[vertices*(vertices-1)/2];

    int edgecounter=-1;
    public void addEdges(int source, int destination,int weight){
        matrix[source][destination]=weight;
        matrix[destination][source]=weight;
        edgelist[++edgecounter]=new Edge(source,destination,weight);
    }

    void krushkal(){
        int mst[][]=new int[vertices][vertices];
        Arrays.sort(edgelist);
        int size []=new int[vertices];
        int parent[]=new int[vertices];
        for(int i=0;i<vertices;i++){
            parent[i]=-1;
        }

        int edgeTaken=0;
        int counter=-1;

        while(edgeTaken<=vertices-1){
            Edge e=edgelist[++counter];
            int uabsroot=find(e.u,parent);
            int vabsroot=find(e.v,parent);
            int w=e.w;
            if(uabsroot==vabsroot){
                continue;
            }
            mst[e.u][e.v]=w;
            union(uabsroot,vabsroot,parent,size);
            edgeTaken++;
        }
    }

    public void union(int uroot, int vroot, int [] parent, int [] size){
        if(size[uroot]>size[vroot]){
            parent[vroot]=uroot;
        }
        else if (size[uroot]<size[vroot]){
            parent[uroot]=vroot;
        }
        else{
            parent[uroot]=vroot;
            size[vroot]++;
        }
    }

    int find(int rootnode, int [] parent){
        if(parent[rootnode]==-1){
            return rootnode;
        }
        return parent[rootnode]=find(parent[rootnode],parent);
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


    public static void main(String[] args) {
        AdjMatrix g=new AdjMatrix(5);
        g.addEdges(0,1,5);
        g.addEdges(0,2,1);
        g.addEdges(0,4,10);
        g.addEdges(1,2,2);
        g.addEdges(1,3,3);
        g.addEdges(2,4,8);
        g.addEdges(3,4,2);

        g.printGraph();

        System.out.println(getAdjNodes(0));
        g.dijakstra(0,4);

    }
}
