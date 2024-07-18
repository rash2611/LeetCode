class MRUQueue {
    ArrayList<Integer> list;
    public MRUQueue(int n) {
        list = new ArrayList<>(n);
        for(int i = 1;i<=n;i++)
        {
            list.add(i);
        }
    }
    
    public int fetch(int k) {
        int element = list.remove(k-1);
        list.add(element);
        return element;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */