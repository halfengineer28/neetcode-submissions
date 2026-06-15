class FreqStack {
    private Map<Integer, Integer> map;
    private List<Integer> stack;
    public FreqStack() {
        map = new HashMap<>();
        stack = new ArrayList<>();
        
    }
    
    public void push(int val) {
        stack.add(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
        
    }
    
    public int pop() {
        int max = Collections.max(map.values());
        
        int i = stack.size()-1;
        while (map.get(stack.get(i)) != max){
            i--;
        }
        int val = stack.remove(i);
        map.put(val, map.get(val) - 1);
        return val;

        


    
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */