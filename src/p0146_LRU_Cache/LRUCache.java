package p0146_LRU_Cache;

import java.util.LinkedHashMap;

public class LRUCache {

	private int capacity;
	private LinkedHashMap<Integer, Integer> map;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	int value = map.get(key);
        	map.remove(key);
        	map.put(key, value);
        	return value;
        } else {
			return -1;
		}
    }
    
    public void put(int key, int value) {
    	if(map.containsKey(key)) {
    		map.remove(key);
    	} else {
    		if(map.size() >= capacity) {
        		map.remove(map.keySet().iterator().next());
        	}
		}
    	map.put(key, value);
    }
}
