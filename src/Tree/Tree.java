package Tree;

public class Tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    void inorder(Node root){
        if(root==null){
            return;
        }
        preorder(root.left);
        System.out.println(root.data);
        preorder(root.right);
    }

    void postorder(Node root){
        if(root==null){
            return;
        }

        preorder(root.left);
        preorder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
    }

}

