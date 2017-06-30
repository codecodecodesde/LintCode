public class LRUCache {
    private class DoublyNode{
        DoublyNode prev;
        DoublyNode next;
        int key;
        int value;
        
        public DoublyNode(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, DoublyNode> map = new HashMap<Integer, DoublyNode>();
    private DoublyNode newest = new DoublyNode(-1, -1);
    private DoublyNode oldest = new DoublyNode(-1, -1);
    
    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        this.capacity = capacity;
        oldest.next = newest;//tail == old
        newest.prev = oldest;
    }
    
    // @return an integer
    public int get(int key) {
        // write your code here
        if(!map.containsKey(key)){
            return -1;
        }
        
        DoublyNode current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        
        move_to_newest(current);
        
        return map.get(key).value;
        
    }
    
    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        
        if(get(key) != -1){
            map.get(key).value = value;
            return;
        }
        
        if(map.size() == capacity){
            map.remove(oldest.next.key);
            oldest.next = oldest.next.next;
            oldest.next.prev = oldest;
        }
        
        DoublyNode newNode = new DoublyNode(key, value);
        map.put(key, newNode);
        move_to_newest(newNode);
        return;
    }
    
    private void move_to_newest(DoublyNode current){
        current.prev = newest.prev;
        newest.prev = current;
        current.prev.next = current;
        current.next = newest;
    }
}