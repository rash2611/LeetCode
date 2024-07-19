class Logger {
    HashMap<String, Integer> oldMap;
    HashMap<String, Integer> newMap;
    int oldestTimeInMap;
    public Logger() {
        oldMap = new HashMap<>();
        newMap = new HashMap<>();
        oldestTimeInMap = Integer.MIN_VALUE;
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp >= oldestTimeInMap + 10)
        {
            HashMap<String,Integer> temp = oldMap;
            oldMap = newMap;
            newMap = temp;
            newMap.clear();
            oldestTimeInMap = timestamp;
        }

        if(newMap.containsKey(message))
            return false;
        if(oldMap.containsKey(message))
        {
            int oldestTimestampOfCurrentMsg = oldMap.get(message);
            if(oldestTimestampOfCurrentMsg + 10 > timestamp)
                return false;
        }
        newMap.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */