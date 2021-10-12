/*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

*/
class LRUCache {
    HashMap<Integer,Integer> dict;
    LinkedList<Integer> list;
    int cap;
    public LRUCache(int capacity) {
        dict = new HashMap<Integer,Integer>();
        list = new LinkedList<>();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(dict.containsKey(key)){
            list.remove(Integer.valueOf(key));
            list.addFirst(key);
            return dict.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(dict.containsKey(key)){
            list.remove(Integer.valueOf(key));
            list.addFirst(key);
            dict.put(key,value);
        } else{
        dict.put(key,value);
        if(dict.size()>cap){
            int k = list.removeLast();
            dict.remove(k);
        }
        list.addFirst(key);
        }
    }
}
