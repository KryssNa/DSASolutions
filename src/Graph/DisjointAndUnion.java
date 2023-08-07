package Graph;

public class DisjointAndUnion {
  int size[];
  int parent[];
  int vertices;
    DisjointAndUnion(int vertices){
        this.vertices=vertices;
        size=new int[vertices];
        parent=new int[vertices];
        for(int i=0;i<vertices;i++){
            parent[i]=-1;
        }
    }

    void detectCycle(int u, int v){
        int u_absroot=find(u);
        int v_absroot=find(v);
        if(u_absroot==v_absroot){
            System.out.println("cycle detected");
            return;
        }
        union(u_absroot,v_absroot);
    }

    public void union(int uroot, int vroot){
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

    int find(int rootnode){
        if(parent[rootnode]==-1){
            return rootnode;
        }
        return parent[rootnode]=find(parent[rootnode]);
    }

    public static void main(String[] args) {
        DisjointAndUnion o=new DisjointAndUnion(4);
        o.detectCycle(0,1);
        o.detectCycle(1,2);
        o.detectCycle(0,2);
    }

}
