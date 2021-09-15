class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        int count = 0;
        
        for(int j=0;j<stones.length();j++){
            if(jewels.contains(String.valueOf(stones.charAt(j)))){
                count++;
            }
        }
        
        return count;
    }
}