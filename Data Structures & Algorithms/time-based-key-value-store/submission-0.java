class TimeMap {
    Map<Integer, Map<String, String>> timeMap;
    public TimeMap() {
         timeMap = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void set(String key, String value, int timestamp) {
         this.timeMap.putIfAbsent(timestamp, new HashMap<String, String>());
        this.timeMap.get(timestamp).put(key, value);
    }
    
    public String get(String key, int timestamp) {
        for(Map.Entry<Integer, Map<String,String>> entry : timeMap.entrySet()) {
            if(entry.getKey() <= timestamp && 
                    entry.getValue().containsKey(key)) return entry.getValue().get(key);
        }
        return "";
    }
}
