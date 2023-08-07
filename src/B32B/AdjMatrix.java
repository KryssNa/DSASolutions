package B32B;

public class AdjMatrix {

    int V;
    int E;
    int[][] matrix;

    AdjMatrix(int vertices) {
        this.V = vertices;
        this.E = 0;
        this.matrix = new int[vertices][vertices];
    }

    void addEdge(int u, int v) { // u and v are the nodes u=sources and v = destination
        matrix[u][v] = 1;
        matrix[v][u] = 1;
        E++;
    }
    public  void printGraph(){
        for(int i=0;i<V;i++){
            System.out.print(i+" is connected to: ");
            for(int j=0;j<V;j++){
                if(matrix[i][j]!=0){
                    System.out.print(j+" ");
                }

            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        AdjMatrix graph = new AdjMatrix(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        graph.printGraph();
    }
}
