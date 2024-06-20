class DLLNode{
    int key;
    int val;
    int frequency;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int key, int val){
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }
}

class DoublyLinkedList{
    int listSize;
    DLLNode head;
    DLLNode tail;

    public DoublyLinkedList(){
        this.listSize = 0;
        head = new DLLNode(0,0);
        tail = new DLLNode(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DLLNode curr)
    {
        DLLNode headNext = head.next;
        head.next = curr;
        curr.prev = head;
        curr.next = headNext;
        headNext.prev = curr;
        listSize++;
    }

    public void removeNode(DLLNode curr)
    {
        DLLNode prevNode = curr.prev;
        DLLNode nextNode = curr.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;
    }
}
class LFUCache {
    final int capacity;
    int minFrequency;
    int currSize;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoublyLinkedList> frequencyMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFrequency = 0;
        currSize = 0;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        DLLNode currNode = cache.get(key);
        if(currNode == null)
            return -1;
        update(currNode);
        return currNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0)
            return;
        if(cache.containsKey(key))
        {
            DLLNode currNode = cache.get(key);
            currNode.val = value;
            update(currNode);
        }
        else
        {
            currSize++;
            if(currSize > capacity)
            {
                DoublyLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }
            minFrequency = 1;
            DoublyLinkedList currList = frequencyMap.getOrDefault(1, new DoublyLinkedList());
            DLLNode newNode = new DLLNode(key,value);
            currList.addNode(newNode);
            frequencyMap.put(1,currList);
            cache.put(key, newNode);
        }     
    }

    public void update(DLLNode currNode)
    {
        int currFreq = currNode.frequency;
        DoublyLinkedList currList = frequencyMap.get(currFreq);
        currList.removeNode(currNode);

        if(currFreq == minFrequency && currList.listSize == 0)
        {
            minFrequency++;
        }
        currNode.frequency++;
        DoublyLinkedList newList = frequencyMap.getOrDefault(currNode.frequency, new DoublyLinkedList());
        newList.addNode(currNode);
        frequencyMap.put(currNode.frequency, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */