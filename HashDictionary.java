public class HashDictionary implements DictionaryADT{
	
	
	private class Node{
		private String key;
		private int value;
		private Node next;
		
		public Node (String key, int value) {
			this.key = key;
			this.value = value;
			
			}
		public String getKey() {
		return this.key;
			}
		public int getValue() {
			return this.value;
			}
		public void setValue() {
			this.value = value;
			}
		
		}
		
		private Node map[];
		private final int size;
		private int recordsCount;
		
		public HashDictionary(int size){
			this.size = size;
			map = new Node[size];
	    }
		
    private int HashFunction(String s){
        int constant = 31;
        int hash = 0;
        for(int i = 0; i < s.length(); i++){
            hash = constant*hash+s.charAt(i);
        }
        return Math.abs(hash);
    }

    

    public int put(Data pair) throws DictionaryException {
        int hash = HashFunction(pair.getConfiguration()) % size;
        int collisions = 0;
        Node entry = map[hash];
        if (entry == null) {
        	map[hash] = new Node(pair.getConfiguration(),pair.getScore());
        	recordsCount++;
        }
        else { 
        	if(entry.getKey() == pair.getConfiguration()) throw new DictionaryException();
        	
        	while(entry.next != null) {
        		entry = entry.next;
        	}
        	collisions++;
        	entry.next = new Node(pair.getConfiguration(),pair.getScore());
        	recordsCount++;
        }
        return collisions;
    }


    public void remove(String config) throws DictionaryException {
    	int hash = HashFunction(config) % size;
    	Node entry = map[hash];
    	
    	if(entry == null) throw new DictionaryException();
    	
    	else {
    		if (entry.getKey() == config) {
    			map[hash] = entry.next;
    			entry.next = null;
    		}
    		
    		Node previous = entry;
    		entry = entry.next;
    		while(entry != null) {
    			if (entry.getKey() == config) {
    				previous.next = entry.next;
    				entry.next = null;
    			}
    			previous = entry;
    			entry = entry.next;
    		}
    		recordsCount--;
    	}
    	
    }


    public int get(String config) {
    	int hash = HashFunction(config) % size;
    	Node entry = map[hash];
    	if ( entry == null) return -1;
    	
    	else {
    		 while(entry.next != null) {
    			 if(entry.getKey() == config) return entry.getValue();
    			 entry = entry.next;
    		 }
    		return map[hash].getValue();
    	}
        
    }


    public int numRecords() {
        return recordsCount;
    }

    public static void main(String[] args) {
        HashDictionary map = new HashDictionary(10);
        
    }
}

	
	
