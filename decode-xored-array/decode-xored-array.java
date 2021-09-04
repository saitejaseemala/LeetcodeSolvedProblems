class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length+1];
        
        decoded[0] = first;
        int index = 1;
        
        for(int i=0; i<encoded.length; i++){
            decoded[index] = decoded[i] ^ encoded[i];
            index++;
        }
        return decoded;
    }
}