package Caching;

import java.util.HashMap;

public class LRUcaching {

int capacity;
HashMap<Integer,Node> map;
    LRUcaching(int capacity){
        this.capacity=capacity;
        map=new HashMap<>();
    }

public static class Node{
        int key;
        int value;
        Node next;
        Node prev;
    Node(int key, int value){
        this.key=key;
        this.value=value;
        this.next=this.prev=null;
    }

}

void  put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
            //remove that node associated with key
        }
        if(map.size()==capacity){
            //remove tail
            remove(tail);
        }
        Node newnode=new Node(key,value);
        insert(newnode);
}

int get(int key){
   Node node=map.get(key);
   if(node ==null){
       return -1;
   }
   remove(node);
   insert(node);
   return node.value;

}
    Node tail=null;
    Node head=null;
public void insert(Node newnode){
    map.put(newnode.key,newnode);
     if(head==null){
         head=tail=newnode;
     }
     else{
         newnode.next=head;
         head.prev=newnode;
         head=newnode;
     }
}

void remove(Node node){
    if(node==null){
        return;
    }
    map.remove(node.key);
    if(node==head){
      head.next.prev=null;
      head=head.next;
      node.next=null;
    }
    else if(node==tail){
        tail.prev.next=null;
        tail=tail.prev;
        node.prev=null;
    }
    else{
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.next=node.prev=null;
    }
}
}
