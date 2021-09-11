class Solution {
    public int findGCD(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for(int num:nums){
        
            if(num>max){
                max=num;
            }
            if(num<min){
                min=num;
            }
        }
        
        while(min!=0){
            temp = min;
            min = max%min;
            max = temp;
            
        }
        return max;
    }
}