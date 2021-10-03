class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        for(char c : s.toCharArray()){
            
            if ( c != '#') {
                s1.append(c);
            }
            
           else if (s1.length()!=0) {
                s1.deleteCharAt(s1.length()-1);
            }
        }
          for(char c : t.toCharArray()){
             if ( c != '#') {
                s2.append(c);
            }
            
           else if (s2.length()!=0) {
                s2.deleteCharAt(s2.length()-1);
            }
        }
        System.out.println(s1);
                System.out.println(s2);

        return (s1.toString().equals(s2.toString()));
    }
}