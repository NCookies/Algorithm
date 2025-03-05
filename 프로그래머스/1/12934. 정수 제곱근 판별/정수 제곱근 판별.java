class Solution {
    public long solution(long n) {
        long s = (long) Math.sqrt(n);
        if (s * s == n) {
            return (long) Math.pow(s + 1, 2);
        } else {
            return -1;
        }
    }
}