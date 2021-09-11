class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        int rem = 0;
        while(n>0){
            rem = n % 10;
            n = n/10;
            sum = sum + rem;
            product = product * rem;
        }
        
        return product - sum;
    }
}