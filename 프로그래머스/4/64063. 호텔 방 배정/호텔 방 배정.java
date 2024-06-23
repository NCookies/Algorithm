import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        // key : 방 번호, value : 현재 방보다 크면서 비어있는 방
        // value는 초기 상태로 현재 방 번호보다 1 큰 숫자를 가진다.
        Map<Long, Long> rooms = new HashMap<>();

        for (int i = 0; i < room_number.length; i++) {
            // 배정되지 않은 빈 방이라면
            if (!rooms.containsKey(room_number[i])) {
                // 그대로 원하는 방 배정
                answer[i] = room_number[i];

                // 방 배정됐으면 hash 데이터 추가
                rooms.put(room_number[i], room_number[i] + 1);
            }
            // 빈 방이 아니라면 다음 방을 탐색한다.
            else {
                List<Long> updateRoomList = new ArrayList<>();
                updateRoomList.add(room_number[i]);

                long nextRoom = rooms.get(room_number[i]);

                while (true) {
                    // 할당되지 않은 빈 방임
                    if (!rooms.containsKey(nextRoom)) {
                        answer[i] = nextRoom;
                        rooms.put(nextRoom, nextRoom + 1);
                        break;
                    }
                    // 이미 할당된 방일 경우 다음 방을 갱신하기 위해 리스트에 저장해둔다.
                    else {
                        updateRoomList.add(nextRoom);
                        nextRoom = rooms.get(nextRoom);
                    }
                }

                // 확인했던 방들의 다음 방 번호 갱신
                for (Long aLong : updateRoomList) {
                    rooms.put(aLong, nextRoom + 1);
                }
            }
        }

        return answer;
    }
}