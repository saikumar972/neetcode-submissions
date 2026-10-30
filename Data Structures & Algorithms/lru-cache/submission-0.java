class LRUCache {
    int capacity;
    HashMap<Integer, CacheNode> map;
    CacheNode head;
    CacheNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;

        this.map = new HashMap<>();

        this.head = new CacheNode(-1, -1);
        this.tail = new CacheNode(-1, -1);

        head.nextNode = tail;
        tail.prevNode = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);

            moveNodeToHead(node);

            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
         if (map.containsKey(key)) {

            CacheNode node = map.get(key);

            node.value = value;

            moveNodeToHead(node);

        } else if (map.size() >= capacity) {

            removeFromTail();

            addToHead(key, value);

        } else {

            addToHead(key, value);
        }
    }
public void addToHead(int key, int value) {

        CacheNode node = new CacheNode(key, value);

        CacheNode nextNode = head.nextNode;

        head.nextNode = node;

        node.nextNode = nextNode;

        nextNode.prevNode = node;

        node.prevNode = head;

        map.put(key, node);
    }

    public void removeFromTail() {

        CacheNode lruNode = tail.prevNode;

        lruNode.prevNode.nextNode = tail;
        tail.prevNode = lruNode.prevNode;

        map.remove(lruNode.key);
    }

    public void moveNodeToHead(CacheNode node) {

        if (node == head.nextNode) {
            return;
        }

        CacheNode nextNode = node.nextNode;
        CacheNode prevNode = node.prevNode;
        CacheNode headNextNode = head.nextNode;

        // Remove node from current position
        prevNode.nextNode = nextNode;
        nextNode.prevNode = prevNode;

        // Add node after head
        head.nextNode = node;
        node.prevNode = head;

        node.nextNode = headNextNode;
        headNextNode.prevNode = node;
    }
}

class CacheNode {

    CacheNode prevNode;
    int key;
    int value;
    CacheNode nextNode;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
