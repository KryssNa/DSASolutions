package Tree;

public class AVLTree {
    public static class Node{
        Node left;
        Node right;
        int data;
        int height;
        Node(int data){
            this.data=data;
            this.height=1;
            this.left=this.right=null;
        }
    }
    public Node createBst(Node root, int data){
        if(root==null){
            return  new Node(data);
        }
        if(data<root.data){
            root.left=createBst(root.left,data);
        }
        else if (data>root.data) {
            root.right=createBst(root.right,data);
        }
        else{
            return root;
        }
        root.height=1+Math.max(getHeight(root.left),getHeight(root.right));
        int balancefactor=getBalanceFactor(root);

        if(balancefactor>1  && data<root.left.data){
            //ll
            return  rightRotate(root);
        }

        if(balancefactor>1  && data>root.left.data){
            //lr
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
        if(balancefactor<-1 && data>root.right.data){
            //rr

            return  leftRotate(root);
        }

        if(balancefactor<-1 && data<root.right.data){
            //rl
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }

    return root;
    }

    public Node rightRotate(Node y){
        Node x=y.left;
        Node T2=x.right;
        x.right=y;
        y.left=T2;
        y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        return x;
    }

    public Node leftRotate(Node x){
        Node y=x.right;
        Node T2=y.left;
        y.left=x;
        x.right=T2;
        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
        return  y;
    }

    int getBalanceFactor(Node root){
        if(root==null){
            return 0;
        }
        return root.left.height-root.right.height;
    }
    public int getHeight(Node root){
        if(root==null){
            return  0;
        }
        return root.height;
    }
}
