class Solution {
    public int maxArea(int[] height) {
        int start=0;
        int end=height.length-1;
        int volume=0;
        int max=0;

            
            while(start<end){
                if(height[start]<height[end]){
                    volume=height[start]*(end-start);
                    start++;
                }
                else
                {
                    volume=height[end]*(end-start);
                    end--;
                }
                if(max<volume){
                    max=volume;
                }
            }

        return max;
    }
}