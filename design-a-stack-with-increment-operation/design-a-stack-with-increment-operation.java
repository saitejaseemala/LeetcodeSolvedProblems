class CustomStack {

    private int size;
    private List<Integer> stack = new ArrayList<>();
    
    public CustomStack(int maxSize) {
        this.size = maxSize;
    }
    
    public void push(int x) {
        
        if(stack.size() == size){
            return;
        }
        else {
            stack.add(x);
        }
    }
    
    public int pop() {
        if(stack.size() == 0){
            return -1;
        }
        int element = stack.remove(stack.size()-1);
        return element;
    }
    
    public void increment(int k, int val) {
        if(stack.size()==0){
            return;
        }
        
        if(k>stack.size()){
            for(int i=0;i<stack.size();i++){
                int actVal = stack.get(i);
                stack.set(i,val+actVal);
            }
        }
        if (k <= stack.size()){
           for(int i=0;i<k;i++){
                int actVal = stack.get(i);
                stack.set(i,val+actVal);
            } 
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */