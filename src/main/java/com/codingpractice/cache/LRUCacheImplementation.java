package com.codingpractice.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImplementation {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}


class LRUCache {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;

        this.head = new Node(Integer.MIN_VALUE,0);
        this.tail = new Node(Integer.MAX_VALUE,0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key))return -1;

        Node node = map.get(key);
        moveNodeToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveNodeToFront(node);
            return;
        }

        if(size >=capacity){
            removeLRUNode();

        }
        Node node= new Node(key,value);
        addNodeToFront(node);
        map.put(key,node);
    }

    private void addNodeToFront(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
        size++;
    }

    private void moveNodeToFront(Node node) {
        removeNode(node);
        addNodeToFront(node);
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
        size--;
    }

    private void removeLRUNode() {
        Node node = tail.prev;
        Node prev = node.prev;
        prev.next = tail;
        tail.prev = prev;
        map.remove(node.key);
        size--;
    }
}

class Node{
    Node next;
    Node prev;
    int key;
    int value;

    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}

