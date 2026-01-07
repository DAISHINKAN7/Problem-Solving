import java.util.*;
public class LRUCache {
    final Node head = new Node(-1, -1);
    final Node tail = new Node(-1, -1);

    Map<Integer, Node> map;
    int capacity;

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node){
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;

    }

    public void remoeNode(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
    
    public int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if(node != null){
            result = node.value;
            remoeNode(node);
            addNode(node);
        }
        return result;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null){
            remoeNode(node);
            node.value = value;
            addNode(node);
        }else{
            if(map.size() == capacity){
                Node tailPrev = tail.prev;
                map.remove(tailPrev.key);
                remoeNode(tailPrev);
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
            map.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
