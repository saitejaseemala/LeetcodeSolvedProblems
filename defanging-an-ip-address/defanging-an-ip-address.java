class Solution {
    public String defangIPaddr(String address) {
        
        String newad = address.replace(".","[.]");
        return newad;
    }
}