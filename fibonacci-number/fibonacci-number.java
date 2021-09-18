class Solution {
    public int fib(int N) {
        Double gRatio = 1.618034;
        return (int)((Math.pow(gRatio, N) - Math.pow(1-gRatio, N))/Math.sqrt(5));
    }
}