package linkedlists;

import java.util.HashMap;

public class LRUCache {
    class Node {
        int key, value; Node prev, next;
        Node(int k, int v){ key=k; value=v; }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    private void remove(Node node) {
        if(node.prev!=null) node.prev.next=node.next;
        else head=node.next;
        if(node.next!=null) node.next.prev=node.prev;
        else tail=node.prev;
    }

    private void addFirst(Node node){
        node.next=head;
        node.prev=null;
        if(head!=null) head.prev=node;
        head=node;
        if(tail==null) tail=node;
    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        remove(node);
        addFirst(node);
        return node.value;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            remove(node);
            addFirst(node);
        } else {
            Node node=new Node(key,value);
            if(map.size()==capacity){
                map.remove(tail.key);
                remove(tail);
            }
            addFirst(node);
            map.put(key,node);
        }
    }
}
