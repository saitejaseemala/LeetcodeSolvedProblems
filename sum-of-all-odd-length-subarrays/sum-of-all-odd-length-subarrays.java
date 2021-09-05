class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for(int i = 0; i<arr.length; i++) {
            int eachElementContribution = (int)Math.ceil(((i+1)*(arr.length-i))/2.0);
            sum += eachElementContribution * arr[i];
        }
        return sum;
    }
}
