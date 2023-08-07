package Hash;

public class SaperateChaining {

    public class Node{
        int key;
        int value;
        Node next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.next=null;
        }

    }

    Node hastable[];
    int size;
    SaperateChaining(int size){
       this.size=size;
       hastable=new Node[size];
    }

    int hashFuncation(int key){
       return (2*key+3)%size;
    }


    void insert(int key, int value){
        int location=hashFuncation(key);
        Node newnode=new Node(key,value);
        if(hastable[location]==null){
            hastable[location]=newnode;
        }
        else{
           Node current= hastable[location];
           while(current.next!=null){
               if(current.key==key){
                   current.value=value;
                   return;
               }
               current=current.next;
           }
           current.next=newnode;
        }
    }

    public int get(int key){
        int location=hashFuncation(key);


        Node current=hastable[location];
        while(current!=null){
            if(current.key==key){
                return hastable[location].value;
            }
            current=current.next;
        }

        return -1;
    }
}
