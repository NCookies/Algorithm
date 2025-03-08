class Solution {
    public long solution(long n) {
        double s = Math.sqrt(n);
        return n % s == 0 ? (long) Math.pow(s + 1, 2) : -1;
    }
}