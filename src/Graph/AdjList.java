package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjList {
    int vertices;
    DoublyLinkedList [] list;
    AdjList(int vertices){
        this.vertices=vertices;
        list=new DoublyLinkedList[vertices];
        for(int i=0;i<vertices;i++){
            list[i]=new DoublyLinkedList();
        }
    }

    public void addEdge(int source, int destination){
        list[source].addNode(destination);
        list[destination].addNode(source);
    }

    public void printGraph(){
        for (int i=0;i<list.length;i++){
            DoublyLinkedList.Node current=list[i].head;
            System.out.print(i+" is connected to ");
            while(current!=null){
                System.out.print(current.data+" ");
                current=current.next;

            }
            System.out.println();

        }
    }
    public List<Integer> getAdjEdges(int i){
        ArrayList<Integer> lists =new ArrayList<>();
        DoublyLinkedList.Node current=list[i].head;

        while(current!=null){
            lists.add(current.data);
            current=current.next;

        }
        return lists;

    }

    public void dijkstra(int source, int destination){
        
    }

    public static void main(String[] args) {
        AdjList adjList=new AdjList(5);

        adjList.addEdge(0,1);
        adjList.addEdge(0,2);
        adjList.addEdge(0,3);
        adjList.addEdge(1,2);
        adjList.addEdge(2,3);
        adjList.addEdge(3,4);

//        adjList.printGraph();
        System.out.println(adjList.getAdjEdges(0));



    }
}
