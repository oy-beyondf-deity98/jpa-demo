오류 페이지를 위한 것을 작성하자.

1. 사용자의 입력 오류 확인
2. 시스템의 입력 오류 확인
3. 로직 오류 확인
4. 서버가 정상인가 확인


1XX는 Information responses로 그냥 하면된다.

2XX는 성공적인 처리
  - 200 성공
  - 201 created 되었지만 리턴은 없음
    - 추가/수정/삭제 할때 보내는 내용같다.
  - 204 요청에 대해서 보내줄 내용이 없음
  - 205 초기화 할 것
3XX는 다른곳으로 이동되었음을
  - 301 리다이렉트, 해당소스는 다른곳으로 이동되었음을 나타낸다.
  - 306 
4XX는 사용자 오류
  - 400 서버가 요청을 이해할수 없음
  - 401 인증 되지 않는 사용자
  - 403 접근 금지된 리소스 요청
  - 404 찾을수 없음, 리소스가 없습니다.
  - 408 시간 초과, 요청이 오래된 연결
5XX는 서버 오류이다.
  - 500 서버오류
  - 502 잘못된 요청, 내부적으로 잘못
  - 503 서버가 서비스 중지된 상태
  - 504 타임아웃

위 메서드를 모두 명시할 필요가 있을까? 싶다..
그냥은 모두 200이고, 추가적으로 할것만 넣으면 될것 같다.

200 성공
201로 추가/수정/삭제 된것은 표시한다.
  - 다른곳으로 이동한 것도 표시한다.
  - 201, 204, 205는 비슷한 의미로 보인다.. 201로 통일하자

400 으로 validation 체크를 해서 해당 값이 충족되지 않으면 오류나도록 한다.
404는 데이터가 없는 것을 조회했을때 처리한다.
  - 근데 404는 오류로 내보내는 것은 이상하다... 200으로 하고 특정한 메세지를 내보내는 것이 좋지 않는가?
401, 403는 같게 처리한다.

500 으로 오류를 내보낸다. 

502는 내부적인 오류, 
503은 서비스 중지된 상태

408과 504는 타임아웃

---

포탈쪽은 이미 처리가 되도록 되어 있는 것 같다. API만들때 위의값을 사용하도록 하자.

302는 이미 서버가 처리하네?


포탈은 400부터를 다르게 보여주면 될것 같다.

