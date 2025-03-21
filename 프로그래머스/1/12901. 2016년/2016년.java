class Solution {
    public String solution(int a, int b) {
        // 윤년의 2월은 29일
        // 1월 31일, 3월 31일, 4월 30일, 5월 31일...
        // 월별 날짜
        int[] monothDays = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        // 요일
        String[] weekDays = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        
        int days = 0;
        for (int i = 1; i < a; i++) {
            days += monothDays[i];
        }
        days += b;
        
        return weekDays[(days - 1) % 7];
    }
}