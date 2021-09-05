class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int i = 0;
        int count = 0;
         switch(ruleKey) {
                case "color": 
                 i=1;
                  break;
              case "name":
                 i=2;
                 break;
         }
        for(List<String> item : items) {
            
            if(item.get(i).equals(ruleValue)){
                count++;
               
            }
        }
        return count;
    }
}