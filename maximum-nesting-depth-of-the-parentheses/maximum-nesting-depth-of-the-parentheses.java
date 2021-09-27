class Solution {
    public int maxDepth(String s) {
        Stack<Character>stack = new Stack<>();
        int count = 0;
       
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
            {
              stack.push(s.charAt(i));
              
               if(count < stack.size()){
                  count = stack.size();
               }
            }
            if(s.charAt(i) == ')')
            {
              stack.pop();  
            }
        }
        return count;
    }
}