class LFUCache {
    Map<Integer,int[]> keyValueFreqMap ;
    TreeMap<Integer,LinkedHashSet<Integer>> frequencyMap ;
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyValueFreqMap = new HashMap<>();
        frequencyMap = new TreeMap<>();
    }

    public int get(int key) {
        if(!keyValueFreqMap.containsKey(key)) return -1 ;

        int[] valueFreq = keyValueFreqMap.get(key);

        frequencyMap.get(valueFreq[1]).remove(key);
        if(frequencyMap.get(valueFreq[1]).isEmpty()) frequencyMap.remove(valueFreq[1]);

        valueFreq[1]+=1;
        if(!frequencyMap.containsKey(valueFreq[1])){
            frequencyMap.put(valueFreq[1],new LinkedHashSet<Integer>());
        }
        frequencyMap.get(valueFreq[1]).remove(key);
        frequencyMap.get(valueFreq[1]).add(key);
        return valueFreq[0];
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        int[] valueFreq = keyValueFreqMap.getOrDefault(key, new int[]{value, 1});
        //key is not present in keyValueFreqMap
        if(!keyValueFreqMap.containsKey(key)){
            //if capacity is full
            if(keyValueFreqMap.size() >= capacity){
                //remove LFU
                int leastFreqKey = frequencyMap.keySet().iterator().next();
                LinkedHashSet<Integer> leastFreqValue = frequencyMap.get(leastFreqKey);
                int keyToRemove = leastFreqValue.iterator().next();

                leastFreqValue.remove(keyToRemove);
                if(leastFreqValue.isEmpty()) frequencyMap.remove(leastFreqKey);
                keyValueFreqMap.remove(keyToRemove);
            }
            //if capacity is not full
            keyValueFreqMap.put(key,valueFreq);
            if(!frequencyMap.containsKey(valueFreq[1])){
                frequencyMap.put(valueFreq[1],new LinkedHashSet<Integer>());
            }
            frequencyMap.get(valueFreq[1]).remove(key);
            frequencyMap.get(valueFreq[1]).add(key);
        }
        //key is already present in keyValueFreqMap
        else{
            valueFreq[0]=value;
            frequencyMap.get(valueFreq[1]).remove(key);
            if(frequencyMap.get(valueFreq[1]).isEmpty()) frequencyMap.remove(valueFreq[1]);

            valueFreq[1]+=1;
            if(!frequencyMap.containsKey(valueFreq[1])){
                frequencyMap.put(valueFreq[1],new LinkedHashSet<Integer>());
            }
            frequencyMap.get(valueFreq[1]).remove(key);
            frequencyMap.get(valueFreq[1]).add(key);
        }

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */