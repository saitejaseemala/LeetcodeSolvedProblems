class Solution {
    public String removeOuterParentheses(String s) {
        
        Stack<Character>stack = new Stack<>();
        String resString = "";
        for(int i =0;i<s.length();i++) {
            if(stack.isEmpty()){
               stack.push(s.charAt(i));   
            }
            else {
                if(s.charAt(i)=='(') {
                char ch = stack.push(s.charAt(i));
                resString = resString + ch;
                }
                if(s.charAt(i)==')') {
                    stack.pop();
                    if(!stack.isEmpty()){
                    resString = resString + ')';
                    }
                 }
            }
        }
        return resString;
    }
}