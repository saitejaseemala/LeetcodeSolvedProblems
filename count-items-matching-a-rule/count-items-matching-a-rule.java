class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        if(items.size()==0)return 0;
        int j=0;
        if(ruleKey.equals("type")) j=0;
        else if(ruleKey.equals("color")) j=1;
        else if(ruleKey.equals("name")) j=2;
        int count=0;
        
        for(List<String> item :items){
            if(item.get(j).equals(ruleValue)) count++;
        }
        return count;
    }
}