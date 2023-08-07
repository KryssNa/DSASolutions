package Tree;

public class BST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=right=null;
        }
    }

    public Node createBst(Node root, int data){

        if(root==null){
            return new Node(data);
        }

        if(data< root.data){
            root.left=createBst(root.left,data);
        }
        else if(data> root.data){
            root.right=createBst(root.right,data);
        }

        return root;
    }


    public Node removeNode(Node root, int data){
        if(root==null){
            return null;
        }

        if(data<root.data){
            root.left=removeNode(root.left,data);
        }
        else if(data>root.data){
            root.right=removeNode(root.right,data);
        }
        else{
            //case 1 and case 2
            if(root.left==null){
                return root.right;
            }

            if(root.right==null){
                return root.left;
            }
            root.data=findMin(root.right);
            removeNode(root.right, root.data);
        }
        return  root;
    }

    public int findMin(Node root){
        int min=root.data;
        while(root.left!=null){
            min=root.left.data;
            root=root.left;
        }
        return  min;
    }

    Node search(Node root, int data){
        if(root==null || data==root.data){
            return root;
        }
        if(data<root.data){
            return search(root.left,data);
        }
        return search(root.right,data);
    }
}
