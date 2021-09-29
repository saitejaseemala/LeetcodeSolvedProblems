class Solution {
    public String removeDuplicates(String s) {
        Stack<Character>stack=new Stack<>();
        String res = "";
        for(int i=0;i<s.length();i++) {
            if(stack.size() == 0){
                stack.push(s.charAt(i));         
            }
            else if(stack.size() !=0 && s.charAt(i)==stack.peek()){
                stack.pop();
            }
            else if(stack.size() !=0 && s.charAt(i)!=stack.peek()){
                stack.push(s.charAt(i));
            }
            
        }
        Iterator value = stack.iterator();
        while (value.hasNext()) {
            res = res+value.next();
        }
        return res;
    }
}