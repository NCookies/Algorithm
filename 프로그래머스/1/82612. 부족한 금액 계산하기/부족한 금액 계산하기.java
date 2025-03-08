class Solution {
    public long solution(int price, int money, int count) {
        // 등차수열 공식 이용
        long payment = (long) price * ((count * (count + 1)) / 2);
        return money >= payment ? 0 : payment - money;
    }
}