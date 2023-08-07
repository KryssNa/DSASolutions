package Graph.HW;

import Graph.AdjMatrix;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static Graph.HW.AdjMatrix.matrix;
import static Graph.HW.AdjMatrix.vertices;

public class ShotestPathUsingModifiedBFS {
// write an algorithm to find the shortest distance of unweighted graph using modified BFS

    public static void BFS(int source,int destination){
        List<Integer> list=new LinkedList<>();
        list.add(source);
        boolean [] visited=new boolean[vertices];
        int [] dist=new int[vertices];
        int [] prevpath=new int[vertices];
        Arrays.fill(prevpath,-1);
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source]=0;
        while(!list.isEmpty()){
            Iterator<Integer> iterator=list.iterator();
            int current=iterator.next();
            visited[current]=true;
            for(int i=0;i<vertices;i++){
                if(matrix[current][i]!=0){
                    if(!visited[i] &&(dist[current]+matrix[current][i]<dist[i])){
                        dist[i]= dist[current]+matrix[current][i];
                        prevpath[i]=current;
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
    public static void main(String[] args) {
//        ShotestPathUsingModifiedBFS adjMatrix=new ShotestPathUsingModifiedBFS();
//        matrix[0][1]=1;
//        matrix[0][2]=1;
//        matrix[1][3]=1;
//        matrix[2][3]=1;
//        matrix[3][4]=1;
//        matrix[2][4]=1;
//        adjMatrix.BFS(0,4);
    }
}
